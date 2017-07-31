package com.spider.microcommercial.controllers.rest;


import com.spider.microcommercial.dto.chat.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/rest/chat")
public class ChatController {
    private Logger logger = LoggerFactory.getLogger(ChatController.class);

    private final List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());

    @RequestMapping(path = "/post", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ChatMessage jsonCreate(@RequestBody ChatMessage chatMessage) throws IOException {
        logger.info("Message received -> resending to " + sseEmitters.size() + " client(s)");
        synchronized (sseEmitters) {
            for (SseEmitter sseEmitter : sseEmitters) {
                sseEmitter.send(chatMessage, MediaType.APPLICATION_JSON);
            }
        }
        return chatMessage;
    }

    @RequestMapping("/sse/updates")
    public ResponseEntity<SseEmitter> subscribeUpdates() {
        SseEmitter sseEmitter = new SseEmitter(TimeUnit.MINUTES.toMillis(1));
        synchronized (sseEmitters) {
            this.sseEmitters.add(sseEmitter);
            logger.info("Client connected");
            sseEmitter.onCompletion(() -> {
                synchronized (sseEmitters) {
                    sseEmitters.remove(sseEmitter);
                    logger.info("Client disconnected");
                }
            });
        }
        return ResponseEntity.ok(sseEmitter);
    }
}

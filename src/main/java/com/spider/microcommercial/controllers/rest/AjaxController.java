package com.spider.microcommercial.controllers.rest;

import com.spider.microcommercial.dto.chat.ChatMessage;
import com.spider.microcommercial.dto.chat.ChatMessageExtend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/ajax")
public class AjaxController {
    /**
     * 测试简单参数类型
     * @param msg
     * @param counter
     * @return
     */
    @RequestMapping("/testSimpleParam")
    public @ResponseBody ModelMap testSimpleParam(String msg, Integer counter) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("text", "testSimpleParam");
        modelMap.addAttribute("msg", msg);
        modelMap.addAttribute("counter", counter);
        return modelMap;
    }

    /**
     * 测试复杂数据类型
     * @param chatMessage
     * @return
     */
    @RequestMapping("/testObjectParam")
    public @ResponseBody ModelMap testObjectParam(ChatMessage chatMessage) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("text", "testObjectParam");
        modelMap.addAttribute("author", chatMessage.getAuthor());
        modelMap.addAttribute("message", chatMessage.getMessage());
        return modelMap;
    }

    /**
     * 测试复杂数据类型
     * @param chatMessage
     * @return
     */
    @RequestMapping("/testComplexObjectParam")
    public @ResponseBody ModelMap testComplexObjectParam(@RequestBody ChatMessageExtend chatMessage) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("text", "testObjectParam");
        modelMap.addAttribute("name", chatMessage.getName());
        modelMap.addAttribute("author", chatMessage.getChatMessage().getAuthor());
        modelMap.addAttribute("message", chatMessage.getChatMessage().getMessage());
        return modelMap;
    }
}

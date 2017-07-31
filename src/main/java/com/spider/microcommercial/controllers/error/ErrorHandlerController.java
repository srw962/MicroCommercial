package com.spider.microcommercial.controllers.error;

import com.google.common.collect.Lists;
import com.spider.microcommercial.dto.error.ServerErrorDTO;
import org.apache.catalina.connector.ClientAbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandlerController {
    private Logger logger = LoggerFactory.getLogger(ErrorHandlerController.class);

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public void procesHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
        logger.debug(ex.getMessage(), ex);
    }

    @ExceptionHandler(ClientAbortException.class)
    public void processClientAbortException(ClientAbortException ex) {
        logger.debug(ex.getMessage(), ex);
        logger.debug("client disconected");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ServerErrorDTO processException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return new ServerErrorDTO(ex.getClass().getCanonicalName(), ex.getMessage(), Lists.newArrayList());
    }

}

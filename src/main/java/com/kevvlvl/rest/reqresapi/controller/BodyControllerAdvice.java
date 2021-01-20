package com.kevvlvl.rest.reqresapi.controller;

import com.kevvlvl.rest.reqresapi.Constants;
import com.kevvlvl.rest.reqresapi.dto.HeaderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Slf4j
public class BodyControllerAdvice implements ResponseBodyAdvice<String> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public String beforeBodyWrite(String body,
                                     MethodParameter methodParameter,
                                     MediaType mediaType,
                                     Class<? extends HttpMessageConverter<?>> aClass,
                                     ServerHttpRequest serverHttpRequest,
                                     ServerHttpResponse serverHttpResponse) {

        log.info("beforeBodyWrite() - update response header post-processing");
        serverHttpResponse.getHeaders().add(Constants.HEADER_POST_PROCESSED, "true");

        return body;
    }
}

package com.kevvlvl.rest.reqresapi.bean;

import com.kevvlvl.rest.reqresapi.dto.HeaderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class RequestInit {

    public static final String HEADER_CLIENT_ID = "APP-CLIENTID";

    @Bean("headerDto")
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HeaderDto getHeaderDto() {

        log.info("getHeaderDto - init HeaderDTO and parse header");
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        HeaderDto dto = new HeaderDto();
        dto.setClientId(request.getHeader(HEADER_CLIENT_ID));

        return dto;
    }
}

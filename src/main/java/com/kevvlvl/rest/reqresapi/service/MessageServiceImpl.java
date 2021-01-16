package com.kevvlvl.rest.reqresapi.service;

import com.kevvlvl.rest.reqresapi.dto.HeaderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final HeaderDto headerDto;

    public MessageServiceImpl(@Qualifier("headerDto") HeaderDto headerDto) {

        this.headerDto = headerDto;
    }

    @Override
    public String buildMessage() {

        log.info("buildMessage");

        String message = String.format("Hello clientId %s", this.headerDto.getClientId());
        log.info("message formed: {}", message);

        return message;
    }
}

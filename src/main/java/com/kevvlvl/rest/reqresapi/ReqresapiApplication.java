package com.kevvlvl.rest.reqresapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ReqresapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReqresapiApplication.class, args);
    }

}

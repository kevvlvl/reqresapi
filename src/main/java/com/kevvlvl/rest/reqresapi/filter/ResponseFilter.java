package com.kevvlvl.rest.reqresapi.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/api/msg")
@Slf4j
public class ResponseFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        log.info("doFilter() - update Response header for all requests - pre-processing");

        httpServletResponse.setHeader("X-RECEIVE-STATUS", "true");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

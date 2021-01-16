package com.kevvlvl.rest.reqresapi.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/api/msg")
@Slf4j
public class ResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        log.info("doFilter - update Response header");

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("APP-REQUEST-STATUS", "Success");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

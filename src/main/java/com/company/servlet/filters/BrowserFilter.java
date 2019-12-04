package com.company.servlet.filters;

import com.sun.deploy.net.HttpRequest;
import sun.plugin2.util.BrowserType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BrowserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String userAgent = httpRequest.getHeader("User-Agent");
        if (userAgent.toLowerCase().contains("edge")) {
            servletRequest.setAttribute("message", "Вам здесь не рады");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

package com.geeks.danda.filters;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.geeks.danda.models.responses.ApiResponse;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.AccessDeniedException;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlingFilter implements Filter {

    private final ObjectMapper objectMapper;

    @Autowired
    public ExceptionHandlingFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        try {
            chain.doFilter(httpServletRequest, httpServletResponse);
        }
        catch (AccessDeniedException e) {
            httpServletResponse.setHeader("Content-type", MediaType.APPLICATION_JSON_VALUE);
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage(e.getMessage());
            httpServletResponse.getOutputStream().println(objectMapper.writeValueAsString(apiResponse));
        }
        catch (RuntimeException e) {
            httpServletResponse.setHeader("Content-type", MediaType.APPLICATION_JSON_VALUE);
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("Shit went wrong due to: " + e);
            httpServletResponse.getOutputStream().println(objectMapper.writeValueAsString(apiResponse));
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

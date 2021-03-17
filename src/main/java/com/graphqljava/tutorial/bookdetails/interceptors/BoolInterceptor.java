package com.graphqljava.tutorial.bookdetails.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class BoolInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(BoolInterceptor.class);

    @Override
    public boolean preHandle(
            @Nonnull final HttpServletRequest request,
            @Nonnull final HttpServletResponse response,
            @Nonnull final Object handler
    ) {
        request.setAttribute("Random", "random");
        return StringUtils.hasText(request.getHeader("Something"));
    }

    @Override
    public void postHandle(
            @Nonnull final HttpServletRequest request,
            @Nonnull final HttpServletResponse response,
            @Nonnull final Object handler,
            @Nullable final ModelAndView modelAndView
    ) {
        LOG.info((String) request.getAttribute("Random"));
    }

}

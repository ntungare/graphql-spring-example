package com.graphqljava.tutorial.bookdetails.context;

import com.google.common.collect.ImmutableMap;
import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CustomContextBuilder implements DgsCustomContextBuilder<Map<String, String>> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomContextBuilder.class);

    @Override
    public Map<String, String> build() {
        LOG.info("Thread details");
        final Map<String, String> context = new HashMap<>();
        final Optional<HttpServletRequest> optionalHttpServletRequest = getCurrentHttpRequest();
        if (optionalHttpServletRequest.isPresent()) {
            final HttpServletRequest httpServletRequest = optionalHttpServletRequest.get();

            final Optional<Cookie[]> cookies = Optional.ofNullable(httpServletRequest.getCookies());

            if (cookies.isPresent()) {
                for (final Cookie cookie : cookies.get()) {
                    final String cookieName = cookie.getName();
                    final String cookieValue = cookie.getValue();

                    context.put(cookieName, cookieValue);
                }
            }

            final Enumeration<String> headerNames = httpServletRequest.getHeaderNames();

            while (headerNames.hasMoreElements()) {
                final String headerName = headerNames.nextElement();
                final String headerValue = httpServletRequest.getHeader(headerName);

                context.put(headerName, headerValue);
            }
        }
        return ImmutableMap.<String, String>builder()
                .put("somethingElse", "somethingElse")
                .putAll(context)
                .build();
    }

    public static Optional<HttpServletRequest> getCurrentHttpRequest() {
        return Optional.ofNullable(RequestContextHolder.getRequestAttributes())
                .filter(requestAttributes -> ServletRequestAttributes.class
                        .isAssignableFrom(requestAttributes.getClass()))
                .map(requestAttributes -> (ServletRequestAttributes) requestAttributes)
                .map(ServletRequestAttributes::getRequest);
    }

}

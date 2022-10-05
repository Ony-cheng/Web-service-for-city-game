package ony.code.filters;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebFilter(urlPatterns = "/szfgbxbf")
public class CharsetFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(response) {
            @Override
            public String getCharacterEncoding() {
                String encoding = super.getCharacterEncoding();
                if (MediaType.TEXT_HTML_VALUE.equals(getContentType()) &&
                        !StandardCharsets.UTF_8.name().contentEquals(encoding)) {
                    return StandardCharsets.UTF_8.name();
                }
                return encoding;
            }
        };

        filterChain.doFilter(request, wrappedResponse);
    }
}
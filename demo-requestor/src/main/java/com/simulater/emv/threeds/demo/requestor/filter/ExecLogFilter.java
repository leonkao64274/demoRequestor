package com.demo.req.emv.validation.demo.requestor.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

public class ExecLogFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(ExecLogFilter.class);
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		if (servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse) {
			// HTTP Request/Response
			HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            // HTTP Request/Response wrapper
            HttpServletRequest requestToCache = new ContentCachingRequestWrapper(request);
            HttpServletResponse responseToCache = new ContentCachingResponseWrapper(response);
            
            logger.info("==========================================================");
            logger.debug("HTTP REQUEST");
            logger.debug("[Path]: " + request.getRequestURI());
            logger.debug("[remoteAddr]: " + request.getRemoteAddr());
            logger.debug("[remoteHost]: " + request.getRemoteHost());
            logger.debug("[content-type]: " + request.getContentType());
			
            long startTime = System.currentTimeMillis();
            try {
                chain.doFilter(requestToCache, responseToCache);
            } catch (IOException | ServletException ex) {
                throw ex;
            } finally {
            	String requestData = getRequestData(requestToCache);
                logger.debug("[requestData]: " + requestData);
            }
            long endTime = System.currentTimeMillis();
            
            logger.debug("HTTP RESPONSE");
            logger.debug("[execTime(miniSec)]: " + (endTime - startTime));
            
            String responseData = getResponseData(responseToCache);
            if (request.getContentType() != null && 
            	(request.getContentType().startsWith("application/json") || request.getContentType().startsWith("application/jose"))) {
                logger.debug("[responseData]: " + responseData);
            }
            logger.info("==========================================================");
			
		} else {
			// Other Request/Response
			chain.doFilter(servletRequest, servletResponse);
		}
	}
	
	private static String getRequestData(final HttpServletRequest request) throws UnsupportedEncodingException {
        String payload = null;
        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
            }
        }
        return payload;
    }
    
    private static String getResponseData(final HttpServletResponse response) throws IOException {
        String payload = null;
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                wrapper.copyBodyToResponse();
            }
        }
        return payload;
    }  

}

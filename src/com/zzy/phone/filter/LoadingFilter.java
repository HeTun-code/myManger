package com.zzy.phone.filter;


import com.zzy.phone.utils.TokenUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoadingFilter implements Filter {


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServleteResponse = (HttpServletResponse) servletResponse;
        String getToken = httpServletRequest.getHeader("token");
        String token = TokenUtils.isLogin(getToken);
        if (handleStaticResource(filterChain, httpServletRequest, httpServleteResponse)) {

            return;
        }
        if (null != token) {
            httpServleteResponse.setHeader("token", token);
            filterChain.doFilter(httpServletRequest, httpServleteResponse);
            return;
        }
    }



    private boolean handleStaticResource(FilterChain chain, HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String uri = req.getRequestURI();
        uri = uri.substring(uri.lastIndexOf("/") + 1);
        if (uri.equals("getMessage.action")||uri.equals("login.action")) {
            chain.doFilter(req, resp);
            return true;
        }

        return false;
    }
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void destroy() {

    }
}

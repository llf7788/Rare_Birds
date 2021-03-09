package edu.neu.birds.interceptor;

import edu.neu.birds.constant.SessionConstant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute(SessionConstant.SESSION_ATTR_USER) != null) {
            return true;
        }

        response.sendRedirect("/user/login?next=".concat(request.getRequestURI()));
        return false;
    }

}

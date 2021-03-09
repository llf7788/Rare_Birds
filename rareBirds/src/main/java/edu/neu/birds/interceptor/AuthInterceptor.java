package edu.neu.birds.interceptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.neu.birds.constant.RoleConstant;
import edu.neu.birds.constant.SessionConstant;
import edu.neu.birds.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);

    private static final Map<String, List<String>> roleToPath = Maps.newHashMap();

    static {
        roleToPath.put(RoleConstant.MANAGER, Lists.newArrayList("/", "/manage"));
        roleToPath.put(RoleConstant.ADMIN, Lists.newArrayList("/", "/manage", "/admin"));
        roleToPath.put(RoleConstant.USER, Lists.newArrayList("/"));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute(SessionConstant.SESSION_ATTR_USER);

        String path = "/";
        if (request.getRequestURI().startsWith("/admin")) {
            path = "/admin";
        } else if (request.getRequestURI().startsWith("/manage")) {
            path = "/manage";
        }

        if (roleToPath.get(user.getRole()).contains(path)) {
            return true;
        }

        response.sendRedirect("/auth");
        return false;
    }

}

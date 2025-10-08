package com.rays.common;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class FrontCtl extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // ---- Always set CORS headers ----
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // ---- Handle Preflight (OPTIONS) requests ----
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return false; // Do not continue further
        }

        HttpSession session = request.getSession();
        String path = request.getServletPath();

        System.out.println("FrontCtl => SessionID: " + session.getId() + " | Path: " + path);

        // ---- Auth APIs bypass ----
        if (!path.startsWith("/Auth/")) {
            if ((UserContext) session.getAttribute("userContext") == null) {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                PrintWriter out = response.getWriter();
                out.print("{\"success\":\"false\",\"error\":\"OOPS! Your session has been expired\"}");
                out.close();

                System.out.println("Session missing => returning false");
                return false;
            }
        }

        return true;
    }
}

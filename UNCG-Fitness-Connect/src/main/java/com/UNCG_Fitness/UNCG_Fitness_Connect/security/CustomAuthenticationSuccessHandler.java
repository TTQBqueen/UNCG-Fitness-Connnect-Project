package com.UNCG_Fitness.UNCG_Fitness_Connect.security;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
    @Autowired
    private UserRepository repo;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {

        String redirectURL = request.getContextPath();

        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            redirectURL = "/ADMIN/users/all";
        } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("INSTRUCTOR"))) {
            redirectURL = "/classes/all";
        } else {
            redirectURL = "/home";
        }

        response.sendRedirect(redirectURL);
    }

}


package com.example.sysadm.interceptor;

import com.example.sysadm.model.Operador;
import com.example.sysadm.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AutheticationInterceptor implements HandlerInterceptor {

    private final String key = "String aleatoria";

    private UserService userService;

    @Autowired
    public AutheticationInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getServletPath().contains("login")) {
            return true;
        }
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        try {
            String token = authorizationHeader.substring("Bearer".length()).trim();

            String login = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            Operador operador = userService.buscarOperadorPorLogin(login);
            AuthenticationData.setLoggedUser(operador);
            return true;
        } catch (Exception e) {
            response.getWriter().write("{ \"error_description\": \"Token inválido\"}");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(401);
            return false;
        }
    }

}

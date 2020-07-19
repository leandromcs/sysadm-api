package com.example.sysadm.interceptor;

import com.example.sysadm.model.Operador;

public class AuthenticationData {

    private static Operador loggedUser;

    public static Operador getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(Operador loggedUser) {
        AuthenticationData.loggedUser = loggedUser;
    }
}

package com.FerresaswebV1.Ferresasweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** Controla las vistas HTML de la aplicación. */
@Controller
public class PaginasController {

    @GetMapping("/")
    public String login() {
        return "auth/login"; // Apunta a templates/auth/login.html
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard/dashboard"; // Apunta a templates/dashboard/dashboard.html
    }
}
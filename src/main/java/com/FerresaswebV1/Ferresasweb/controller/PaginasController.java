package com.FerresaswebV1.Ferresasweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** Controla las vistas HTML de la aplicación. */
@Controller
public class PaginasController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}

package com.empresa.iglesia.controller;

import com.empresa.iglesia.model.Asistente;
import com.empresa.iglesia.model.Evento;
import com.empresa.iglesia.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("adminLogeado")
public class MainController {

    @Autowired
    EventoService es;

    @GetMapping("/")
    public String vistaLogin(Model model) {
        model.addAttribute("msg", "Verificación de credenciales");
        return "login";
    }

}

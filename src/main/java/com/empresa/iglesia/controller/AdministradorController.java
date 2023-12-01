package com.empresa.iglesia.controller;

import com.empresa.iglesia.model.Administrador;
import com.empresa.iglesia.model.Asistente;
import com.empresa.iglesia.service.AdministradorService;
import com.empresa.iglesia.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("adminLogeado")
public class AdministradorController {

    @Autowired
    AdministradorService as;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/validateLogin")
    public String validateLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        List<Administrador> administradores = as.listarAdministradores();
        for (Administrador adm : administradores) {
            if (adm.getUsername().equals(username) && adm.getPassword().equals(password)) {
                model.addAttribute("adminLogeado", adm);
                return "redirect:/home";
            }
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String cerrarSession(HttpServletRequest request, Model model) {
        model.asMap().remove("adminLogeado");
        request.getSession().invalidate();

        return "redirect:/";
    }
}

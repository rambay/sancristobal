package com.empresa.iglesia.controller;

import com.empresa.iglesia.model.Evento;
import com.empresa.iglesia.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("adminLogeado")
public class EventoController {

    @Autowired
    EventoService es;

    @GetMapping("/registrar/evento")
    public String vistaRegistrarEvento(Model model) {
        model.addAttribute("nuevoEvento", new Evento());
        return "registration-event";
    }

    @PostMapping("/registrar/evento/guardar")
    public String grabarEvento(Model model, @ModelAttribute("nuevoEvento") Evento nuevoEvento, RedirectAttributes redirectAttributes) {
        try {
            es.guardarEvento(nuevoEvento);
            redirectAttributes.addFlashAttribute("mensaje", "Guardado con éxito");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
        }
        return "redirect:/registrar/evento";
    }
}

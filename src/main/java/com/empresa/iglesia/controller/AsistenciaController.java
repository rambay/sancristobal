package com.empresa.iglesia.controller;

import com.empresa.iglesia.model.Asistente;
import com.empresa.iglesia.model.Evento;
import com.empresa.iglesia.model.Registro;
import com.empresa.iglesia.service.AsistenteService;
import com.empresa.iglesia.service.EventoService;
import com.empresa.iglesia.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("adminLogeado")
public class AsistenciaController {

    @Autowired
    AsistenteService as;
    @Autowired
    EventoService es;
    @Autowired
    RegistroService rs;

    @GetMapping("/registrar/asistencia")
    public String vistaRegistarAsistencia(Model model) {
        List<Evento> listaEventos = es.listarEventos();
        model.addAttribute("nuevoAsistente", new Asistente());
        model.addAttribute("eventosList", listaEventos);
        return "registration-attendance";
    }

    @GetMapping("/registrar/asistencia/{idEvento}")
    public String verificarEvento(Model model, @PathVariable Integer idEvento) {
        List<Evento> listaEventos = es.listarEventos();
        List<Registro> registrosEncontrados = rs.buscarRegistrosPorId(idEvento);
        Registro registro = rs.buscarRegistroPorId(idEvento);
        model.addAttribute("nuevoAsistente", new Asistente());
        model.addAttribute("registrosSearch", registrosEncontrados);
        model.addAttribute("registroEvento", registro);
        model.addAttribute("eventosList", listaEventos);

        return "registration-attendance";
    }

    @PostMapping("/registrar/asistencia/guardar")
    public String grabarAsistencia(@ModelAttribute("nuevoAsistente") Asistente nuevoAsistente, Model model, @RequestParam Integer idEvento, RedirectAttributes redirectAttributes) {
        try {
            List<Evento> listaEventos = es.listarEventos();
            List<Registro> registrosEncontrados = rs.buscarRegistrosPorId(idEvento);
            Evento eventoSeleccionado = es.buscarEventoPorID(idEvento);
            LocalDate fechaActual = LocalDate.now();
            int nuevoAforo = eventoSeleccionado.getAforoMaximo() - 1;
            eventoSeleccionado.setAforoMaximo(nuevoAforo);
            as.guardarAsistente(nuevoAsistente);
            Registro nuevoRegistro = new Registro(nuevoAsistente, eventoSeleccionado, fechaActual);
            rs.guardarRegistro(nuevoRegistro);
            model.addAttribute("eventosList", listaEventos);
            model.addAttribute("registrosSearch", registrosEncontrados);
            redirectAttributes.addFlashAttribute("mensaje", "Guardado con éxito");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
        }
        return "redirect:/registrar/asistencia";
    }
}

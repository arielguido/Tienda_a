/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.controller;

import com.ITicket.entity.Concierto;
import com.ITicket.service.ConciertoService;
import com.ITicket.service.IConciertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConciertoController {

    @Autowired
    private IConciertoService ConciertoService;

    @GetMapping("/concierto")
    public String index(Model model) {
        List<Concierto> listaConcierto = ConciertoService.getAllConcierto();
        model.addAttribute("titulo", " Tabla Concierto");
        model.addAttribute("Concierto", listaConcierto);
        return "concierto";
    }
 @GetMapping("/ConciertoN")
    public String crearPersona(Model model) {
     
        model.addAttribute("concierto", new Concierto());
        return "crear";
    }

    @PostMapping("/save")
    public String guardarConcierto(@ModelAttribute Concierto concierto) {
       ConciertoService.saveConcierto(concierto);
        return "redirect:/concierto";
    }

    @GetMapping("/delete/{id}")
    public String eliminarConcierto(@PathVariable("id") Long idConcierto) {
       ConciertoService.delete(idConcierto);
        return "redirect:/concierto";
    }

    @GetMapping("/editConcierto/{id}")
    public String editarConcierto(@PathVariable("id") Long idConcierto, Model model) {
        Concierto concierto = ConciertoService.getConciertoById(idConcierto);
        model.addAttribute("Concierto", concierto);
        return "crear";
    }
}


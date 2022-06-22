/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.controller;

import com.Tienda.entity.Persona;
import com.Tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class PersonaController {

    @Autowired
    private IPersonaService PersonaService;
    
    @GetMapping("/persona")
    public String index (Model model){
        List<Persona> listaPersona = PersonaService.getAllPersona();
        model.addAttribute("titulo"," Tabla Persona");
        model.addAttribute("Personas", listaPersona);
        return "personas";
    }
}

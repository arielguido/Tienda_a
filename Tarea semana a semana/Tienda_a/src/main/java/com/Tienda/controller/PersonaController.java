/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.controller;

import com.Tienda.entity.Pais;
import com.Tienda.entity.Persona;
import com.Tienda.service.IPaisService;
import com.Tienda.service.IPersonaService;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import util.reportes.PersonaExporterExcel;
import util.reportes.PersonaExporterPDF;

/**
 *
 * @author Usuario
 */
@Controller
public class PersonaController {

    @Autowired
    private IPersonaService PersonaService;

    @Autowired
    private IPaisService PaisService;

    @GetMapping("/persona")
    public String index(Model model) {
        List<Persona> listaPersona = PersonaService.getAllPersona();
        model.addAttribute("titulo", " Tabla Persona");
        model.addAttribute("Personas", listaPersona);
        return "personas";
    }

    @GetMapping("/personaN")
    public String crearPersona(Model model) {
        List<Pais> listaPaises = PaisService.listCountry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPaises);
        return "crear";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona) {
        PersonaService.savePersona(persona);
        return "redirect:/persona";
    }

    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long idPersona) {
        PersonaService.delete(idPersona);
        return "redirect:/persona";
    }

    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model) {
        Persona persona = PersonaService.getPersonaById(idPersona);
        List<Pais> listaPaises = PaisService.listCountry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", listaPaises);
        return "crear";
    }
    @GetMapping("/exportarPDF")
	public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");


		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + ".pdf";

		response.setHeader(cabecera, valor);

		List<Persona> persona = PersonaService .findAll();

		PersonaExporterPDF exporter = new PersonaExporterPDF(persona);
		exporter.exportar(response);
	}

	@GetMapping("/exportarExcel")
	public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");


		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + ".xlsx";

		response.setHeader(cabecera, valor);

		List<Persona> persona = PersonaService.findAll();

		PersonaExporterExcel exporter = new PersonaExporterExcel(persona);
		exporter.exportar(response);
	}
}

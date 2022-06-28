 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.service;

import com.Tienda.entity.Persona;
import com.Tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository PersonaRepository; 
    
    @Override
    public List<Persona> getAllPersona() {
     return (List<Persona>)PersonaRepository.findAll();
    }

    @Override
    public Persona getPersonaById(long id) {
        return PersonaRepository.findById(id).orElse(null);
        }

    @Override
    public void savePersona(Persona Persona) {
       PersonaRepository.save(Persona);
     }

    @Override
    public void delete(long id) {
        PersonaRepository.deleteById(id);
         }
    
}

package com.Tienda.service;

import com.Tienda.entity.Persona;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IPersonaService {
    public List<Persona> getAllPersona();
    public Persona getPersonaById(long id);
    public void savePersona(Persona Persona);
    public void delete (long id);
    public Persona findByNombre (String nombre);
}

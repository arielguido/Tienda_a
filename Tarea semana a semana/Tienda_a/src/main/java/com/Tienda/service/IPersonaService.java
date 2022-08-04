package com.Tienda.service;

import com.Tienda.entity.Persona;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Usuario
 */
public interface IPersonaService {

    public List<Persona> getAllPersona();

    public Persona getPersonaById(long id);

    public void savePersona(Persona Persona);

    public void delete(long id);

    public Persona findByNombre(String nombre);

    public List<Persona> findAll();

    public Page<Persona> findAll(Pageable Pageable);

    public Persona findOne(Long id);
}

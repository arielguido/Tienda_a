/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.service;

import com.ITicket.entity.Concierto;
import com.ITicket.repository.ConciertoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ConciertoService implements IConciertoService {
    
    @Autowired
    private ConciertoRepository ConciertoRepository; 

    @Override
    public List<Concierto> getAllConcierto() {
        return (List<Concierto>) ConciertoRepository.findAll();
    }

    @Override
    public Concierto getConciertoById(long id) {
         return ConciertoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveConcierto(Concierto Concierto) {
         ConciertoRepository.save(Concierto);
    }

    @Override
    public void delete(long id) {
          ConciertoRepository.deleteById(id);
    }

}

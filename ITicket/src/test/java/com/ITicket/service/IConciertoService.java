package com.ITicket.service;

import com.ITicket.entity.Concierto;
import java.util.List;


public interface IConciertoService {
     public List<Concierto> getAllConcierto();
    public Concierto getConciertoById(long id);
    public void saveConcierto(Concierto Concierto);
    public void delete (long id);
}

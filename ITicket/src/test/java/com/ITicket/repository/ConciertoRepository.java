
package com.ITicket.repository;

import com.ITicket.entity.Concierto;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Usuario
 */
@Repository
public interface ConciertoRepository extends CrudRepository<Concierto,Long> {
    
}

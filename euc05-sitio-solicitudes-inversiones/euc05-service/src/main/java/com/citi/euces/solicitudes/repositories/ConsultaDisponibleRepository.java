/**
 * 
 */
package com.citi.euces.solicitudes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citi.euces.solicitudes.entities.ConsultaDisponible;
import com.citi.euces.solicitudes.entities.ConsultaDisponibleIdentity;

/**
 * @author lbermejo
 *
 */
@Repository
public interface ConsultaDisponibleRepository 
	extends JpaRepository<ConsultaDisponible, ConsultaDisponibleIdentity> {

	List<ConsultaDisponible> findByIdTarjetaCredito(String ntdc);
	
}

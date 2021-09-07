/**
 * 
 */
package com.citi.euces.solicitudes.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citi.euces.solicitudes.entities.ConsultaDisponible;
import com.citi.euces.solicitudes.entities.ConsultaDisponibleIdentity;
import com.citi.euces.solicitudes.repositories.ConsultaDisponibleRepository;
import com.citi.euces.solicitudes.services.api.ConsultaDisponibleService;

/**
 * @author lbermejo
 *
 */
@Service
@Transactional
public class ConsultaDisponibleServiceImpl implements ConsultaDisponibleService{
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaDisponibleServiceImpl.class);
	private ConsultaDisponibleRepository repository;
	
	/**
	 * 
	 * @param repository
	 */
	public ConsultaDisponibleServiceImpl(ConsultaDisponibleRepository repo) {
		this.repository = repo;
	}
	
	/**
	 * 
	 */
	public Optional<ConsultaDisponible> getConsultaDisponible(
			final ConsultaDisponibleIdentity pk ){
		
		return repository.findById(pk);
	}
	
	/**
	 * 
	 */
	public List<ConsultaDisponible> getConsultaDisponibleByTDC(final String ntdc){
		
		final List<ConsultaDisponible> listToReturn =
				repository.findByIdTarjetaCredito(ntdc);
		
		LOGGER.debug("find customerDetail for ntdc::" +ntdc+", resp["+listToReturn+"]");
				
		return listToReturn;
	}
	
	/**
	 * 
	 */
	public List<ConsultaDisponible> getAllCustomerDetail(){
		return repository.findAll();
	}
	
}

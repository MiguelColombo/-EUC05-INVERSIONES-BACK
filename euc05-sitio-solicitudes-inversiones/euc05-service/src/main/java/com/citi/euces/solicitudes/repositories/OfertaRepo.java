package com.citi.euces.solicitudes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.Oferta;

public interface OfertaRepo extends JpaRepository<Oferta, String>{
	
	@Query(value = " SELECT * from PER_CAT_OFERTA o where o.OFERTA_ID = :ID_OFERTA  ",nativeQuery = true )
	List<Oferta> ObtenerOferta(@Param("ID_OFERTA") String ID_OFERTA);

}

package com.citi.euces.solicitudes.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.solicitudes.entities.DiasFestivos;

public interface DiasFestivosRepo extends JpaRepository<DiasFestivos, Integer> { // extends JpaRepository<T, ID>
	
	@Query(value = " select * from UEC_TB_CAT_FECHAS_FESTIVAS a ",nativeQuery = true )
	List<DiasFestivos> obtenerListaFechas();

}

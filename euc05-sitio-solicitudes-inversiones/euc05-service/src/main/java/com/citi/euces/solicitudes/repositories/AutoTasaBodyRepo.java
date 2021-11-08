package com.citi.euces.solicitudes.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.citi.euces.solicitudes.entities.AutoTasaBody;

public interface AutoTasaBodyRepo extends JpaRepository<AutoTasaBody, Long>{
	
	@Query("SELECT f FROM AutoTasaBody f where f.ID_TASAUTO = :ID_TASAUTO")
	AutoTasaBody buscarId(@Param("ID_TASAUTO") BigInteger ID_TASAUTO);


}

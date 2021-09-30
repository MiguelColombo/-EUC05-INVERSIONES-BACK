package com.citi.euces.solicitudes.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.SucursalesConsulta;

public interface SucursalesConsultaRepo extends JpaRepository<SucursalesConsulta, String> {
	
	@Query(value = " select * from UEC_CAT_SUC2021 a where a.SIRH = :NUM_CTE order by a.SIRH ",nativeQuery = true )
	List<SucursalesConsulta> GetItem(@Param("NUM_CTE") BigInteger NUM_CTE);

}

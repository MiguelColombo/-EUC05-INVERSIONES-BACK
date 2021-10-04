package com.citi.euces.solicitudes.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.SucursalesConsulta;

public interface SucursalesConsultaRepo extends JpaRepository<SucursalesConsulta, String> {
	
	@Query(value = " select * from PER_CAT_SUCURSALES a where a.SIRH_SUCURSAL_ID = :NUM_CTE order by a.SIRH_SUCURSAL_ID ",nativeQuery = true )
	List<SucursalesConsulta> GetItem(@Param("NUM_CTE") BigInteger NUM_CTE);

}

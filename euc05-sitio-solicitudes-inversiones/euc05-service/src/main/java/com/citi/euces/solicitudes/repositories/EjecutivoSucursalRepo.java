package com.citi.euces.solicitudes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.EjecutivoSucursal;

public interface EjecutivoSucursalRepo extends JpaRepository<EjecutivoSucursal, String> {
	
   @Query(value = " select e.SOIED, e.NOMINA, e.SIRH_SUCURSAL, s.SUCURSAL, s.DIVISION, s.DISTRITO "
		       + "  from PER_CAT_EJECUTIVO_SUCURSAL e inner join UEC_CAT_SUC2021 s  "
		       + "  on s.SIRH = e.SIRH_SUCURSAL where e.SOIED = :SOIED ",nativeQuery = true )
   List<EjecutivoSucursal>getEjecutivo(@Param("SOIED") String SOIED);
}

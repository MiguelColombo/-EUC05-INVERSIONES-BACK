package com.citi.euces.solicitudes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.EjecutivoSucursal;

public interface EjecutivoSucursalRepo extends JpaRepository<EjecutivoSucursal, String> {
	
   @Query(value = " select e.SOIED, e.NOMINA, e.SIRH_SUCURSAL, s.NOMBRE_SUCURSAL, s.DIVISION_NOMBRE, s.DISTRITO_NOMBRE, e.NOMBRE  "
		       + "  from PER_CAT_EJECUTIVO_SUCURSAL e inner join PER_CAT_SUCURSALES s  "
		       + "  on s.SIRH_SUCURSAL_ID = e.SIRH_SUCURSAL where e.SOIED = :SOIED ",nativeQuery = true )
   List<EjecutivoSucursal>getEjecutivo(@Param("SOIED") String SOIED);
}

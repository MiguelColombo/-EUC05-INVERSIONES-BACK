package com.citi.euces.solicitudes.repositories;



import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.Sucursales;

public interface SucursalesRepo extends JpaRepository<Sucursales, Integer>{
	@Query(value = "select s.DISTRITO_NOMBRE from PER_CAT_SUCURSALES s where s.SIRH_SUCURSAL_ID =:SIRH",nativeQuery = true )
	String ObtenerRegionDeNumSuc(@Param("SIRH") BigInteger SIRH);
	
	@Query(value = "select * from PER_CAT_SUCURSALES a order by a.SIRH_SUCURSAL_ID",nativeQuery = true )
	List<Sucursales> ObtenerSucursalesPorSuc();
	

}

package com.citi.euces.solicitudes.repositories;



import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.Sucursales;

public interface SucursalesRepo extends JpaRepository<Sucursales, Integer>{
	@Query(value = "select s.DISTRITO from UEC_CAT_SUC2021 s where s.SIRH =:SIRH",nativeQuery = true )
	String ObtenerRegionDeNumSuc(@Param("SIRH") BigInteger SIRH);
	
	@Query(value = "select * from UEC_CAT_SUC2021 a order by a.SIRH",nativeQuery = true )
	List<Sucursales> ObtenerSucursalesPorSuc();
	

}

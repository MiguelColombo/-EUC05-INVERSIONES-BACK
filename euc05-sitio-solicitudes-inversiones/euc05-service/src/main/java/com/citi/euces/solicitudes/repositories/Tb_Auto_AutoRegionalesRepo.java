package com.citi.euces.solicitudes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.citi.euces.solicitudes.entities.Tb_Auto_AutoRegionales;

public interface Tb_Auto_AutoRegionalesRepo extends JpaRepository<Tb_Auto_AutoRegionales, String> {
	
	@Query(value = " Select * from UEC_TB_AUTO_AUTOREGIONALES a where SOEID like %:SOEID% ",nativeQuery = true )
	List<Tb_Auto_AutoRegionales> ObtenerRegionales(@Param("SOEID") String SOEID);

}

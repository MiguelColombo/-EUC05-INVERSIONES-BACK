package com.citi.euces.solicitudes.repositories;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.TbAutorizadoresElegidos;

public interface TbAutorizadoresElegidosRepo extends JpaRepository<TbAutorizadoresElegidos, Integer>{
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO UEC_TB_AUTORIZADORES_ELEGIDOS (id_TasaAuto, Autorizadores) " 
			+ "  VALUES ( :Id_TasaAuto,:Autorizadores )  ",nativeQuery = true )
	int Guardar_Autorizacion(@Param("Id_TasaAuto") BigInteger Id_TasaAuto, @Param("Autorizadores") String Autorizadores);
}

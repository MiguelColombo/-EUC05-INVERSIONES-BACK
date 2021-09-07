package com.citi.euces.solicitudes.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.TasaPorsentaje;

public interface TasaPorsentajeRespo extends JpaRepository<TasaPorsentaje, Integer>{
	
	@Query(value = " SELECT * FROM UEC_TB_TASA_PORCENTAJE  p "
			+ " where p.CAMPANA IN (:campana) ORDER BY p.ID_TASA_PORC ",nativeQuery = true )
	List<TasaPorsentaje> sacarPorsentaje(@Param("campana") String campana);

}

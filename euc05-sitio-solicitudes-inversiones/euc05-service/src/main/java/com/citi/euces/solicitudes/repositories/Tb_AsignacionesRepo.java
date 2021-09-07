package com.citi.euces.solicitudes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.solicitudes.entities.Tb_Asignaciones;

public interface Tb_AsignacionesRepo extends JpaRepository<Tb_Asignaciones, String> {
	@Query(value = " Select  * from UEC_TB_ASIGNACIONES a ",nativeQuery = true )
	List<Tb_Asignaciones> ObtenerAsignaciones();

}

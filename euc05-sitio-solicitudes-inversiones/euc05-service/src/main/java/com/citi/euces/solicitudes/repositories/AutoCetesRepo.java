package com.citi.euces.solicitudes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.solicitudes.entities.AutoCetes;

public interface AutoCetesRepo extends JpaRepository<AutoCetes, Integer> {
	
	@Query(value = " SELECT c.ID_PLAZO,c.CETE FROM UEC_TB_AUTOCETES c",nativeQuery = true )
	List<AutoCetes> ObtenerAutoCetes();

}

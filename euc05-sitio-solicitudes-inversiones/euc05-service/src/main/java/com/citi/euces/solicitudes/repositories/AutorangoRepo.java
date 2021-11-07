package com.citi.euces.solicitudes.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.solicitudes.entities.*;
public interface AutorangoRepo extends JpaRepository<Autorango, Integer>{
	
	@Query(value = "SELECT * FROM UEC_TB_AUTORANGOS a ORDER BY a.ID_RANGO ",nativeQuery = true )
	 List<Autorango> autoRango();
}

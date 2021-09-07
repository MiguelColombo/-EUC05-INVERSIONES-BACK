package com.citi.euces.solicitudes.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.solicitudes.entities.*;
public interface AutorangoRepo extends JpaRepository<Autorango, Integer>{
	
	@Query(value = "select * from UEC_TB_AUTORANGOS a ",nativeQuery = true )
	 List<Autorango> autoRango();
}

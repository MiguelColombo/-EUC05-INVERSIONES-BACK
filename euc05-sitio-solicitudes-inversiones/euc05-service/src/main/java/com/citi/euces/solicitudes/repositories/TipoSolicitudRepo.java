package com.citi.euces.solicitudes.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.solicitudes.entities.*;

public interface TipoSolicitudRepo extends JpaRepository<TipoSolicitud, Integer> {
	@Query(value = "select * from ACE_CAT_EUC a where a.ID in(17,18,19) ",nativeQuery = true )
	 List<TipoSolicitud> solicitud();
}

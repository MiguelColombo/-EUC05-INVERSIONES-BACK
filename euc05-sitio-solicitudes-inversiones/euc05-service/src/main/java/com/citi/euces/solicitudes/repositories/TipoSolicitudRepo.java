package com.citi.euces.solicitudes.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.solicitudes.entities.*;

public interface TipoSolicitudRepo extends JpaRepository<TipoSolicitud, Integer> {
	@Query(value = "SELECT to_number(p.PARAMETRO_ID) AS ID, to_number(p.PARAMETRO_TIPO) AS EUC, p.PARAMETRO_NOM AS DESCRIPTION FROM PER_CAT_PARAMETROS p WHERE p.PARAMETRO_ID IN(17,18,19) ",nativeQuery = true )
	 List<TipoSolicitud> solicitud();
}

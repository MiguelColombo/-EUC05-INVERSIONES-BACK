package com.citi.euces.solicitudes.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.solicitudes.entities.*;

public interface TipoSolicitudRepo extends JpaRepository<TipoSolicitud, Integer> {
	@Query(value = " select p.PARAMETRO_ID AS ID , to_number(case when p.PARAMETRO_ID = 7 then 1  when p.PARAMETRO_ID = 8 then 2 else 3 end) as EUC "
			   + " ,p.PARAMETRO_NOM AS DESCRIPTION, p.PARAMETRO_VALOR as VALOR "
			   + " FROM PER_CAT_PARAMETROS p WHERE p.PARAMETRO_ID IN(7,8,9) ",nativeQuery = true )
	 List<TipoSolicitud> solicitud();
}

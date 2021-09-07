package com.citi.euces.solicitudes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.Tb_Auto_AutoDivisionales;

public interface Tb_Auto_AutoDivisionalesRepo extends JpaRepository<Tb_Auto_AutoDivisionales, String>{
	@Query(value = " Select  SOEID,DIVISION,Nombre,INIC,FECHA_INICIO,FECHA_TERMINO,ALTA,CORREO, 'Regional' as TIPO, IS_CETE100, IS_CAMPESP "
			+ " from( "
			+ " Select SOEID,DIVISION,Nombre,INIC,FECHA_INICIO,FECHA_TERMINO,ALTA,CORREO, 'Regional' as TIPO, IS_CETE100, IS_CAMPESP "
			+ "  from UEC_TB_AUTO_AUTOREGIONALES  where SOEID like %:SOEID% "
			+ "  union "
			+ "  Select SOEID,DIVISION,Nombre,INIC,FECHA_INICIO,FECHA_TERMINO,ALTA,CORREO, 'Facultado' as TIPO, IS_CETE100, IS_CAMPESP "
			+ "  from UEC_TB_AUTO_AUTOFACULTADOS b where b.SOEID like %:SOEID% "
			+ "  union "
			+ "  Select SOEID,DIVISION,Nombre,INIC,FECHA_INICIO,FECHA_TERMINO,ALTA,CORREO, 'Divisional' as TIPO, IS_CETE100, IS_CAMPESP "
			+ "  from UEC_TB_AUTO_AUTODIVISIONALES  where SOEID like %:SOEID% "
			+ "  ) F ",nativeQuery = true )
	List<Tb_Auto_AutoDivisionales> ObtenerAutoDivisionalAll(@Param("SOEID") String SOEID);
	
	@Query(value = " Select c.SOEID,c.DIVISION,c.Nombre,c.INIC,c.FECHA_INICIO,c.FECHA_TERMINO,c.ALTA,c.CORREO ,'Divisional' as TIPO, c.IS_CETE100, c.IS_CAMPESP "
			+ " from UEC_TB_AUTO_AUTODIVISIONALES c where c.SOEID like %:SOEID% ",nativeQuery = true )
	List<Tb_Auto_AutoDivisionales> ObtenerDivisional(@Param("SOEID") String SOEID);

}

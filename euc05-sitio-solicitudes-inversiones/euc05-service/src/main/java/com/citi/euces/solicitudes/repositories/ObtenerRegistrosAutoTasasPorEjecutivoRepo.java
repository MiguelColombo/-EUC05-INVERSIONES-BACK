package com.citi.euces.solicitudes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.AutoTasasPorEjecutivo;

public interface ObtenerRegistrosAutoTasasPorEjecutivoRepo extends JpaRepository<AutoTasasPorEjecutivo, Integer>{

	@Query(value = " SELECT tas.ID_TASAUTO, tas.ESTATUS,tas.NUM_AUTORI_UEC,tas.FECHA_SOLIC, tas.FECHA_AUTORI, tas.FECHA_ESTATUS, "
            + " tas.SUC_SOLIC,(sucu.SIRH||' - '||sucu.SUCURSAL||' - '||sucu.DISTRITO) as suc, tas.NUM_CTE, tas.NOM_CTE,  tas.CONTRATO,tas.NOMINA,tas.MONTO,tas.PLAZO, "
            + " tas.TASA_AUTORI, tas.TIPO_AUTORI, tas.SOEID_AUTORI, tas.SOEID_ASIG, tas.SOEID_OPE,tas.INIC_AUTORI, tas.CETE,tas.PORCEN_CETE, "
            + " eleg.autorizadores,   tas.OBSERVA_WEB,   certifisicos.folio as certificado_fisico, certimorales.folio as certificado_moral    "
			+ " FROM UEC_TB_AUTOTASAS tas  inner join UEC_CAT_SUC2021 sucu on tas.SUC_SOLIC = sucu.SIRH "
			+ " left join UEC_TB_CERTIFICADOS_FISICOS certifisicos on certifisicos.num_cte = tas.NUM_CTE "
			+ " left join UEC_TB_CERTIFICADOS_MORALES certimorales on certimorales.num_cte = tas.NUM_CTE "
            + " left join UEC_TB_AUTORIZADORES_ELEGIDOS eleg on tas.ID_TASAUTO = eleg.id_TasaAuto " 
		//	+ " where 1" 
            + " where tas.NOMINA like %:nomina% and tas.NUM_CTE = :num_cte"
            + " and to_char(tas.FECHA_SOLIC, 'YYYY') = :year order by tas.FECHA_SOLIC desc"  
            ,nativeQuery = true )
	List<AutoTasasPorEjecutivo> ObtenerRegistrosAutoTasasPorEjecutivo(@Param("nomina") String nomina,@Param("num_cte") Long num_cte,@Param("year") String year);
	
}

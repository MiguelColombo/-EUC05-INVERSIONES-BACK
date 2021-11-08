package com.citi.euces.solicitudes.repositories;


import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.solicitudes.entities.AutoTasa;
public interface AutoTasaRepo extends JpaRepository<AutoTasa, Integer>{
	
	@Query(value = "select a.ID_TASAUTO,a.FECHA_SOLIC,a.FECHA_AUTORI,NVL(a.FECHA_PROCESS,TO_DATE('1000/01/01',' YYYY/DD/MM')) AS FECHA_PROCESS "
			+ ", NVL(a.FECHA_ESTATUS,TO_DATE('1000/01/01',' YYYY/DD/MM')) AS FECHA_ESTATUS ,NVL(a.IS_PROCESS,0) AS IS_PROCESS "
			+ ", a.ESTATUS,a.SUC_SOLIC,a.DIVISION,a.NUM_CTE,a.NOM_CTE,a.CONTRATO,a.NOMINA,a.NOMEJEC,a.MONTO,a.PLAZO,a.TASA_AUTORI "
			+ ", a.TIPO_AUTORI,a.SOEID_AUTORI,a.INIC_AUTORI,NVL(a.NUM_AUTORI_UEC,0) AS NUM_AUTORI_UEC ,a.SOEID_ASIG,a.SOEID_PROC "
			+ ", a.SOEID_OPE,a.CETE,a.PORCEN_CETE,a.OBSERVA_WEB,a.JUSTIFICACION,a.CEL,a.T_PER,a.FECHA_SOLIC_CANCEL,a.NOMINA_CANCEL "
			+ ", a.NOMEJEC_CANCEL,a.JUSTIFICACION_CANCEL,a.REINVERSION,a.IS_CUENTA_MAESTRA,a.IS_PORTABILIDAD,a.EMAIL,a.AUTORIZADORES "
			+ " from UEC_TB_AUTOTASAS a where a.ID_TASAUTO =:ID_TASAUTO  ",nativeQuery = true )
	List<AutoTasa> ObtenerRegCampTasa(@Param("ID_TASAUTO") BigInteger ID_TASAUTO);
	
	@Query(value = " select NVL(MAX(t.ID_TASAUTO),0) AS ID_TASAUTO  from UEC_TB_AUTOTASAS t "
			+ " where TO_CHAR(t.FECHA_SOLIC, 'YYYY/DD/MM') = TO_CHAR(:FECHA)  ",nativeQuery = true )
	BigInteger ObtenerUltFolioAutoTasas(@Param("FECHA")String FECHA);
	
	
	@Query(value = " select NVL(MAX(t.ID_TASAUTO),0) AS ID_TASAUTO  from UEC_TB_AUTOTASAS t  "
			+ "  where t.ID_TASAUTO like %:ID_TASAUTO%  ",nativeQuery = true )
	BigInteger ValidarID_TASAUTO(@Param("ID_TASAUTO") BigInteger ID_TASAUTO);

	@Transactional
	@Modifying
	@Query(value = " UPDATE UEC_TB_AUTOTASAS SET "
			+ " INIC_AUTORI= :INIC_AUTORI, "
			+ " SOEID_AUTORI=:SOEID_AUTORI "
			+ " WHERE ID_TASAUTO= :ID_TASAUTO ",nativeQuery = true )
	int UPDATE_Autorizador_Solicitud(@Param("ID_TASAUTO") BigInteger ID_TASAUTO, @Param("SOEID_AUTORI") String SOEID_AUTORI,
			@Param("INIC_AUTORI") String INIC_AUTORI);
	
	@Query(value = " select a.ID_TASAUTO,a.FECHA_SOLIC,NVL(a.FECHA_AUTORI,TO_DATE('1000/01/01',' YYYY/DD/MM')) AS FECHA_AUTORI,NVL(a.FECHA_PROCESS,TO_DATE('1000/01/01',' YYYY/DD/MM')) AS FECHA_PROCESS "
			+ ", NVL(a.FECHA_ESTATUS,TO_DATE('1000/01/01',' YYYY/DD/MM')) AS FECHA_ESTATUS ,a.IS_PROCESS "
			+ ", a.ESTATUS,a.SUC_SOLIC,a.DIVISION,a.NUM_CTE,a.NOM_CTE,a.CONTRATO,a.NOMINA,a.NOMEJEC,a.MONTO,a.PLAZO,a.TASA_AUTORI "
			+ ", a.TIPO_AUTORI,a.SOEID_AUTORI,a.INIC_AUTORI,NVL(a.NUM_AUTORI_UEC,0) AS NUM_AUTORI_UEC ,a.SOEID_ASIG,a.SOEID_PROC "
			+ ", a.SOEID_OPE,NVL(a.CETE,0) AS CETE,NVL(a.PORCEN_CETE,0) AS PORCEN_CETE,a.OBSERVA_WEB,a.JUSTIFICACION,a.CEL,a.T_PER "
			+ ", NVL(a.FECHA_SOLIC_CANCEL,TO_DATE('1000/01/01',' YYYY/DD/MM')) AS FECHA_SOLIC_CANCEL,a.NOMINA_CANCEL "
			+ ", a.NOMEJEC_CANCEL,a.JUSTIFICACION_CANCEL,a.REINVERSION,a.IS_CUENTA_MAESTRA,a.IS_PORTABILIDAD,a.EMAIL,e.AUTORIZADORES "
			+ " FROM UEC_TB_AUTOTASAS a left join UEC_TB_AUTORIZADORES_ELEGIDOS e on a.ID_TASAUTO= e.ID_TASAAUTO WHERE a.ID_TASAUTO = :ID_TASAUTO ",nativeQuery = true )
	List<AutoTasa> ObtenerRegAutoTasa(@Param("ID_TASAUTO") BigInteger ID_TASAUTO);
	
	@Transactional
	@Modifying
	@Query(value = " UPDATE UEC_TB_AUTOTASAS SET "
			+ " SOEID_AUTORI= :SOEID_AUTORI, "
			+ " INIC_AUTORI=:INIC_AUTORI, "
			+ " ESTATUS=:ESTATUS, "
			+ " OBSERVA_WEB=:OBSERVA_WEB, "
			+ " SOEID_ASIG=:SOEID_ASIG,  "
			+ " FECHA_AUTORI=:FECHA_AUTORI, "
			+ " FECHA_ESTATUS=:FECHA_ESTATUS "
			+ " WHERE ID_TASAUTO= :ID_TASAUTO ",nativeQuery = true )
	int UPDATE_VOBO_AUTOTASAS(@Param("SOEID_AUTORI") String SOEID_AUTORI, 
			@Param("ID_TASAUTO") BigInteger ID_TASAUTO, 
			@Param("ESTATUS") String ESTATUS,
			@Param("SOEID_ASIG") String SOEID_ASIG,
			@Param("OBSERVA_WEB") String OBSERVA_WEB,
			@Param("FECHA_AUTORI") Timestamp FECHA_AUTORI,
			@Param("FECHA_ESTATUS") Timestamp FECHA_ESTATUS,
			@Param("INIC_AUTORI") String INIC_AUTORI);
	
	@Query(value = " SELECT a.SOEID_ASIG FROM UEC_TB_AUTOTASAS a where a.ID_TASAUTO = "
			+ " (SELECT max(b.ID_TASAUTO) FROM UEC_TB_AUTOTASAS b where b.SOEID_ASIG is not null and b.SOEID_ASIG <> ' ' )",nativeQuery = true )
	String ObtenerUltSoeidAsignado();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE UEC_TB_AUTOTASAS SET "
			+ " SOEID_ASIG=:SOEID_ASIG, "
			+ " SOEID_OPE= :SOEID_OPE, "
			+ " SOEID_PROC = NULL, "
			+ " ESTATUS= 'SOLIC_CANCEL', "
			+ " NOMINA_CANCEL=:NOMINA_CANCEL, "
			+ " NOMEJEC_CANCEL=:NOMEJEC_CANCEL, "
			+ " JUSTIFICACION_CANCEL=:JUSTIFICACION_CANCEL, "
			+ " FECHA_SOLIC_CANCEL=:FECHA_SOLIC_CANCEL"
			+ " WHERE ID_TASAUTO= :ID_TASAUTO ",nativeQuery = true )
	int UPDATE_SOLIC_CANCEL_CAMPTASAS(@Param("SOEID_ASIG") String SOEID_ASIG, 
			@Param("SOEID_OPE") String SOEID_OPE,
			@Param("NOMINA_CANCEL") String NOMINA_CANCEL,
			@Param("NOMEJEC_CANCEL") String NOMEJEC_CANCEL,
			@Param("JUSTIFICACION_CANCEL") String JUSTIFICACION_CANCEL,
			@Param("FECHA_SOLIC_CANCEL") Timestamp FECHA_SOLIC_CANCEL,
			@Param("ID_TASAUTO") BigInteger ID_TASAUTO);
	
	@Transactional
	@Modifying
	@Query(value = " INSERT INTO UEC_TB_AUTOTASAS (ID_TASAUTO,FECHA_SOLIC,ESTATUS,SUC_SOLIC, "
			+ " DIVISION,NUM_CTE,NOM_CTE,SOEID_ASIG,CONTRATO, "
			+ " NOMINA,NOMEJEC,MONTO,PLAZO,TASA_AUTORI,TIPO_AUTORI, "
			+ " CETE,PORCEN_CETE,JUSTIFICACION,CEL,IS_PORTABILIDAD,ID_CAMPANA, CERTIFICADO_FISICO) "
			+ " VALUES ( :ID_TASAUTO,:FECHA_SOLIC,:ESTATUS,:SUC_SOLI, "
			+ " :DIVISION,:NUM_CTE,:NOM_CTE,:SOEID_ASIG,:CONTRATO, "
			+ " :NOMINA,:NOMEJEC,:MONTO,:PLAZO,:TASA_AUTORI,:TIPO_AUTORI, "
			+ " :CETE,:PORCEN_CETE,:JUSTIFICACION,:CEL,:IS_PORTABILIDAD,:TASA_CAMPANA,:CERTIFICADO_FISICO)  ",nativeQuery = true )
	int SAVE_AUTOTASAS(@Param("ID_TASAUTO") BigInteger ID_TASAUTO,
			@Param("FECHA_SOLIC") Timestamp FECHA_SOLIC,
			@Param("ESTATUS") String ESTATUS,
			@Param("SUC_SOLI") Long SUC_SOLI,
			@Param("DIVISION") String DIVISION,
			@Param("NUM_CTE") BigInteger NUM_CTE,
			@Param("NOM_CTE") String NOM_CTE,
			@Param("SOEID_ASIG") String SOEID_ASIG,
			@Param("CONTRATO") BigInteger CONTRATO,
			@Param("NOMINA") String NOMINA,
			@Param("NOMEJEC") String NOMEJEC,
			@Param("MONTO") String MONTO,
			@Param("PLAZO") Long PLAZO,
			@Param("TASA_AUTORI") String TASA_AUTORI,
			@Param("TIPO_AUTORI") String TIPO_AUTORI,
			@Param("CETE") Long CETE,
			@Param("PORCEN_CETE") String PORCEN_CETE,
			@Param("JUSTIFICACION") String JUSTIFICACION,
			@Param("CEL") String CEL,
			@Param("IS_PORTABILIDAD") String IS_PORTABILIDAD,
			@Param("TASA_CAMPANA") String TASA_CAMPANA,
			@Param("CERTIFICADO_FISICO") String CERTIFICADO_FISICO);
	
	@Query(value = " SELECT count(a.IS_PORTABILIDAD) AS IS_PORTABILIDAD "
			+ " FROM UEC_TB_AUTOTASAS a WHERE a.IS_PORTABILIDAD like '%fol%' ", nativeQuery = true)
	Long existe_folio_bancanet();
	
	@Query("SELECT f FROM AutoTasa f where f.ID_TASAUTO = :ID_TASAUTO")
	AutoTasa buscarId(@Param("ID_TASAUTO") BigInteger ID_TASAUTO);

	
}

/**
 * 
 */
package com.citi.euces.solicitudes.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citi.euces.solicitudes.entities.ConsultaDisponible;
import com.citi.euces.solicitudes.exceptions.RecordNotFoundException;
import com.citi.euces.solicitudes.models.CustomerDetailResponse;
import com.citi.euces.solicitudes.models.CustomerDetailTDCRequest;
import com.citi.euces.solicitudes.services.api.ConsultaDisponibleService;

/**
 * @author lbermejo
 *
 */
@RestController
@RequestMapping(path = CustomerController.CUSTOMER_RESOURCE,
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);
	static final String CUSTOMER_RESOURCE = "/customers";
	
	private ConsultaDisponibleService service;
	
	public CustomerController(ConsultaDisponibleService service) {
		this.service = service;
	}
	
	/*
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/")
	public List<ConsultaDisponible> getAllCustomerDetail() {
		return service.getAllCustomerDetail();
	}
	*/
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/detailsByTdc")
	public CustomerDetailResponse getCustomerDetail(
			@Valid @RequestBody CustomerDetailTDCRequest tdcCustomer) {
		
		List<ConsultaDisponible> customersDetails = 
				service.getConsultaDisponibleByTDC(tdcCustomer.getTdcCustomer() );
		
		LOGGER.debug(customersDetails);
		
		if( !customersDetails.isEmpty()) {
			return getCustomerDetail(customersDetails.get(0));
		}
		
		throw new RecordNotFoundException("CustomerDetail with TDC ["
										+tdcCustomer.getTdcCustomer()+"] doesn't exist");
	}
	
	/**
	 * 
	 * @param cd
	 * @return
	 */
	private CustomerDetailResponse getCustomerDetail(final ConsultaDisponible cd) {
		
		CustomerDetailResponse response = new CustomerDetailResponse();
		response.setTarjetaDeCredito( cd.getId().getTarjetaCredito() );
		response.setPromoId(cd.getDbPromo());
		response.setNombre(cd.getId().getNombre());
		response.setProducto(cd.getProducto());
		response.setLineaInvitada(cd.getLineaInvitada());
		response.setMensualidades(cd.getMensualidades());
		response.setTasaIntAn(cd.getTasaAnual());
		response.setCatSinIva(cd.getCatSinIva());
		response.setVigencia( cd.getVigencia());
		response.setPromocion(cd.getId().getPromocion()) ;
		return response;
	
	}
}


# Customers

* Customer object
```
{
	tarjetaDeCredito: integer ,
	promocion: String,
	nombre: String,
	producto: String,
	lineaInvitada: integer,
	mensualidades: integer,
	tasaIntAn: float,
	catSinIva: float,
	vigencia: String,
	promoId: String
}
```

**POST /customer/**
  ----

  Returns the specified customer.
  
* **URL Params**  
  
  None
  
* **Data Params** 
```
  {
    tdcCustomer: integer
  }
``` 
  
* **Headers**  
  
  Content-Type: application/json  
  
* **Success Response:**
* **Code:** 200  

  **Content:**  
```
  {
	tarjetaDeCredito:4053060000150781,
	promocion: "TRANSFERENCIA DE DEUDA",
	nombre: "ANA ERIKA MARTINEZ AVITIA",
	producto: "Affinity Card Citibanamex",
	lineaInvitada: 107000,
	mensualidades: "",
	tasaIntAn: 9.99%,
	catSinIva: 10.5%,
	vigencia: "10 de Febrero al 18 de abril",
	promoId: "LITERAL BPM V6"
  }
```

* **Error Response:**  
  * **Code:** 404
    
  **Content:** `{ error : "Customer doesn't exist" }`
    
  * **Code:** 401
    
  **Content:** `{ error : error : "You are unauthorized to make this request." }`
  
  
  
  
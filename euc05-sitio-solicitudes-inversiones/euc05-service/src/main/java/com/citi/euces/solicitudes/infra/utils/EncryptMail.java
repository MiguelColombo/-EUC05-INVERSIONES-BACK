package com.citi.euces.solicitudes.infra.utils;

import java.util.Base64;

import com.citi.euces.solicitudes.infra.dto.EnviarPHPBEDTO;

public class EncryptMail {
	
	public String Encrypt(String plain) {
        byte[] encodedBytes2 = Base64.getEncoder().encode(plain.getBytes());
        String cadenaencodedBytes2 = new String(encodedBytes2);
      /*  System.out.println(cadenaencodedBytes2);
        byte[] decodedBytes2 = Base64.getDecoder().decode(cadenaencodedBytes2.getBytes());
        String cadenaDecodificada2 = new String(decodedBytes2);
        System.out.println(cadenaDecodificada2);*/
		return cadenaencodedBytes2;
	}
	
	public String AESEncryption (String plain, String key) {
		String code= plain+" "+key;
		byte[] encodedBytes2 = Base64.getEncoder().encode(code.getBytes());
        String cadenaencodedBytes2 = new String(encodedBytes2);
        return cadenaencodedBytes2;
	}

	
	
}

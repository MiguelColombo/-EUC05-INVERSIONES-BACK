package com.citi.euces.solicitudes.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorGeneric {
    private String mensaje;
    private String code;
   // private String exception;
    private String error;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

 /*    public String getException() {
        return exception;
    }

    public void setException(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
       e.printStackTrace(pw);
        this.exception = sw.toString();
    }
    public void setException(String e) {

        this.exception = e;
    }
*/
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	public void setError(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
       e.printStackTrace(pw);
        this.error = sw.toString();
    }


}



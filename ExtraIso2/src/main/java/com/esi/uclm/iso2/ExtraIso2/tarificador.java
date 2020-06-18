package com.esi.uclm.iso2.ExtraIso2;

import java.util.Date;

public class tarificador {


	private static int tarifaBaseActual;

	
	public tarificador(int tarifaBaseActual) {
		tarifaBaseActual=tarifaBaseActual;
	}

	public static int getTarifaBaseActual(Date fecha) {
		if(fecha.getMonth()<8 && fecha.getMonth()>4 ) {
			tarifaBaseActual= 1000;
		}else {
			tarifaBaseActual=700;
		}
		return tarifaBaseActual;
	}

	public void setTarifaBaseActual(int tarifaBaseActual) {
		this.tarifaBaseActual = tarifaBaseActual;
	}
	
	

}

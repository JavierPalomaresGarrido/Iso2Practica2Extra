package com.esi.uclm.iso2.ExtraIso2;

import java.util.Date;

public class tarificador {


	public static int tarifaBaseActual;

	
	public tarificador(int tarifaBaseActual) {
		this.tarifaBaseActual=tarifaBaseActual;
	}

	public static int getTarifaBaseActual(Date fecha) {
		int tarifaBaseActual;
		if(fecha.getMonth()<8 && fecha.getMonth()>4 ) /*meses de verano*/{
			tarifaBaseActual= 1000;
		}else {//meses de invierno
			tarifaBaseActual=700;
		}
		return tarifaBaseActual;
	}

//	public void setTarifaBaseActual(int tarifaBaseActual) {
//		this.tarifaBaseActual = tarifaBaseActual;
//	}
	
	

}

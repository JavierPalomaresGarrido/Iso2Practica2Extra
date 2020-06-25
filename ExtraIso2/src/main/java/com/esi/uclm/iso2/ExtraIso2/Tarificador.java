package com.esi.uclm.iso2.ExtraIso2;

import java.util.Date;

public class Tarificador {
	/**
	 * variable global.
	 */
	private static int tarifaBase;  
/**
* Constructor.
* @param tarifaBaseActual
*/
	public Tarificador(final int tarifaBaseActual) {
		this.tarifaBase = tarifaBaseActual;
	}
	/**
	 * @return tarifaBase
	 */
	public static int getTarifaBase() {
		return tarifaBase;
	}
	/**
	 * calculamos la tarifa segun la fecha.
	 * @param fecha
	 * @return tarifaBaseActual
	 */
	public static int getTarifaBaseActual(final Date fecha) {
		int tarifaBaseActual;
		if (fecha.getMonth() < 8 && fecha.getMonth() > 4) {
			/*meses de verano*/
			tarifaBaseActual = 1000; }
		else { //meses de invierno
			tarifaBaseActual = 700;
		}
		return tarifaBaseActual;
	}
}

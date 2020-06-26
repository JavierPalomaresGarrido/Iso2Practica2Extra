/**
 * paquete con las dos excepciones realizadas por el alummno.
 */
package com.esi.uclm.iso2.ExtraIso2.Excepcion;

public class FechaPasadaException extends Exception {
	/**
	 * Excepcion para fechas del pasado.
	 * @param mens
	 */
	public FechaPasadaException(final String mens) {
		super(mens);
		System.out.println(mens);
	}
}

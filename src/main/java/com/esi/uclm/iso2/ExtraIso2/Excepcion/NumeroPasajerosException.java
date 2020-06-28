/**
 * paquete con las dos excepciones realizadas por el alummno
 */
package com.esi.uclm.iso2.ExtraIso2.Excepcion;

public class NumeroPasajerosException extends Exception {
	/**
	 * Excepcion numero pasajeros.
	 * @param mens
	 */
	public NumeroPasajerosException(final String mens) {
		super(mens);
		System.out.println(mens);
	}
}

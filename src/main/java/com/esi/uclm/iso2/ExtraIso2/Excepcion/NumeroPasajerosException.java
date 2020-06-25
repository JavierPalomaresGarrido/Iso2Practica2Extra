package com.esi.uclm.iso2.ExtraIso2.Excepcion;

public class NumeroPasajerosException extends Exception {
	public NumeroPasajerosException(String mens) {
		super(mens);
		System.out.println(mens);
	}
}

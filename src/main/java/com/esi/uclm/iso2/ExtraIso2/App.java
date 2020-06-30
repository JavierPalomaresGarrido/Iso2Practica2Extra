package com.esi.uclm.iso2.ExtraIso2;

import java.util.Date;


import com.esi.uclm.iso2.ExtraIso2.Excepcion.*;
/*.FechaPasadaException*/
//import com.esi.uclm.iso2.ExtraIso2.Excepcion.NumeroPasajerosException;

/**
 * Hello world!
 *
 */
public class App {
	/**
	 * variable gobal fecha.
	 */
	static Date fecha = new Date(120, 10, 27);
	/**
	 * Metodo main.
	 * @param args
	 * @throws FechaPasadaException
	 * @throws NumeroPasajerosException
	 */
    public static void main(String[] args) 
    		throws FechaPasadaException, NumeroPasajerosException {
    	 
         calcularCosteViaje(fecha, FranjaEnum.MANANA, 61);
    }       
    /**
     * Metodo para calcular el coste del viaje.
     * @param fecha
     * @param franjaHoraria
     * @param numeroPasajeros
     * @return costeIndividual * numeroPasajeros
     * @throws FechaPasadaException
     * @throws NumeroPasajerosException
     */
    public static double calcularCosteViaje(final Date fecha, 
    		final FranjaEnum franjaHoraria, final int numeroPasajeros) 
    		throws FechaPasadaException, NumeroPasajerosException {
    	//validación de parametros
    	if (fecha.compareTo(new Date()) < 0) {
    		throw new FechaPasadaException("La fecha debe ser"
    				+ " la de hoy o futura");
    	}
    	if (numeroPasajeros < 1 || numeroPasajeros > 99) {
    		throw new NumeroPasajerosException("Debe introducir un número"
    				+ " de pasajeros entre 1 y 99");
    	}
    	//inicialización coste viaje a la tarifa base actual
    	double costeIndividual = Tarificador.getTarifaBaseActual(fecha);
    	//extras y reducciones por franja horaria
    	switch (franjaHoraria) {
    	case MANANA:
    		costeIndividual += 200.50;
    		break;
    	case TARDE:
    		costeIndividual += 85.00;
    		break;
    	case NOCTURNO:
    		costeIndividual -= 340.50;
    		break;
    		default:
    		System.out.println("no has introducido una "
    				+ "franja horaria correcta,"
    				+ " no se aplica ningun sobrecoste ni "
    				+ "ningun descuento");
    		break; }
    	//descuento por número de pasajeros y franja horaria
    	if (numeroPasajeros > 50 && !franjaHoraria.equals(FranjaEnum.MANANA)) {
    		costeIndividual *= 0.75; // -25% descuento
    	} else if (numeroPasajeros > 50
    				&& franjaHoraria.equals(FranjaEnum.MANANA)
    			|| numeroPasajeros <= 50 && numeroPasajeros > 10) {
    		costeIndividual *= 0.85; // -15% descuento
    	} else if (numeroPasajeros > 2 && numeroPasajeros <= 10 
    			&& franjaHoraria.equals(FranjaEnum.TARDE)) {
    		costeIndividual *= 0.90; // -10% descuento
    	} else if (numeroPasajeros > 2 && numeroPasajeros <= 10) {
    		costeIndividual *= 0.95; // -5% descuento
    	}
    	//extra por día de la semana
    	int diaSemana = getDiaSemana(fecha);
    	if (diaSemana == 5 || diaSemana == 6) {
    		costeIndividual += 50.75;
    	}
    	System.out.println(costeIndividual * numeroPasajeros);
    	return costeIndividual * numeroPasajeros;
    }
    /**
     * Metodo para devolver el dia de la semana (del 0 al 6).
     * @param fecha
     * @return fecha.getDay
     */
	@SuppressWarnings("deprecation")
	public static int getDiaSemana(final Date fecha) {
		// TODO Auto-generated method stub
		return fecha.getDay();
	}
}



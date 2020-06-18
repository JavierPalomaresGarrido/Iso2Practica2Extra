package com.esi.uclm.iso2.ExtraIso2;

import java.util.Date;
import java.util.Scanner;

import com.esi.uclm.iso2.ExtraIso2.FranjaEnum;
import com.esi.uclm.iso2.ExtraIso2.Excepcion.FechaPasadaException;
import com.esi.uclm.iso2.ExtraIso2.Excepcion.NumeroPasajerosException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FechaPasadaException, NumeroPasajerosException
    {
    	
    	Scanner sc = new Scanner(System.in);
        // entrada de una cadena
    	System.out.println("introduce el año de la fecha (los años se cuentan a partir del 1900, por ejemplo,"
    			+ "si quieres meter el año 2020 tienes que poner 120, si quieres meter 2021 el 121)");
        int año = sc.nextInt();
        System.out.println("introduce el mes de la fecha (siendo enero 0 ...junio 5...");
        int mes = sc.nextInt();
        System.out.println("introduce el dia de la fecha (siendo el dia, el dia que quieres +1, si quieres 17 pon 18 )");
        int dia = sc.nextInt();
    	System.out.println("introduce el numero de pasageros");
    	int pasajeros = sc.nextInt();
    	sc.close();
        System.out.println( "Hello World!" );
        @SuppressWarnings("deprecation")
		Date fecha = new Date(año, mes, dia);
        Date fechahora = new Date();
        System.out.println("de ahora"+fechahora.getYear());
        System.out.println(fechahora);
        System.out.println("la introducida"+fecha.getYear());
        System.out.println(fecha);
        //calcularCosteViaje(fecha,FranjaEnum.NOCTURNO,20);
        System.out.println( calcularCosteViaje(fecha,FranjaEnum.NOCTURNO,pasajeros));
    }
    public static double calcularCosteViaje(Date fecha, FranjaEnum franjaHoraria, int numeroPasajeros)
    		throws FechaPasadaException, NumeroPasajerosException {
    	//validación de parametros
    	if(fecha.compareTo(new Date()) <0) {
    		throw new FechaPasadaException("La fecha debe ser la de hoy o futura");
    	}
    	if(numeroPasajeros < 1 || numeroPasajeros > 99) {
    		throw new NumeroPasajerosException("Debe introducir un número de pasajeros entre 1 y 99");
    	}
    	//inicialización coste viaje a la tarifa base actual
    	double costeIndividual = tarificador.getTarifaBaseActual(fecha);
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
    	}
    	//descuento por número de pasajeros y franja horaria
    	if (numeroPasajeros > 50 && !franjaHoraria.equals(FranjaEnum.MANANA)) {
    		costeIndividual *= 0.75; // -25% descuento
    	}
    	else if ((numeroPasajeros > 50 && franjaHoraria.equals(FranjaEnum.MANANA)) ||
    			(numeroPasajeros <= 50 && numeroPasajeros > 10)) {
    		costeIndividual *= 0.85; // -15% descuento
    	}
    	else if (numeroPasajeros > 2 && numeroPasajeros <= 10 &&
    			franjaHoraria.equals(FranjaEnum.TARDE)) {
    		costeIndividual *= 0.90; // -10% descuento
    	}
    	else if (numeroPasajeros > 2 && numeroPasajeros <= 10) {
    		costeIndividual *= 0.95; // -5% descuento
    	}
    	//extra por día de la semana
    	int diaSemana = getDiaSemana(fecha);
    	if(diaSemana == 6 || diaSemana == 7) {
    		costeIndividual += 50.75;
    	}
    	return costeIndividual * numeroPasajeros;
    }
	@SuppressWarnings("deprecation")
	public static int getDiaSemana(Date fecha) {
		// TODO Auto-generated method stub
		return fecha.getDay();
	}
	
}



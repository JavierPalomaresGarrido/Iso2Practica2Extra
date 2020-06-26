package com.esi.uclm.iso2.ExtraIso2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import com.esi.uclm.iso2.ExtraIso2.Excepcion.FechaPasadaException;
import com.esi.uclm.iso2.ExtraIso2.Excepcion.NumeroPasajerosException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    //probamos el codigo con valores : fecha: 24/5/120    franjaHoraria: MANANA   numero de pasajeros: 30
    @Test
    public void testMesVeranoDiario(){
    	double precioTotal=0;
    	Date fecha = new Date(121, 6, 27);
     try {
		precioTotal=App.calcularCosteViaje(fecha, FranjaEnum.MANANA, 30);
		assertTrue(precioTotal==30612.75 );
	} catch (FechaPasadaException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
		e.printStackTrace();
	} catch (NumeroPasajerosException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
	}
        //assertTrue(precioTotal==30612.75 );
    }
    
    //probamos el codigo con valores : fecha: 24/10/120    franjaHoraria: TARDE   numero de pasajeros: 5
    @Test
    public void testMesInviernoDiario(){
    	double precioTotal=0;
    	Date fecha = new Date(120, 10, 24);
     try {
		precioTotal=App.calcularCosteViaje(fecha, FranjaEnum.TARDE, 5);
		assertTrue(precioTotal==3532.5);
	} catch (FechaPasadaException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
		e.printStackTrace();
	} catch (NumeroPasajerosException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
	}
        //assertTrue(precioTotal==30612.75 );
    }
    
    //probamos el codigo con valores : fecha: 27/10/120    franjaHoraria: NOCTURNO   numero de pasajeros: 5
    @SuppressWarnings("deprecation")
	@Test
    public void testMesInviernoFestivo(){
    	double precioTotal=0;
    	double precio=1961.375;
    	Date fecha = new Date(120, 10, 27);
     try {
		precioTotal=App.calcularCosteViaje(fecha, FranjaEnum.NOCTURNO, 5);
		//assertTrue(precioTotal==3500.5 );
		assertTrue(precioTotal==precio);
	} catch (FechaPasadaException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
		e.printStackTrace();
	} catch (NumeroPasajerosException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
	}
        //assertTrue(precioTotal==30612.75 );
    }

    //probamos el codigo con valores : fecha: 26/6/120    franjaHoraria: MANANA   numero de pasajeros: 5
    @Test
    public void testMesVeranoFestivo(){
    	double precioTotal=0;
    	Date fecha = new Date(120, 6, 26);
     try {
		precioTotal=App.calcularCosteViaje(fecha, FranjaEnum.MANANA, 5);
		assertTrue(precioTotal==5702.375 );
	} catch (FechaPasadaException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
		e.printStackTrace();
	} catch (NumeroPasajerosException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
	}
        //assertTrue(precioTotal==30612.75 );
     
    }
      
    //probamos el codigo con valores : fecha: 27/6/120    franjaHoraria: MANANA   numero de pasajeros: 1
    // en la tercera decision despues del switch (linea 73) probamos la decision cuando la primera condicion es false, la segunda true
    // y la tercera tambien true
    @Test
    public void testMesVeranoFestivoBranch1(){
    	double precioTotal=0;
    	Date fecha = new Date(120, 6, 27);
     try {
		precioTotal=App.calcularCosteViaje(fecha, FranjaEnum.MANANA, 1);
		assertTrue(precioTotal==1200.5 );
	} catch (FechaPasadaException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
		e.printStackTrace();
	} catch (NumeroPasajerosException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
	}
        //assertTrue(precioTotal==30612.75 );
     
    }
    
    //probamos el codigo con valores : fecha: 27/6/120    franjaHoraria: MANANA   numero de pasajeros: 16
    // en la tercera condicion despues del switch (linea 73) probamos la decision cuando la primera condicion es true, la segunda false
    // y la tercera tambien true
    @Test
    public void testMesVeranoFestivoBranch2(){
    	double precioTotal=0;
    	Date fecha = new Date(120, 6, 27);
     try {
		precioTotal=App.calcularCosteViaje(fecha, FranjaEnum.MANANA, 16);
		assertTrue(precioTotal==16326.8);
	} catch (FechaPasadaException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
		e.printStackTrace();
	} catch (NumeroPasajerosException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
	}
        //assertTrue(precioTotal==30612.75 );
     
    }
    
    //probamos el codigo con valores : fecha: 27/6/12  franjaHoraria: MANANA   numero de pasajeros: 160
    //probamos el caso en el que  salta la excepcion de fechas pasadas
    @Test
    public void testExcepcionFechaPasada(){
    	double precioTotal=0;
    	Date fecha = new Date(12, 6, 27);
     try {
		precioTotal=App.calcularCosteViaje(fecha, FranjaEnum.MANANA, 160);
		assertTrue(precioTotal==5956.125 );
	} catch (FechaPasadaException e) {
		// TODO Auto-generated catch block
		assertNotNull(e.getMessage());
		e.printStackTrace();
	} catch (NumeroPasajerosException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
	}
        //assertTrue(precioTotal==30612.75 );
     
    }
    
    //probamos el codigo con valores : fecha: 27/6/120    franjaHoraria: NADA   numero de pasajeros: 1
    //probamos el caso default del switch con el valor NADA de la franja horaria
    @Test
    public void testDefaultSwitch(){
    	double precioTotal=0;
    	Date fecha = new Date(120, 6, 27);
     try {
		precioTotal=App.calcularCosteViaje(fecha, FranjaEnum.NADA, 1);
		assertTrue(precioTotal==1000.0);
	} catch (FechaPasadaException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
		e.printStackTrace();
	} catch (NumeroPasajerosException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
	}
       
    }

   //en este caso probamos el constructor de la clase Tarificador, la cual se usa para marcar un precio individual segun el mes 
    @Test
    public void TestTarificadorVarGlobal() {
    	Tarificador t = new Tarificador(8);
    	assertTrue(Tarificador.getTarifaBase()==8);
    }
    
   
    //probamos el codigo con valores : fecha: 25/6/120    franjaHoraria: TARDE   numero de pasajeros: 59
    //probamos el primer if en el caso en que la decision es true
    @Test
    public void testPasajerosMasCincuenta(){
    	double precioTotal=0;
    	Date fecha = new Date(120, 6, 25);
     try {
		precioTotal=App.calcularCosteViaje(fecha, FranjaEnum.TARDE, 59);
		assertTrue(precioTotal==51005.5 );
	} catch (FechaPasadaException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
		e.printStackTrace();
	} catch (NumeroPasajerosException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
	}
        //assertTrue(precioTotal==30612.75 );
     
    }

    //probamos el codigo con valores : fecha: 27/6/120    franjaHoraria: MANANA   numero de pasajeros: 0
    // probamos el caso en el que salta la excepcion de NumeroPasajerosException
    @Test
    public void testExcepcionPasajeros(){
    	double precioTotal=0;
    	Date fecha = new Date(120, 6, 27);
     try {
		precioTotal=App.calcularCosteViaje(fecha, FranjaEnum.MANANA, 0);
		assertTrue(precioTotal==5956.125 );
	} catch (FechaPasadaException e) {
		// TODO Auto-generated catch block
		fail(e.getMessage());
		e.printStackTrace();
	} catch (NumeroPasajerosException e) {
		// TODO Auto-generated catch block
		assertNotNull(e.getMessage());
	}
        //assertTrue(precioTotal==30612.75 );
     
    }
    
    // testeamos la variable fecha
    @Test
    public void testVariableGlobalFechaTest() throws com.esi.uclm.iso2.ExtraIso2.Excepcion.FechaPasadaException, NumeroPasajerosException {
    	Date fecha1 = new Date(124, 6, 27);
    	App.fecha=fecha1;
    	assertTrue(App.calcularCosteViaje(App.fecha, FranjaEnum.MANANA, 50)==53558.75);
    }
    
   
    // test tarificador meses invierno para el caso en el que la decision es false, la primera condicion es true y la segunda false
    @Test
    public void testTarificadorMesesInviernoBranch(){
    	double precioTotalInd=0;
    	Date fecha = new Date(121, 2, 27);
     precioTotalInd=Tarificador.getTarifaBaseActual(fecha);
	assertTrue(precioTotalInd==700 );
     
    }
    
   

    
  
    
    
	
}

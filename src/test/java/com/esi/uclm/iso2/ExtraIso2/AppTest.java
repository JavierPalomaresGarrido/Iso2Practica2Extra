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
    
    @Test
    public void ProbarFranjaHorariaMesVeranoDiario(){
    	double precioTotal=0;
    	String ex="pon una fecha correcta";
    	Date fecha = new Date(120, 5, 24);
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
    
    @Test
    public void ProbarFranjaHorariaMesInviernoDiario(){
    	double precioTotal=0;
    	String ex="pon una fecha correcta";
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
    
    @SuppressWarnings("deprecation")
	@Test
    public void ProbarFranjaHorariaMesInviernoFestivo(){
    	double precioTotal=0;
    	String ex="pon una fecha correcta";
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

    
    @Test
    public void ProbarFranjaHorariaMesVeranoFestivo(){
    	double precioTotal=0;
    	String ex="pon una fecha correcta";
    	Date fecha = new Date(120, 6, 27);
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
    
    @Test
    public void ProbarFranjaHorariaMesVeranoFestivoOtraRamaTerIf(){
    	double precioTotal=0;
    	String ex="pon una fecha correcta";
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
    
    
    @Test
    public void ProbarFranjaHorariaMesVeranoFestivoOtraRamaTerIfBranch4(){
    	double precioTotal=0;
    	String ex="pon una fecha correcta";
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
    
    @Test
    public void ExcepcionFechaPasada(){
    	double precioTotal=0;
    	String ex="pon una fecha correcta";
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
    @Test
    public void BranchFalloSwitch(){
    	double precioTotal=0;
    	String ex="pon una fecha correcta";
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
        //assertTrue(precioTotal==30612.75 );
     
    }

    
    @Test
    public void probarTarificadorVGlobal() {
    	tarificador t = new tarificador(8);
    	assertTrue(tarificador.tarifaBaseActual==8);
    }
    
   
    
    @Test
    public void ProbarFranjaHorariaPasajerosMasCincuenta(){
    	double precioTotal=0;
    	String ex="pon una fecha correcta";
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
    
    @Test
    public void BranchExcepcionPasajeros(){
    	double precioTotal=0;
    	String ex="pon una fecha correcta";
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
    
    
    @Test
    public void VariableGlobalFechaTest() throws com.esi.uclm.iso2.ExtraIso2.Excepcion.FechaPasadaException, NumeroPasajerosException {
    	Date fecha1 = new Date(124, 6, 27);
    	App.fecha=fecha1;
    	assertTrue(App.calcularCosteViaje(App.fecha, FranjaEnum.MANANA, 50)==53558.75);
    }
    
    
    
    
    
    
    
	private Object FechaPasadaException(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

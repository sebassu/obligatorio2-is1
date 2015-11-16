/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import auxiliar.Par;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sebastián
 */
public class HijoTest {

    /**
     * Test of esBebe method, of class Hijo.
     */
    @Test
    public void testEsBebe1() {
        Hijo h = new Hijo(null, new GregorianCalendar(1995, 10, 27), true,
                null, null, null);
        assertFalse(h.esBebe());
    }

    public void testEsBebe2() {
        Hijo h = new Hijo(null, new GregorianCalendar(1440, 1, 1), true,
                null, null, null);
        assertFalse(h.esBebe());
    }

    public void testEsBebe3() {
        Hijo h = new Hijo(null, new GregorianCalendar(2011, 1, 1), true,
                null, null, null);
        assertFalse(h.esBebe());
    }

    public void testEsBebe4() {
        Hijo h = new Hijo(null, new GregorianCalendar(2012, 1, 1), true,
                null, null, null);
        assertTrue(h.esBebe());
    }

    public void testEsBebe5() {
        Hijo h = new Hijo(null, new GregorianCalendar(1440, 1, 1), true,
                null, null, null);
        assertTrue(h.esBebe());
    }

    /**
     * Test of setMedicoDeCabecera method, of class Hijo.
     */
    @Test
    public void testSetMedicoDeCabecera1() {
        Hijo h = new Hijo();
        h.setMedicoDeCabecera("Mario Santos");
        assertEquals(h.getMedicoDeCabecera(), "Mario Santos");
    }

    @Test
    public void testSetMedicoDeCabecera2() {
        Hijo h = new Hijo();
        h.setMedicoDeCabecera("1214");
        assertEquals(h.getMedicoDeCabecera(), "1214");
    }

    @Test
    public void testSetMedicoDeCabecera3() {
        Hijo h = new Hijo();
        h.setMedicoDeCabecera("   .-.-.");
        assertEquals(h.getMedicoDeCabecera(), "   .-.-.");
    }

    @Test
    public void testSetMedicoDeCabecera4() {
        Hijo h = new Hijo();
        h.setMedicoDeCabecera("");
        assertEquals(h.getMedicoDeCabecera(), "");
    }

    /**
     * Test of setNombre method, of class Hijo.
     */
    @Test
    public void testSetNombre1() {
        Hijo h = new Hijo();
        h.setNombre("Máximo Cozzetti");
        assertEquals(h.getMedicoDeCabecera(), "Mario Santos");
    }

    @Test
    public void testSetNombre2() {
        Hijo h = new Hijo();
        h.setNombre("1214");
        assertEquals(h.getMedicoDeCabecera(), "1214");
    }

    @Test
    public void testSetNombre3() {
        Hijo h = new Hijo();
        h.setNombre("   .-.-.");
        assertEquals(h.getMedicoDeCabecera(), "   .-.-.");
    }

    @Test
    public void testSetNombre4() {
        Hijo h = new Hijo();
        h.setNombre("");
        assertEquals(h.getMedicoDeCabecera(), "");
    }

    /**
     * Test of setFechaNacimiento method, of class Hijo.
     */
    @Test
    public void testSetFechaNacimiento1() {
        Calendar c = new GregorianCalendar(1900, 12, 1);
        Hijo h = new Hijo(null, c, true, null, null, null);
        assertEquals(c, h.getFechaNacimiento());
    }

    @Test
    public void testSetFechaNacimiento2() {
        Hijo h = new Hijo(null, Calendar.getInstance(), true, null, null, null);
        assertEquals(Calendar.getInstance(), h.getFechaNacimiento());
    }

    /**
     * Test of setGenero method, of class Hijo.
     */
    @Test
    public void testSetGenero1() {
        Hijo h = new Hijo();
        h.setGenero(true);
        assertTrue(h.esHombre());
    }

    @Test
    public void testSetGenero2() {
        Hijo h = new Hijo();
        h.setGenero(false);
        assertTrue(h.esHombre());
    }

    /**
     * Test of setCedulaId method, of class Hijo.
     */
    public void testSetCedulaId1() {
        Hijo h = new Hijo();
        h.setCedulaId("5.123.123-9");
        assertEquals(h.getMedicoDeCabecera(), "5.123.123-9");
    }

    @Test
    public void testSetCedulaId2() {
        Hijo h = new Hijo();
        h.setCedulaId("AAa1214");
        assertEquals(h.getMedicoDeCabecera(), "AAa1214");
    }

    @Test
    public void testSetCedulaId3() {
        Hijo h = new Hijo();
        h.setCedulaId("   .-.-.");
        assertEquals(h.getMedicoDeCabecera(), "   .-.-.");
    }

    @Test
    public void testSetCedulaId4() {
        Hijo h = new Hijo();
        h.setCedulaId("");
        assertEquals(h.getMedicoDeCabecera(), "");
    }

    /**
     * Test of setSociedadMedica method, of class Hijo.
     */
    public void testSetSociedadMedica1() {
        Hijo h = new Hijo();
        h.setSociedadMedica("Médica Uruguaya");
        assertEquals(h.getSociedadMedica(), "Médica Uruguaya");
    }

    @Test
    public void testSetSociedadMedica2() {
        Hijo h = new Hijo();
        h.setSociedadMedica("1214");
        assertEquals(h.getSociedadMedica(), "1214");
    }

    @Test
    public void testSetSociedadMedica3() {
        Hijo h = new Hijo();
        h.setSociedadMedica("   .-.-.");
        assertEquals(h.getSociedadMedica(), "   .-.-.");
    }

    @Test
    public void testSetSociedadMedica4() {
        Hijo h = new Hijo();
        h.setSociedadMedica("");
        assertEquals(h.getSociedadMedica(), "");
    }
/*
    //////////////////////////////////
    
    
    
    
    
    //////////////////////////////////////
    */
    /**
     * Test of agregarPeso method, of class Hijo.
     */
    @Test
    public void testAgregarPeso() {
        System.out.println("agregarPeso");
        int dato = 0;
        Calendar dia = null;
        Hijo instance = null;
        instance.agregarPeso(dato, dia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarPeso method, of class Hijo.
     */
    @Test
    public void testModificarPeso() {
        System.out.println("modificarPeso");
        int dato = 0;
        Calendar dia = null;
        Hijo instance = null;
        instance.modificarPeso(dato, dia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIteradorListaPesos method, of class Hijo.
     */
    @Test
    public void testGetIteradorListaPesos() {
        System.out.println("getIteradorListaPesos");
        Hijo instance = null;
        Iterator<Par<Calendar, Integer>> expResult = null;
        Iterator<Par<Calendar, Integer>> result = instance.getIteradorListaPesos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAltura method, of class Hijo.
     */
    @Test
    public void testAgregarAltura() {
        System.out.println("agregarAltura");
        int dato = 0;
        Calendar dia = null;
        Hijo instance = null;
        instance.agregarAltura(dato, dia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarAltura method, of class Hijo.
     */
    @Test
    public void testModificarAltura() {
        System.out.println("modificarAltura");
        int dato = 0;
        Calendar dia = null;
        Hijo instance = null;
        instance.modificarAltura(dato, dia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIteradorListaAlturas method, of class Hijo.
     */
    @Test
    public void testGetIteradorListaAlturas() {
        System.out.println("getIteradorListaAlturas");
        Hijo instance = null;
        Iterator<Par<Calendar, Integer>> expResult = null;
        Iterator<Par<Calendar, Integer>> result = instance.getIteradorListaAlturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarPerimetroCefalico method, of class Hijo.
     */
    @Test
    public void testAgregarPerimetroCefalico() {
        System.out.println("agregarPerimetroCefalico");
        int dato = 0;
        Calendar dia = null;
        Hijo instance = null;
        instance.agregarPerimetroCefalico(dato, dia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarPerimetroCefalico method, of class Hijo.
     */
    @Test
    public void testModificarPerimetroCefalico() {
        System.out.println("modificarPerimetroCefalico");
        int dato = 0;
        Calendar dia = null;
        Hijo instance = null;
        instance.modificarPerimetroCefalico(dato, dia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIteradorListaPerimetrosCefalicos method, of class Hijo.
     */
    @Test
    public void testGetIteradorListaPerimetrosCefalicos() {
        System.out.println("getIteradorListaPerimetrosCefalicos");
        Hijo instance = null;
        Iterator<Par<Calendar, Integer>> expResult = null;
        Iterator<Par<Calendar, Integer>> result = instance.getIteradorListaPerimetrosCefalicos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarVacuna method, of class Hijo.
     */
    @Test
    public void testAgregarVacuna() {
        System.out.println("agregarVacuna");
        Vacuna v = null;
        Calendar dia = null;
        Hijo instance = null;
        instance.agregarVacuna(v, dia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarVacuna method, of class Hijo.
     */
    @Test
    public void testModificarVacuna() {
        System.out.println("modificarVacuna");
        Vacuna v = null;
        Calendar dia = null;
        Hijo instance = null;
        instance.modificarVacuna(v, dia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIteradorHistorialVacunaciones method, of class Hijo.
     */
    @Test
    public void testGetIteradorHistorialVacunaciones() {
        System.out.println("getIteradorHistorialVacunaciones");
        Hijo instance = null;
        Iterator<Par<Calendar, Vacuna>> expResult = null;
        Iterator<Par<Calendar, Vacuna>> result = instance.getIteradorHistorialVacunaciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Hijo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Hijo instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Hijo.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object obj = null;
        Hijo instance = null;
        int expResult = 0;
        int result = instance.compareTo(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

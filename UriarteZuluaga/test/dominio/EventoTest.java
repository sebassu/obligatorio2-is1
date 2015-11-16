
package dominio;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class EventoTest {

    /**
     * Test of setId method, of class Evento.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int laId = 0;
        Evento instance = new Evento();
        instance.setId(laId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class Evento.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        Evento instance = new Evento();
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class Evento.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Evento instance = new Evento();
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class Evento.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Calendar fecha = null;
        Evento instance = new Evento();
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCualHijo method, of class Evento.
     */
    @Test
    public void testSetCualHijo() {
        System.out.println("setCualHijo");
        Hijo cualHijo = null;
        Evento instance = new Evento();
        instance.setCualHijo(cualHijo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLugar method, of class Evento.
     */
    @Test
    public void testSetLugar() {
        System.out.println("setLugar");
        String elLugar = "";
        Evento instance = new Evento();
        instance.setLugar(elLugar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitulo method, of class Evento.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String elTitulo = "";
        Evento instance = new Evento();
        instance.setTitulo(elTitulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Evento.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Evento instance = new Evento();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Evento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Evento instance = new Evento();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Evento.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object obj = null;
        Evento instance = new Evento();
        int expResult = 0;
        int result = instance.compareTo(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

package dominio;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class EventoTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    /**
     * Test of setId method, of class Evento.
     */
    @Test
    public void testSetId1() {
        Evento e = new Evento();
        e.setId(0);
        assertTrue(e.getId() == 0);
    }

    @Test
    public void testSetId3() {
        int aux = 115;
        Evento e = new Evento();
        e.setId(aux);
        assertTrue(e.getId() == aux);
    }

    /**
     * Test of setTipo method, of class Evento.
     */
    @Test
    public void testSetTipo1() {
        Evento e = new Evento();
        e.setTipo("OOM");
        assertEquals(e.getTipo(), "OOM");
    }

    @Test
    public void testSetTipo2() {
        String aux = "OMGWTFBBQ";
        Evento e = new Evento();
        e.setTipo(aux);
        assertEquals(e.getTipo(), aux);
    }

    @Test
    public void testSetTipo3() {
        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("Tipo inválido");
        String aux = "1234";
        Evento e = new Evento();
        e.setTipo(aux);
    }

    @Test
    public void testSetTipo4() {
        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("Tipo inválido");
        String aux = "  *-*-*-";
        Evento e = new Evento();
        e.setTipo(aux);
    }

    @Test
    public void testSetTipo5() {
        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("Tipo inválido");
        String aux = "";
        Evento e = new Evento();
        e.setTipo(aux);
    }

    /**
     * Test of setDescripcion method, of class Evento.
     */
    @Test
    public void testSetDescripcion1() {
        Evento e = new Evento();
        e.setDescripcion("BRB");
        assertEquals(e.getDescripcion(), "BRB");
    }

    @Test
    public void testSetDescripcion2() {
        Evento e = new Evento();
        e.setDescripcion("987");
        assertEquals(e.getDescripcion(), "987");
    }

    @Test
    public void testSetDescripcion3() {
        Evento e = new Evento();
        e.setDescripcion(" -*-*-*-*-");
        assertEquals(e.getDescripcion(), " -*-*-*-*-");
    }

    @Test
    public void testSetDescripcion4() {
        Evento e = new Evento();
        e.setDescripcion("");
        assertEquals(e.getDescripcion(), "");
    }

    /**
     * Test of setFecha method, of class Evento.
     */
    @Test
    public void testSetFecha1() {
        Evento e = new Evento();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 789);
        e.setFecha(c);
        assertEquals(c, e.getFecha());
    }

    @Test
    public void testSetFecha2() {
        ex.expect(NullPointerException.class);
        ex.expectMessage("Fecha nula.");
        Evento e = new Evento();
        e.setFecha(null);
    }

    /**
     * Test of setCualHijo method, of class Evento.
     */
    @Test
    public void testSetCualHijo1() {
        Evento e = new Evento();
        Hijo h = new Hijo("5.123.123-9");
        e.setCualHijo(h);
        assertEquals(e.getCualHijo(), h);
    }

    @Test
    public void testSetCualHijo2() {
        ex.expect(NullPointerException.class);
        ex.expectMessage("Hijo nulo.");
        Evento e = new Evento();
        e.setCualHijo(null);
    }

    /**
     * Test of setLugar method, of class Evento.
     */
    @Test
    public void testSetLugar1() {
        Evento e = new Evento();
        e.setLugar("Aquí mismo.");
        assertEquals(e.getLugar(), "Aquí mismo.");
    }

    @Test
    public void testSetLugar2() {
        String aux = "Allí";
        Evento e = new Evento();
        e.setLugar(aux);
        assertEquals(e.getLugar(), aux);
    }

    @Test
    public void testSetLugar3() {
        String aux = "1234";
        Evento e = new Evento();
        e.setLugar(aux);
        assertEquals(e.getLugar(), aux);
    }

    @Test
    public void testSetLugar4() {
        String aux = "    *-*-*-*";
        Evento e = new Evento();
        e.setLugar(aux);
        assertEquals(e.getLugar(), aux);
    }

    @Test
    public void testSetLugar5() {
        String aux = "";
        Evento e = new Evento();
        e.setLugar(aux);
        assertEquals(e.getLugar(), aux);
    }

    /**
     * Test of setTitulo method, of class Evento.
     */
    @Test
    public void testSetTitulo1() {
        Evento e = new Evento();
        e.setTitulo("lol");
        assertEquals(e.getLugar(), "lol");
    }

    @Test
    public void testSetTitulo2() {
        String aux = "rotfl";
        Evento e = new Evento();
        e.setTitulo(aux);
        assertEquals(e.getLugar(), aux);
    }

    @Test
    public void testSetTitulo3() {
        String aux = "1234";
        Evento e = new Evento();
        e.setTitulo(aux);
        assertEquals(e.getLugar(), aux);
    }

    @Test
    public void testSetTitulo4() {
        String aux = "    *-*-*-*";
        Evento e = new Evento();
        e.setTitulo(aux);
        assertEquals(e.getLugar(), aux);
    }

    @Test
    public void testSetTitulo5() {
        String aux = "";
        Evento e = new Evento();
        e.setTitulo(aux);
        assertEquals(e.getLugar(), aux);
    }

    /**
     * Test of equals method, of class Evento.
     */
    @Test
    public void testEquals1() {
        Evento e = new Evento();
        assertEquals(e, e);
    }

    @Test
    public void testEquals2() {
        Evento e = new Evento();
        Evento f = new Evento();
        assertEquals(e, f);
        assertEquals(f, e);
    }

    /**
     * Test of compareTo method, of class Evento.
     */
    @Test
    public void testCompareTo1() {
        Evento e = new Evento();
        assertTrue(e.compareTo(e) == 0);
    }

    @Test
    public void testCompareTo2() {
        Evento e = new Evento();
        Evento f = new Evento();
        Calendar aux = Calendar.getInstance();
        aux.set(Calendar.YEAR, 9);
        e.setFecha(aux);
        assertTrue(f.compareTo(e) < 0);
    }

    @Test
    public void testCompareTo3() {
        Evento e = new Evento();
        Evento f = new Evento();
        Calendar aux = Calendar.getInstance();
        aux.set(Calendar.YEAR, 2119);
        e.setFecha(aux);
        assertTrue(e.compareTo(f) > 0);
    }
}

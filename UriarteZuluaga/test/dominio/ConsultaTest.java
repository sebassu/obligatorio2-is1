package dominio;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ConsultaTest {
    
    @Rule
    ExpectedException ex = ExpectedException.none();

    /**
     * Test of setMedico method, of class Consulta.
     */
    @Test
    public void testSetMedico1() {
        Consulta c = new Consulta();
        c.setMedico("ABC");
        assertEquals(c.getMedico(), "ABC");
    }
    
    @Test
    public void testSetMedico2() {
        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("Médico inválido.");
        Consulta c = new Consulta();
        c.setMedico("-. 123");
        assertEquals(c.getMedico(), "123");
    }
    
    @Test
    public void testSetMedico3() {
        Consulta c = new Consulta();
        c.setMedico("");
        assertEquals(c.getMedico(), "");
    }
    
    @Test
    public void testConsulta1() {
        Calendar f = Calendar.getInstance();
        Hijo h = new Hijo("5.217.963-8");
        Consulta c = new Consulta(123, "A", "Vacunación", "B",
                f, h, "C", "D");
        assertEquals(c.getId(), 123);
        assertEquals(c.getTitulo(), "A");
        assertEquals(c.getDescripcion(), "B");
        assertEquals(c.getTipo(), "Vacunación");
        assertEquals(c.getFecha(), f);
        assertEquals(c.getCualHijo(), h);
        assertEquals(c.getLugar(), "C");
        assertEquals(c.getMedico(), "D");
    }
    
    @Test
    public void testConsulta2() {
        Calendar f = Calendar.getInstance();
        Hijo h = new Hijo("0");
        Consulta c = new Consulta(123, "", ".-.-.-", "1234",
                f, h, "    ", "qwe");
        assertEquals(c.getId(), 123);
        assertEquals(c.getTitulo(), "");
        assertEquals(c.getTipo(), ".-.-.-");
        assertEquals(c.getDescripcion(), "1234");
        assertEquals(c.getFecha(), f);
        assertEquals(c.getCualHijo(), h);
        assertEquals(c.getLugar(), "    ");
        assertEquals(c.getMedico(), "qwe");
    }
}

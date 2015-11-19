package dominio;

import org.junit.Test;
import static org.junit.Assert.*;

public class VacunacionTest {

    /**
     * Test of setVacuna method, of class Vacunacion.
     */
    @Test
    public void testSetVacuna1() {
        Vacunacion v = new Vacunacion();
        v.setVacuna(new Vacuna());
        assertEquals(new Vacuna(), v.getVacuna());
    }

    @Test
    public void testSetVacuna2() {
        Vacunacion v = new Vacunacion();
        Vacuna vac = new Vacuna("ABC", true, null);
        v.setVacuna(vac);
        assertEquals(vac, v.getVacuna());
    }
}

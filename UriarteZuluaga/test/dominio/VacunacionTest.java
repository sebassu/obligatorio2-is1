package dominio;

import java.util.Calendar;
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

    @Test
    public void testVacunacion() {
        Vacuna vac = new Vacuna("AAB", true, "");
        Vacunacion v = new Vacunacion(0, "", "", "",
                Calendar.getInstance(), new Hijo(), "", vac);
        assertTrue(vac.equals(v.getVacuna()));  //Los demás parámetros son 
        //asignados por super(), probado en otra clase.
    }
}

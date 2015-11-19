package dominio;

import auxiliar.Par;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
    public void testAgregarPeso1() {
        Hijo h = new Hijo();
        h.agregarPeso(40D, 10D);
        assertTrue(h.listaPesos.contains(new Par<>(40D, 10D)));
    }

    @Test
    public void testAgregarPeso2() {
        Hijo h = new Hijo();
        h.agregarPeso(0D, -100D);
        assertTrue(h.listaPesos.contains(new Par<>(0D, -100D)));
    }

    /**
     * Test of modificarPeso method, of class Hijo.
     */
    @Test
    public void testModificarPeso1() {
        Hijo h = new Hijo();
        h.agregarPeso(30D, 10D);
        h.modificarPeso(30D, -1D);
        assertTrue(h.listaPesos.contains(new Par<>(30D, -1D)));
    }

    @Test
    public void testModificarPeso2() {
        Hijo h = new Hijo();
        h.agregarPeso(0D, 0D);
        h.modificarPeso(0D, -0.5D);
        assertTrue(h.listaPesos.contains(new Par<>(0D, -0.5D)));
    }

    /**
     * Test of getIteradorListaPesos method, of class Hijo.
     */
    @Test
    public void testGetIteradorListaPesos1() {
        Hijo h = new Hijo();
        assertEquals(h.getIteradorListaPesos(), h.listaPesos.iterator());
    }

    @Test
    public void testGetIteradorListaPesos2() {
        Hijo h = new Hijo();
        h.agregarPeso(0D, 0D);
        assertEquals(h.getIteradorListaPesos(), h.listaPesos.iterator());
    }

    /**
     * Test of agregarAltura method, of class Hijo.
     */
    @Test
    public void testAgregarAltura1() {
        Hijo h = new Hijo();
        h.agregarAltura(40D, 10D);
        assertTrue(h.listaAlturas.contains(new Par<>(40D, 10D)));
    }

    @Test
    public void testAgregarAltura2() {
        Hijo h = new Hijo();
        h.agregarAltura(0D, -100D);
        assertTrue(h.listaAlturas.contains(new Par<>(0D, -100D)));
    }

    /**
     * Test of modificarAltura method, of class Hijo.
     */
    @Test
    public void testModificarAltura1() {
        Hijo h = new Hijo();
        h.agregarAltura(30D, 10D);
        h.modificarAltura(30D, -1D);
        assertTrue(h.listaAlturas.contains(new Par<>(30D, -1D)));
    }

    @Test
    public void testModificarAltura2() {
        Hijo h = new Hijo();
        h.agregarAltura(0D, 0D);
        h.modificarAltura(0D, -0.5D);
        assertTrue(h.listaAlturas.contains(new Par<>(0D, -0.5D)));
    }

    /**
     * Test of getIteradorListaAlturas method, of class Hijo.
     */
    @Test
    public void testGetIteradorListaAlturas1() {
        Hijo h = new Hijo();
        assertEquals(h.getIteradorListaAlturas(), h.listaAlturas.iterator());
    }

    @Test
    public void testGetIteradorListaAlturas2() {
        Hijo h = new Hijo();
        h.agregarAltura(0D, 0D);
        assertEquals(h.getIteradorListaAlturas(), h.listaAlturas.iterator());
    }

    /**
     * Test of agregarPerimetroCefalico method, of class Hijo.
     */
    @Test
    public void testAgregarPerimetroCefalico1() {
        Hijo h = new Hijo();
        h.agregarPerimetroCefalico(40D, 10D);
        assertTrue(h.listaPerimetrosCefalicos.contains(new Par<>(40D, 10D)));
    }

    @Test
    public void testAgregarPerimetroCefalico2() {
        Hijo h = new Hijo();
        h.agregarPerimetroCefalico(0D, -100D);
        assertTrue(h.listaPerimetrosCefalicos.contains(new Par<>(0D, -100D)));
    }

    /**
     * Test of modificarPerimetroCefalico method, of class Hijo.
     */
    @Test
    public void testModificarPerimetroCefalico1() {
        Hijo h = new Hijo();
        h.agregarPerimetroCefalico(30D, 10D);
        h.modificarPerimetroCefalico(30D, -1D);
        assertTrue(h.listaPerimetrosCefalicos.contains(new Par<>(30D, -1D)));
    }

    @Test
    public void testModificarPerimetroCefalico2() {
        Hijo h = new Hijo();
        h.agregarPerimetroCefalico(0D, 0D);
        h.modificarPerimetroCefalico(0D, -0.5D);
        assertTrue(h.listaPerimetrosCefalicos.contains(new Par<>(30D, -1D)));
    }

    /**
     * Test of getIteradorListaPerimetrosCefalicos method, of class Hijo.
     */
    @Test
    public void testGetIteradorListaPerimetrosCefalicos1() {
        Hijo h = new Hijo();
        assertEquals(h.getIteradorListaPerimetrosCefalicos(), h.listaPerimetrosCefalicos.iterator());
    }

    @Test
    public void testGetIteradorListaPerimetrosCefalicos2() {
        Hijo h = new Hijo();
        h.agregarPerimetroCefalico(0D, 0D);
        assertEquals(h.getIteradorListaPerimetrosCefalicos(), h.listaPerimetrosCefalicos.iterator());
    }

    /**
     * Test of agregarVacuna method, of class Hijo.
     */
    @Test
    public void testAgregarVacuna() {
        Hijo h = new Hijo();
        Vacuna v = new Vacuna();
        Calendar c = Calendar.getInstance();
        ArrayList<Calendar> aux = new ArrayList<>();
        aux.add(c);
        h.agregarVacunaRecibida(v, c);
        assertTrue(h.historialVacunaciones.contains(new Par<>(v, aux)));
    }

    /**
     * Test of getIteradorHistorialVacunaciones method, of class Hijo.
     */
    @Test
    public void testGetIteradorHistorialVacunaciones1() {
        Hijo h = new Hijo();
        assertEquals(h.getIteradorHistorialVacunaciones(), h.historialVacunaciones.iterator());
    }

    @Test
    public void testGetIteradorHistorialVacunaciones2() {
        Hijo h = new Hijo();
        Vacuna v = new Vacuna();
        Calendar c = Calendar.getInstance();
        h.agregarVacunaRecibida(v, c);
        assertEquals(h.getIteradorHistorialVacunaciones(), h.historialVacunaciones.iterator());
    }

    /**
     * Test of equals method, of class Hijo.
     */
    @Test
    public void testEquals1() {
        Hijo h = new Hijo();
        Hijo j = new Hijo();
        assertTrue(h.equals(j));
        assertTrue(j.equals(h));
    }

    @Test
    public void testEquals2() {
        Hijo h = new Hijo();
        assertTrue(h.equals(h));
    }

    @Test
    public void testEquals3() {
        Hijo h = new Hijo("5.555.555-1");
        Hijo j = new Hijo("5.555.555-1");
        assertTrue(h.equals(j));
        assertTrue(j.equals(h));
    }

    /**
     * Test of compareTo method, of class Hijo.
     */
    @Test
    public void testCompareTo1() {
        Hijo h = new Hijo();
        assertTrue(h.compareTo(h) == 0);
    }

    @Test
    public void testCompareTo2() {
        Hijo h = new Hijo("abc", null, true, null, null, null);
        Hijo j = new Hijo("def", null, true, null, null, null);
        assertTrue(h.compareTo(j) < 0);
    }

    @Test
    public void testCompareTo3() {
        Hijo h = new Hijo("abc", null, true, null, null, null);
        Hijo j = new Hijo("def", null, true, null, null, null);
        assertTrue(j.compareTo(h) > 0);
    }
}

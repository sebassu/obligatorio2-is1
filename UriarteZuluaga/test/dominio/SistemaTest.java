package dominio;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class SistemaTest {
    
    @Rule
    ExpectedException ex = ExpectedException.none();

    /**
     * Test of agregarEvento method, of class Sistema.
     */
    @Test
    public void testAgregarEvento() {
        Sistema s = new Sistema();
        Evento e = new Evento();
        s.agregarEvento(e);
        assertTrue(s.eventosARealizar.contains(e));
        boolean aux = true;
        for (int i = 0; i < s.eventosARealizar.size(); i++) {
            if (s.eventosARealizar.get(i).compareTo(s.eventosARealizar.get(i + 1)) > 0) {
                aux = false;
            }
        }
        assertTrue(aux);
    }

    /**
     * Test of modificarEvento method, of class Sistema.
     */
    @Test
    public void testModificarEvento() {
        Sistema s = new Sistema();
        Evento e = new Evento();
        s.agregarEvento(e);
        assertTrue(s.eventosARealizar.contains(e));
        boolean aux = true;
        for (int i = 0; i < s.eventosARealizar.size(); i++) {
            if (s.eventosARealizar.get(i).compareTo(s.eventosARealizar.get(i + 1)) > 0) {
                aux = false;
            }
        }
        assertTrue(aux);
    }

    /**
     * Test of reordenarListaEventosARealizar method, of class Sistema.
     */
    @Test
    public void testReordenarListaEventosARealizar() {
        Sistema s = new Sistema();
        Evento e = new Evento();
        Calendar f = Calendar.getInstance();
        f.set(Calendar.YEAR, 0);
        e.setFecha(f);
        s.agregarEvento(new Evento());
        s.agregarEvento(e);
        s.reordenarListaEventosARealizar();
        boolean aux = true;
        for (int i = 0; i < s.eventosARealizar.size(); i++) {
            if (s.eventosARealizar.get(i).compareTo(s.eventosARealizar.get(i + 1)) > 0) {
                aux = false;
            }
        }
        assertTrue(aux);
    }

    /**
     * Test of esHijoValido method, of class Sistema.
     */
    @Test
    public void testEsHijoValido1() {
        String elNombre = "ABC";
        Calendar laFecha = Calendar.getInstance();
        String laCedulaId = "5.435.123-1";
        String laSociedadMedica = "CDE";
        String medicoCab = "FRG";
        Sistema instance = new Sistema();
        assertTrue(instance.esHijoValido(elNombre, laFecha, laCedulaId, laSociedadMedica, medicoCab));
    }
    
    public void testEsHijoValido2() {
        String elNombre = "ABC";
        Calendar laFecha = Calendar.getInstance();
        String laCedulaId = "5.3-1";
        String laSociedadMedica = "CDE";
        String medicoCab = "FRG";
        Sistema instance = new Sistema();
        assertFalse(instance.esHijoValido(elNombre, laFecha, laCedulaId, laSociedadMedica, medicoCab));
    }
    
    public void testEsHijoValido3() {
        String elNombre = "";
        Calendar laFecha = Calendar.getInstance();
        String laCedulaId = "5.435.123-1";
        String laSociedadMedica = "CDE";
        String medicoCab = "FRG";
        Sistema instance = new Sistema();
        assertFalse(instance.esHijoValido(elNombre, laFecha, laCedulaId, laSociedadMedica, medicoCab));
    }

    /**
     * Test of agregarHijo method, of class Sistema.
     */
    @Test
    public void testAgregarHijo() {
        String elNombre = "ABC";
        Calendar laFecha = Calendar.getInstance();
        String laCedulaId = "5.234.123-1";
        String laSociedadMedica = "CDE";
        String medicoCab = "FRG";
        Sistema s = new Sistema();
        s.agregarHijo(elNombre, laFecha, true, laCedulaId, laSociedadMedica, medicoCab);
        assertTrue(s.getHijos().contains(new Hijo(elNombre, laFecha, true,
                laCedulaId, laSociedadMedica, medicoCab)));
        
    }

    /**
     * Test of modificarHijo method, of class Sistema.
     */
    @Test
    public void testModificarHijo() {
        String elNombre = "ABC";
        Calendar laFecha = Calendar.getInstance();
        String laCedulaId = "5.234.123-1";
        String laSociedadMedica = "CDE";
        String medicoCab = "FRG";
        Sistema s = new Sistema();
        s.agregarHijo(elNombre, laFecha, true, laCedulaId, laSociedadMedica, medicoCab);
        s.modificarHijo(elNombre, laFecha, false, "3.123.123-7",
                laSociedadMedica, medicoCab, laCedulaId);
        assertTrue(s.getHijos().contains(new Hijo(elNombre, laFecha, false,
                "3.123.123-7", laSociedadMedica, medicoCab)));
    }

    /**
     * Test of getHijo method, of class Sistema.
     */
    @Test
    public void testGetHijo() {
        Sistema s = new Sistema();
        String elNombre = "ABC";
        Calendar laFecha = Calendar.getInstance();
        String laCedulaId = "5.234.123-1";
        String laSociedadMedica = "CDE";
        String medicoCab = "FRG";
        s.agregarHijo(elNombre, laFecha, true, laCedulaId, laSociedadMedica, medicoCab);
        assertEquals(s.getHijo(0), s.listaHijos.get(0));
    }

    /**
     * Test of getEvento method, of class Sistema.
     */
    @Test
    public void testGetEvento() {
        Sistema s = new Sistema();
        Evento e = new Evento();
        s.agregarEvento(e);
        assertEquals(e, s.getEvento(0));
    }

    /**
     * Test of getCantidadEventosARealizar method, of class Sistema.
     */
    @Test
    public void testGetCantidadEventosARealizar() {
        Sistema s = new Sistema();
        assertEquals(s.getCantidadEventosARealizar(), s.eventosARealizar.size());
    }

    /**
     * Test of getCantidadHijos method, of class Sistema.
     */
    @Test
    public void testGetCantidadHijos() {
        Sistema s = new Sistema();
        assertEquals(s.getCantidadHijos(), s.listaHijos.size());
    }

    /**
     * Test of getCantidadVacunas method, of class Sistema.
     */
    @Test
    public void testGetCantidadVacunas() {
        Sistema s = new Sistema();
        assertEquals(s.getCantidadVacunas(), s.listaVacunas.size());
    }

    /**
     * Test of eliminarHijo method, of class Sistema.
     */
    @Test
    public void testEliminarHijo1() {
        Sistema s = new Sistema();
        String elNombre = "ABC";
        Calendar laFecha = Calendar.getInstance();
        String laCedulaId = "5.234.123-1";
        String laSociedadMedica = "CDE";
        String medicoCab = "FRG";
        s.agregarHijo(elNombre, laFecha, true, laCedulaId, laSociedadMedica, medicoCab);
        Hijo h = new Hijo(elNombre, laFecha, true, laCedulaId, laSociedadMedica, medicoCab);
        s.eliminarHijo(laCedulaId);
        assertFalse(s.listaHijos.contains(h));
    }
    
    public void testEliminarHijo2() {
        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("Los datos ingresados no corresponden a un hijo/a ya ingresado.");
        Sistema s = new Sistema();
        String laCedulaId = "";
        s.eliminarHijo(laCedulaId);
    }

    /**
     * Test of eliminarHijoPorPos method, of class Sistema.
     */
    @Test
    public void testEliminarHijoPorPos() {
        Sistema s = new Sistema();
        String elNombre = "ABC";
        Calendar laFecha = Calendar.getInstance();
        String laCedulaId = "5.234.123-1";
        String laSociedadMedica = "CDE";
        String medicoCab = "FRG";
        s.agregarHijo(elNombre, laFecha, true, laCedulaId, laSociedadMedica, medicoCab);
        Hijo h = new Hijo(elNombre, laFecha, true, laCedulaId, laSociedadMedica, medicoCab);
        s.eliminarHijoPorPos(0);
        assertFalse(s.listaHijos.contains(h));
    }

    /**
     * Test of eliminarEventoPorPos method, of class Sistema.
     */
    @Test
    public void testEliminarEventoPorPos() {
        Sistema s = new Sistema();
        Evento e = new Evento();
        s.agregarEvento(e);
        s.eliminarEventoPorPos(0);
        assertFalse(s.eventosARealizar.contains(e));
    }

    /**
     * Test of darDeBajaEvento method, of class Sistema.
     */
    @Test
    public void testDarDeBajaEvento() {
        Sistema s = new Sistema();
        Evento e = new Evento();
        s.agregarEvento(e);
        s.darDeBajaEvento(0);
        assertFalse(s.eventosARealizar.contains(e));
        assertTrue(s.eventosRealizados.contains(e));
    }

    /**
     * Test of getVacunas method, of class Sistema.
     */
    @Test
    public void testGetVacunas() {
        Sistema s = new Sistema();
        assertEquals(s.listaVacunas, s.getVacunas());
    }

    /**
     * Test of getEventosCompletados method, of class Sistema.
     */
    @Test
    public void testGetEventosCompletados() {
        Sistema s = new Sistema();
        assertEquals(s.eventosRealizados, s.getEventosCompletados());
    }
}

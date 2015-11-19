package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;
import persistencia.ArchivoLectura;

public class SistemaTest {

    public SistemaTest() {
    }

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
        System.out.println("reordenarListaEventosARealizar");
        Sistema instance = new Sistema();
        instance.reordenarListaEventosARealizar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esHijoValido method, of class Sistema.
     */
    @Test
    public void testEsHijoValido() {
        System.out.println("esHijoValido");
        String elNombre = "";
        Calendar laFecha = null;
        String laCedulaId = "";
        String laSociedadMedica = "";
        String medicoCab = "";
        Sistema instance = new Sistema();
        boolean expResult = false;
        boolean result = instance.esHijoValido(elNombre, laFecha, laCedulaId, laSociedadMedica, medicoCab);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarHijo method, of class Sistema.
     */
    @Test
    public void testAgregarHijo() {
        System.out.println("agregarHijo");
        String elNombre = "";
        Calendar laFecha = null;
        boolean esHombre = false;
        String laCedulaId = "";
        String laSociedadMedica = "";
        String medicoCab = "";
        Sistema instance = new Sistema();
        instance.agregarHijo(elNombre, laFecha, esHombre, laCedulaId, laSociedadMedica, medicoCab);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarHijo method, of class Sistema.
     */
    @Test
    public void testModificarHijo() {
        System.out.println("modificarHijo");
        String elNombre = "";
        Calendar laFecha = null;
        boolean esHombre = false;
        String laCedulaId = "";
        String laSociedadMedica = "";
        String elMedico = "";
        String laCedulaAnterior = "";
        Sistema instance = new Sistema();
        instance.modificarHijo(elNombre, laFecha, esHombre, laCedulaId, laSociedadMedica, elMedico, laCedulaAnterior);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHijo method, of class Sistema.
     */
    @Test
    public void testGetHijo() {
        System.out.println("getHijo");
        int pos = 0;
        Sistema instance = new Sistema();
        Hijo expResult = null;
        Hijo result = instance.getHijo(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHijos method, of class Sistema.
     */
    @Test
    public void testGetHijos() {
        System.out.println("getHijos");
        Sistema instance = new Sistema();
        ArrayList<Hijo> expResult = null;
        ArrayList<Hijo> result = instance.getHijos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEvento method, of class Sistema.
     */
    @Test
    public void testGetEvento() {
        System.out.println("getEvento");
        int pos = 0;
        Sistema instance = new Sistema();
        Evento expResult = null;
        Evento result = instance.getEvento(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidadEventosARealizar method, of class Sistema.
     */
    @Test
    public void testGetCantidadEventosARealizar() {
        System.out.println("getCantidadEventosARealizar");
        Sistema instance = new Sistema();
        int expResult = 0;
        int result = instance.getCantidadEventosARealizar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidadHijos method, of class Sistema.
     */
    @Test
    public void testGetCantidadHijos() {
        System.out.println("getCantidadHijos");
        Sistema instance = new Sistema();
        int expResult = 0;
        int result = instance.getCantidadHijos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidadVacunas method, of class Sistema.
     */
    @Test
    public void testGetCantidadVacunas() {
        System.out.println("getCantidadVacunas");
        Sistema instance = new Sistema();
        int expResult = 0;
        int result = instance.getCantidadVacunas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarHijo method, of class Sistema.
     */
    @Test
    public void testEliminarHijo() {
        System.out.println("eliminarHijo");
        String laCedulaId = "";
        Sistema instance = new Sistema();
        instance.eliminarHijo(laCedulaId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarHijoPorPos method, of class Sistema.
     */
    @Test
    public void testEliminarHijoPorPos() {
        System.out.println("eliminarHijoPorPos");
        int posicion = 0;
        Sistema instance = new Sistema();
        instance.eliminarHijoPorPos(posicion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarVacunasSistematicas method, of class Sistema.
     */
    @Test
    public void testCargarVacunasSistematicas() throws Exception {
        System.out.println("cargarVacunasSistematicas");
        ArchivoLectura archivoLeido = null;
        int numeroLinea = 0;
        ArrayList<Vacuna> lista = null;
        Sistema instance = new Sistema();
        String expResult = "";
        String result = instance.cargarVacunasSistematicas(archivoLeido, numeroLinea, lista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of procesarVacunaSistematica method, of class Sistema.
     */
    @Test
    public void testProcesarVacunaSistematica() {
        System.out.println("procesarVacunaSistematica");
        String nombre = "";
        String meses = "";
        String anios = "";
        String descripcion = "";
        ArrayList<Vacuna> lista = null;
        Sistema instance = new Sistema();
        instance.procesarVacunaSistematica(nombre, meses, anios, descripcion, lista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mesValido method, of class Sistema.
     */
    @Test
    public void testMesValido() {
        System.out.println("mesValido");
        String mes = "";
        Sistema instance = new Sistema();
        boolean expResult = false;
        boolean result = instance.mesValido(mes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of periodoMesValido method, of class Sistema.
     */
    @Test
    public void testPeriodoMesValido() {
        System.out.println("periodoMesValido");
        String periodo = "";
        Sistema instance = new Sistema();
        boolean expResult = false;
        boolean result = instance.periodoMesValido(periodo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of periodoAnioValido method, of class Sistema.
     */
    @Test
    public void testPeriodoAnioValido() {
        System.out.println("periodoAnioValido");
        String periodo = "";
        Sistema instance = new Sistema();
        boolean expResult = false;
        boolean result = instance.periodoAnioValido(periodo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anioValido method, of class Sistema.
     */
    @Test
    public void testAnioValido() {
        System.out.println("anioValido");
        String anio = "";
        Sistema instance = new Sistema();
        boolean expResult = false;
        boolean result = instance.anioValido(anio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarVacunasNoSistematicas method, of class Sistema.
     */
    @Test
    public void testCargarVacunasNoSistematicas() throws Exception {
        System.out.println("cargarVacunasNoSistematicas");
        ArchivoLectura archivoLeido = null;
        int numeroLinea = 0;
        ArrayList<Vacuna> lista = null;
        Sistema instance = new Sistema();
        instance.cargarVacunasNoSistematicas(archivoLeido, numeroLinea, lista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of procesarVacunaNoSistematica method, of class Sistema.
     */
    @Test
    public void testProcesarVacunaNoSistematica() {
        System.out.println("procesarVacunaNoSistematica");
        String nombre = "";
        String descripcion = "";
        ArrayList<Vacuna> lista = null;
        Sistema instance = new Sistema();
        instance.procesarVacunaNoSistematica(nombre, descripcion, lista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anioMaximoIngresable method, of class Sistema.
     */
    @Test
    public void testAnioMaximoIngresable() {
        System.out.println("anioMaximoIngresable");
        int expResult = 0;
        int result = Sistema.anioMaximoIngresable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mesMaximoIngresable method, of class Sistema.
     */
    @Test
    public void testMesMaximoIngresable() {
        System.out.println("mesMaximoIngresable");
        int expResult = 0;
        int result = Sistema.mesMaximoIngresable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarVacunasDeArchivo method, of class Sistema.
     */
    @Test
    public void testCargarVacunasDeArchivo() throws Exception {
        System.out.println("cargarVacunasDeArchivo");
        String ubicacion = "";
        Sistema instance = new Sistema();
        instance.cargarVacunasDeArchivo(ubicacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarEventoPorPos method, of class Sistema.
     */
    @Test
    public void testEliminarEventoPorPos() {
        System.out.println("eliminarEventoPorPos");
        int posEvento = 0;
        Sistema instance = new Sistema();
        instance.eliminarEventoPorPos(posEvento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of darDeBajaEvento method, of class Sistema.
     */
    @Test
    public void testDarDeBajaEvento() {
        System.out.println("darDeBajaEvento");
        int posEventoACompletar = 0;
        Sistema instance = new Sistema();
        instance.darDeBajaEvento(posEventoACompletar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nombreVacunasSistematicasParaCarne method, of class Sistema.
     */
    @Test
    public void testNombreVacunasSistematicasParaCarne() {
        System.out.println("nombreVacunasSistematicasParaCarne");
        Hijo hijoSeleccionado = null;
        Sistema instance = new Sistema();
        String[] expResult = null;
        String[] result = instance.nombreVacunasSistematicasParaCarne(hijoSeleccionado);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nombreVacunasNoSistematicasParaCarne method, of class Sistema.
     */
    @Test
    public void testNombreVacunasNoSistematicasParaCarne() {
        System.out.println("nombreVacunasNoSistematicasParaCarne");
        Hijo hijoSeleccionado = null;
        Sistema instance = new Sistema();
        String[] expResult = null;
        String[] result = instance.nombreVacunasNoSistematicasParaCarne(hijoSeleccionado);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mesesParaCarneVacunas method, of class Sistema.
     */
    @Test
    public void testMesesParaCarneVacunas() {
        System.out.println("mesesParaCarneVacunas");
        Hijo hijoSeleccionado = null;
        Sistema instance = new Sistema();
        String[] expResult = null;
        String[] result = instance.mesesParaCarneVacunas(hijoSeleccionado);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aniosParaCarneVacunas method, of class Sistema.
     */
    @Test
    public void testAniosParaCarneVacunas() {
        System.out.println("aniosParaCarneVacunas");
        Hijo hijoSeleccionado = null;
        Sistema instance = new Sistema();
        String[] expResult = null;
        String[] result = instance.aniosParaCarneVacunas(hijoSeleccionado);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVacunas method, of class Sistema.
     */
    @Test
    public void testGetVacunas() {
        System.out.println("getVacunas");
        Sistema instance = new Sistema();
        ArrayList<Vacuna> expResult = null;
        ArrayList<Vacuna> result = instance.getVacunas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventosCompletados method, of class Sistema.
     */
    @Test
    public void testGetEventosCompletados() {
        System.out.println("getEventosCompletados");
        Sistema instance = new Sistema();
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.getEventosCompletados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

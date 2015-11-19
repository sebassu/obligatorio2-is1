package auxiliar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuxiliaresTest {

    /**
     * Test of convertirArrayListStringAArrayString method, of class Auxiliares.
     */
    @Test
    public void testConvertirArrayListStringAArrayString1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(" ");
        list.add("-");
        String[] arr = Auxiliares.convertirArrayListStringAArrayString(list);
        assertTrue(list.size() == arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertTrue(list.get(i).equals(arr[i]));
        }
    }

    @Test
    public void testConvertirArrayListStringAArrayString2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("D");
        list.add("2134");
        list.add("::");
        list.add("//");
        list.add("98-7");
        String[] arr = Auxiliares.convertirArrayListStringAArrayString(list);
        assertTrue(list.size() == arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertTrue(list.get(i).equals(arr[i]));
        }
    }

    /**
     * Test of convertirArrayListStringAArrayStringConEspacioAlPrincipio method,
     * of class Auxiliares.
     */
    @Test
    public void testConvertirArrayListStringAArrayStringConEspacioAlPrincipio1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(" ");
        list.add("-");
        String[] arr = Auxiliares.convertirArrayListStringAArrayMesesConEspacioAlPrincipio(list);
        assertTrue(list.size() + 1 == arr.length);
        assertTrue(arr[0].isEmpty());
        for (int i = 1; i < arr.length; i++) {
            assertTrue(list.get(i).equals(arr[i]));
        }
    }

    @Test
    public void testConvertirArrayListStringAArrayStringConEspacioAlPrincipio2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("D");
        list.add("2134");
        list.add("::");
        list.add("//");
        list.add("98-7");
        String[] arr = Auxiliares.convertirArrayListStringAArrayMesesConEspacioAlPrincipio(list);
        assertTrue(list.size() + 1 == arr.length);
        assertTrue(arr[0].isEmpty());
        for (int i = 1; i < arr.length; i++) {
            assertTrue(list.get(i).equals(arr[i]));
        }
    }

    /**
     * Test of compararFechas method, of class Auxiliares.
     */
    @Test
    public void testCompararFechas1() {
        Calendar f1 = Calendar.getInstance();
        assertTrue(Auxiliares.compararFechas(f1, f1));
    }

    @Test
    public void testCompararFechas2() {
        Calendar f1 = Calendar.getInstance();
        Calendar f2 = Calendar.getInstance();
        assertTrue(Auxiliares.compararFechas(f1, f2));
        assertTrue(Auxiliares.compararFechas(f2, f1));
    }

    @Test
    public void testCompararFechas3() {
        Calendar f1 = Calendar.getInstance();
        Calendar f2 = Calendar.getInstance();
        f2.set(Calendar.YEAR, 1998);
        assertFalse(Auxiliares.compararFechas(f1, f2));
        assertFalse(Auxiliares.compararFechas(f2, f1));
    }

    @Test
    public void testCompararFechas4() {
        Calendar f1 = Calendar.getInstance();
        Calendar f2 = Calendar.getInstance();
        f2.set(Calendar.MONTH, 5);
        assertFalse(Auxiliares.compararFechas(f1, f2));
        assertFalse(Auxiliares.compararFechas(f2, f1));
    }

    @Test
    public void testCompararFechas5() {
        Calendar f1 = Calendar.getInstance();
        Calendar f2 = Calendar.getInstance();
        f2.set(Calendar.DAY_OF_MONTH, 1);
        assertFalse(Auxiliares.compararFechas(f1, f2));
        assertFalse(Auxiliares.compararFechas(f2, f1));
    }

    /**
     * Test of convertirArrayListStringAArrayMesesConEspacioAlPrincipio method,
     * of class Auxiliares.
     */
    @Test
    public void testConvertirArrayListStringAArrayMesesConEspacioAlPrincipio() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("a");
        lista.add("d");
        lista.add("b");
        lista.add("c");
        lista.add("2");
        lista.add("1");
        String[] esperado = {"", "1", "2", "a", "b", "c", "d"};
        assertArrayEquals(esperado, Auxiliares.convertirArrayListStringAArrayMesesConEspacioAlPrincipio(lista));
    }

    /**
     * Test of convertirArrayListStringAArrayAnios method, of class Auxiliares.
     */
    @Test
    public void testConvertirArrayListStringAArrayAnios() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("a");
        lista.add("d");
        lista.add("b");
        lista.add("c");
        lista.add("2");
        lista.add("1");
        String[] esperado = {"1", "2", "a", "b", "c", "d"};
        assertArrayEquals(esperado, Auxiliares.convertirArrayListStringAArrayMesesConEspacioAlPrincipio(lista));
    }

    /**
     * Test of getComparadorNumerosPrimeroLetrasLuego method, of class
     * Auxiliares.
     */
    @Test
    public void testGetComparadorNumerosPrimeroLetrasLuego() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("a");
        lista.add("d");
        lista.add("b");
        lista.add("c");
        lista.add("2");
        lista.add("1");
        String[] esperado = {"1", "2", "a", "b", "c", "d"};
        Collections.sort(lista, Auxiliares.getComparadorNumerosPrimeroLetrasLuego());
        assertArrayEquals(esperado, lista.toArray());
    }

    /**
     * Test of esCedulaInvalida method, of class Auxiliares.
     */
    @Test
    public void testEsCedulaInvalida1() {
        String cedula = "5.218.048-4";
        assertFalse(Auxiliares.esCedulaInvalida(cedula));
    }

    @Test
    public void testEsCedulaInvalida2() {
        String cedula = "9.999.999-9";
        assertFalse(Auxiliares.esCedulaInvalida(cedula));
    }

    @Test
    public void testEsCedulaInvalida3() {
        String cedula = "123123123";
        assertTrue(Auxiliares.esCedulaInvalida(cedula));
    }

    @Test
    public void testEsCedulaInvalida4() {
        String cedula = "abc";
        assertTrue(Auxiliares.esCedulaInvalida(cedula));
    }

    @Test
    public void testEsCedulaInvalida5() {
        String cedula = "*-*-*-*-*-";
        assertTrue(Auxiliares.esCedulaInvalida(cedula));
    }

    @Test
    public void testEsCedulaInvalida6() {
        String cedula = "";
        assertTrue(Auxiliares.esCedulaInvalida(cedula));
    }

    /**
     * Test of esNumeroNatural method, of class Auxiliares.
     */
    @Test
    public void testEsNumeroNatural1() {
        String a = "33";
        assertTrue(Auxiliares.esNumeroNatural(a));
    }

    @Test
    public void testEsNumeroNatural2() {
        String a = "0";
        assertTrue(Auxiliares.esNumeroNatural(a));
    }

    @Test
    public void testEsNumeroNatural3() {
        String a = "-3";
        assertFalse(Auxiliares.esNumeroNatural(a));
    }

    @Test
    public void testEsNumeroNatural4() {
        String a = "abc";
        assertFalse(Auxiliares.esNumeroNatural(a));
    }

    @Test
    public void testEsNumeroNatural5() {
        String a = "12abc";
        assertFalse(Auxiliares.esNumeroNatural(a));
    }

    /**
     * Test of mesesDesdeLaFecha method, of class Auxiliares.
     */
    @Test
    public void testMesesDesdeLaFecha1() {
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.MONTH, fecha.get(Calendar.MONTH) - 3);
        assertTrue(Auxiliares.mesesDesdeLaFecha(fecha) == 3);
    }

    @Test
    public void testMesesDesdeLaFecha2() {
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.MONTH, fecha.get(Calendar.MONTH) - 9);
        assertTrue(Auxiliares.mesesDesdeLaFecha(fecha) == 9);
    }

    @Test
    public void testMesesDesdeLaFecha3() {
        Calendar fecha = Calendar.getInstance();
        assertTrue(Auxiliares.mesesDesdeLaFecha(fecha) == 0);
    }

    /**
     * Test of noContieneCaracterAlfabetico method, of class Auxiliares.
     */
    @Test
    public void testNoContieneCaracterAlfabetico1() {
        String a = "AbC";
        assertFalse(Auxiliares.noContieneCaracterAlfabetico(a));
    }

    @Test
    public void testNoContieneCaracterAlfabetico2() {
        String a = "123";
        assertTrue(Auxiliares.noContieneCaracterAlfabetico(a));
    }

    @Test
    public void testNoContieneCaracterAlfabetico3() {
        String a = ".-.-.-.";
        assertTrue(Auxiliares.noContieneCaracterAlfabetico(a));
    }

    @Test
    public void testNoContieneCaracterAlfabetico4() {
        String a = "   ";
        assertTrue(Auxiliares.noContieneCaracterAlfabetico(a));
    }

    @Test
    public void testNoContieneCaracterAlfabetico5() {
        String a = "";
        assertTrue(Auxiliares.noContieneCaracterAlfabetico(a));
    }

    /**
     * Test of esFechaAntesDeNacimiento method, of class Auxiliares.
     */
    @Test
    public void testEsFechaAntesDeNacimiento1() {
        Calendar f1 = Calendar.getInstance();
        Calendar f2 = Calendar.getInstance();
        f2.set(Calendar.YEAR, 3);
        assertTrue(Auxiliares.esFechaAntesDeNacimiento(f1, f2));
    }

    @Test
    public void testEsFechaAntesDeNacimiento2() {
        Calendar f1 = Calendar.getInstance();
        Calendar f2 = Calendar.getInstance();
        f2.set(Calendar.YEAR, 1893);
        assertFalse(Auxiliares.esFechaAntesDeNacimiento(f2, f1));
    }

    /**
     * Test of esFechaFutura method, of class Auxiliares.
     */
    @Test
    public void testEsFechaFutura1() {
        Calendar f = Calendar.getInstance();
        assertFalse(Auxiliares.esFechaFutura(f));
    }

    @Test
    public void testEsFechaFutura2() {
        Calendar f = Calendar.getInstance();
        f.set(Calendar.YEAR, 19);
        assertFalse(Auxiliares.esFechaFutura(f));
    }

    @Test
    public void testEsFechaFutura3() {
        Calendar f = Calendar.getInstance();
        f.set(Calendar.YEAR, 3000);
        assertTrue(Auxiliares.esFechaFutura(f));
    }

    /**
     * Test of caeEnEstaSemana method, of class Auxiliares.
     */
    @Test
    public void testCaeEnEstaSemana1() {
        Calendar f = Calendar.getInstance();
        assertTrue(Auxiliares.caeEnEstaSemana(f));
    }

    @Test
    public void testCaeEnEstaSemana2() {
        Calendar f = Calendar.getInstance();
        f.set(Calendar.WEEK_OF_MONTH, f.get(Calendar.WEEK_OF_MONTH) + 1);
        assertFalse(Auxiliares.caeEnEstaSemana(f));
    }

    @Test
    public void testCaeEnEstaSemana3() {
        Calendar f = Calendar.getInstance();
        f.set(Calendar.MONTH, f.get(Calendar.MONTH + 3));
        assertFalse(Auxiliares.caeEnEstaSemana(f));
    }

    @Test
    public void testCaeEnEstaSemana4() {
        Calendar f = Calendar.getInstance();
        f.set(Calendar.YEAR, f.get(Calendar.YEAR + 19));
        assertFalse(Auxiliares.caeEnEstaSemana(f));
    }

    /**
     * Test of esFechaNacimientoValida method, of class Auxiliares.
     */
    @Test
    public void testEsFechaNacimientoValida1() {
        Calendar f = Calendar.getInstance();
        assertTrue(Auxiliares.esFechaNacimientoValida(f));
    }

    @Test
    public void testEsFechaNacimientoValida2() {
        Calendar f = Calendar.getInstance();
        f.set(Calendar.YEAR, f.get(Calendar.YEAR - 7));
        assertTrue(Auxiliares.esFechaNacimientoValida(f));
    }

    @Test
    public void testEsFechaNacimientoValida3() {
        Calendar f = Calendar.getInstance();
        f.set(Calendar.YEAR, f.get(Calendar.YEAR - 13));
        assertFalse(Auxiliares.esFechaNacimientoValida(f));
    }

    @Test
    public void testEsFechaNacimientoValida4() {
        Calendar f = Calendar.getInstance();
        f.set(Calendar.YEAR, f.get(Calendar.YEAR + 25));
        assertFalse(Auxiliares.esFechaNacimientoValida(f));
    }

    @Test
    public void testEsFechaNacimientoValida5() {
        Calendar f = Calendar.getInstance();
        f.set(Calendar.YEAR, 1);
        assertFalse(Auxiliares.esFechaNacimientoValida(f));
    }

    /**
     * Test of esNombreVacunaInvalido method, of class Auxiliares.
     */
    @Test
    public void testEsNombreVacunaInvalido1() {
        String a = "";
        assertTrue(Auxiliares.esNombreVacunaInvalido(a));
    }

    @Test
    public void testEsNombreVacunaInvalido2() {
        String a = ".-.--.-";
        assertTrue(Auxiliares.esNombreVacunaInvalido(a));
    }

    @Test
    public void testEsNombreVacunaInvalido3() {
        String a = "123";
        assertFalse(Auxiliares.esNombreVacunaInvalido(a));
    }

    @Test
    public void testEsNombreVacunaInvalido4() {
        String a = "123-7";
        assertFalse(Auxiliares.esNombreVacunaInvalido(a));
    }

    @Test
    public void testEsNombreVacunaInvalido5() {
        String a = "ABC-123";
        assertFalse(Auxiliares.esNombreVacunaInvalido(a));
    }

    @Test
    public void testEsNombreVacunaInvalido6() {
        String a = "VCG";
        assertFalse(Auxiliares.esNombreVacunaInvalido(a));
    }
}

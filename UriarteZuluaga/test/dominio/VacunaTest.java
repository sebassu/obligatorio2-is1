package dominio;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class VacunaTest {

    private final String nom;

    public VacunaTest(String unNombre) {
        nom = unNombre;
    }

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"12345"}, {""}, {"-2-2--"},
        {"!&%&$="}, {"::"}};
        return Arrays.asList(data);
    }

    @Test
    public void testSetNombreOK1() {
        Vacuna v = new Vacuna();
        v.setNombre("HPV");
        assertEquals(v.getNombre(), "HPV");
    }

    @Test
    public void testSetNombreOK2() {
        Vacuna v = new Vacuna();
        v.setNombre("Triple Bacteriana 55");
        assertEquals(v.getNombre(), "Triple Bacteriana 55");
    }

    @Test
    public void testSetNombreOK3() {
        Vacuna v = new Vacuna();
        v.setNombre("CPV1321 A3");
        assertEquals(v.getNombre(), "CPV1321 A3");
    }

    @Test
    public void testSetNombreError() {
        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("Nombre inválido");
        Vacuna v = new Vacuna();
        v.setNombre(nom);
    }

    @Test
    public void testConstructorOK1() {
        Vacuna v = new Vacuna("HPV", false, 0, 0, 0);
        assertEquals(v.getNombre(), "HPV");
    }

    @Test
    public void testConstructorOK2() {
        Vacuna v = new Vacuna("Triple Bacteriana 55", true, 0, 0, 0);
        assertEquals(v.getNombre(), "Triple Bacteriana 55");
    }

    @Test
    public void testConstructorOK3() {
        Vacuna v = new Vacuna("CPV1321 A3", false, 0, 0, 0);
        assertEquals(v.getNombre(), "CPV1321 A3");
    }

    @Test
    public void testConstructorError() {
        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("Nombre inválido");
        Vacuna v = new Vacuna(nom, false, 0, 0, 0);
    }

    @Test
    public void testEquals1() {
        Vacuna v = new Vacuna("HPV", false, 0, 0, 0);
        assertTrue(v.equals(v));
    }

    @Test
    public void testEquals2() {
        Vacuna v1 = new Vacuna("BCG", false, 0, 0, 0);
        Vacuna v2 = new Vacuna("BCG", false, 0, 0, 0);
        assertTrue(v1.equals(v2));
    }

    @Test
    public void testEquals3() {
        Vacuna v1 = new Vacuna("ABC", false, 0, 0, 0);
        Vacuna v2 = new Vacuna("H1N1", false, 0, 0, 0);
        assertFalse(v1.equals(v2));
    }
}

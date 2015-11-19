package auxiliar;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParTest {

    /**
     * Test of setDato1 method, of class Par.
     */
    @Test
    public void testSetDato11() {
        Par<String, String> p = new Par<>("A", "B");
        p.setDato1("C");
        assertEquals(p.getDato1(), "C");
    }

    @Test
    public void testSetDato12() {
        String aux = "Lorem ipsum";
        Par<String, String> p = new Par<>("A", "B");
        p.setDato1(aux);
        assertEquals(p.getDato1(), aux);
    }

    /**
     * Test of setDato2 method, of class Par.
     */
    @Test
    public void testSetDato21() {
        Par<String, String> p = new Par<>("A", "B");
        p.setDato1("C");
        assertEquals(p.getDato1(), "C");
    }

    @Test
    public void testSetDato22() {
        String aux = "Lorem ipsum";
        Par<String, String> p = new Par<>("A", "B");
        p.setDato1(aux);
        assertEquals(p.getDato1(), aux);
    }

    /**
     * Test of equals method, of class Par.
     */
    @Test
    public void testEquals1() {
        Par<String, String> p = new Par<>("A", "B");
        assertTrue(p.equals(p));
    }

    @Test
    public void testEquals2() {
        Par<String, String> p = new Par<>("A", "B");
        Par<String, String> j = new Par<>("A", "B");
        assertTrue(p.equals(j));
        assertTrue(j.equals(p));
    }

    @Test
    public void testEquals3() {
        Par<String, String> p = new Par<>("C", "B");
        Par<String, String> j = new Par<>("A", "B");
        assertFalse(p.equals(j));
        assertFalse(j.equals(p));
    }

    @Test
    public void testEquals4() {
        Par<String, String> p = new Par<>("A", "B");
        Par<String, String> j = new Par<>("A", "C");
        assertFalse(p.equals(j));
        assertFalse(j.equals(p));
    }
}

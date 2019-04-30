import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class MapTest {

    @org.junit.Test
    public void convert() {
        Map m = new Map("TestMap");
        int i = m.convert('a');
        assertEquals(0, i);
        i = m.convert('%');
        assertEquals(-1, i);

    }

    @org.junit.Test
    public void check() {
        Map m = new Map("Test");
        Map.Point p = new Map.Point(0, 1);
        Map.Point p1 = m.check(p, '0');
        assertEquals(p, p1);
    }

    @org.junit.Test
    public void checkImmersed() {
    }

    @org.junit.Test
    public void ifEqual() {
        Map m = new Map("Test");
        Map.Point p1 = new Map.Point(3, 4);
        Map.Point p2 = new Map.Point(3, 4);
        assertTrue(m.ifEqual(p1, p2));
    }

    @org.junit.Test
    public void checkship() {
        Map m = new Map("Test");
        Ship s = new Ship(5);
        Map.Point p = new Map.Point(4, 0);
        assertTrue(m.checkship(p, s.nSize, 'v'));
    }

    @org.junit.Test
    public void addship() {
        Map m = new Map("Test");
        Ship s = new Ship(5);
        char[] opt = {'a', '4', 'v'};
        assertTrue(m.addship(s, opt));
    }

    @org.junit.Test
    public void shootint() {
        Map m = new Map("Test");
        assertFalse(m.shootint(4, 5));
    }

    @org.junit.Test
    public void shootchar() {
        Map m = new Map("Test");
        char[] opt = {'a', '4'};
        assertFalse(m.shootchar(opt));
    }

    @org.junit.Test
    public void autoshoot() {
        Map m = new Map("Test");
        assertFalse(m.autoshoot());
    }
}
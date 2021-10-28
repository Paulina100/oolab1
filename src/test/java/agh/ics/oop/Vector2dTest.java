package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void equalsTest(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(1, -3);
        Vector2d v4 = new Vector2d(5, 2);

        assertEquals(v1, v2);
        assertEquals(v2, v1);

        assertNotEquals(v1, v3);
        assertNotEquals(v2, v3);
        assertNotEquals(v2, v4);
        assertNotEquals("kot", v1);
        assertNotEquals(10, v1);
    }

    @Test
    public void toStringTest(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(1, -3);
        Vector2d v4 = new Vector2d(5, 2);

        assertEquals(v1.toString(), "(1, 2)");
        assertEquals(v2.toString(), "(1, 2)");
        assertEquals(v3.toString(), "(1, -3)");
        assertEquals(v4.toString(), "(5, 2)");
    }

    @Test
    public void precedesTest(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(1, -3);
        Vector2d v4 = new Vector2d(5, 2);

        assertTrue(v1.precedes(v2));
        assertTrue(v2.precedes(v1));
        assertTrue(v1.precedes(v4));
        assertTrue(v3.precedes(v2));
        assertTrue(v3.precedes(v4));

        assertFalse(v4.precedes(v1));
        assertFalse(v4.precedes(v1));
        assertFalse(v2.precedes(v3));
    }

    @Test
    public void nextTest(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(1, -3);
        Vector2d v4 = new Vector2d(5, 2);

        assertTrue(v1.follows(v2));
        assertTrue(v2.follows(v1));
        assertTrue(v4.follows(v1));
        assertTrue(v2.follows(v3));

        assertFalse(v3.follows(v2));
        assertFalse(v3.follows(v4));
        assertFalse(v1.follows(v4));
    }

    @Test
    public void upperrightTest(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(1, -3);
        Vector2d v4 = new Vector2d(5, 2);
        Vector2d v5 = new Vector2d(-3, -2);
        Vector2d v6 = new Vector2d(5, 10);

        assertEquals(v1.upperRight(v1), v1);
        assertEquals(v1.upperRight(v2), new Vector2d(1, 2));
        assertEquals(v1.upperRight(v3), new Vector2d(1, 2));
        assertEquals(v3.upperRight(v1), new Vector2d(1, 2));
        assertEquals(v1.upperRight(v4), new Vector2d(5, 2));
        assertEquals(v1.upperRight(v5), new Vector2d(1, 2));
        assertEquals(v1.upperRight(v6), new Vector2d(5, 10));
    }

    @Test
    public void lowerLeftTest(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(1, -3);
        Vector2d v4 = new Vector2d(5, 2);
        Vector2d v5 = new Vector2d(-3, -2);
        Vector2d v6 = new Vector2d(5, 10);

        assertEquals(v1.lowerLeft(v1), v1);
        assertEquals(v1.lowerLeft(v2), new Vector2d(1, 2));
        assertEquals(v1.lowerLeft(v3), new Vector2d(1, -3));
        assertEquals(v3.lowerLeft(v1), new Vector2d(1, -3));
        assertEquals(v1.lowerLeft(v4), new Vector2d(1, 2));
        assertEquals(v1.lowerLeft(v5), new Vector2d(-3, -2));
        assertEquals(v1.lowerLeft(v6), new Vector2d(1, 2));
    }

    @Test
    public void addTets(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(1, -3);
        Vector2d v4 = new Vector2d(5, 2);
        Vector2d v5 = new Vector2d(-3, -2);
        Vector2d v6 = new Vector2d(5, 10);

        assertEquals(v1.add(v1), new Vector2d(2, 4));
        assertEquals(v1.add(v2), new Vector2d(2, 4));
        assertEquals(v1.add(v3), new Vector2d(2, -1));
        assertEquals(v1.add(v4), new Vector2d(6, 4));
        assertEquals(v1.add(v5), new Vector2d(-2, 0));
        assertEquals(v1.add(v6), new Vector2d(6, 12));
    }

    @Test
    public void subtrackTest(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = new Vector2d(1, -3);
        Vector2d v4 = new Vector2d(5, 2);
        Vector2d v5 = new Vector2d(-3, -2);
        Vector2d v6 = new Vector2d(5, 10);

        assertEquals(v1.subtract(v1), new Vector2d(0, 0));
        assertEquals(v1.subtract(v2), new Vector2d(0, 0));
        assertEquals(v1.subtract(v3), new Vector2d(0, 5));
        assertEquals(v1.subtract(v4), new Vector2d(-4, 0));
        assertEquals(v1.subtract(v5), new Vector2d(4, 4));
        assertEquals(v1.subtract(v6), new Vector2d(-4, -8));
    }

    @Test
    public void oppositeTest(){
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(0, 0);
        Vector2d v3 = new Vector2d(1, -3);
        Vector2d v4 = new Vector2d(-5, 2);
        Vector2d v5 = new Vector2d(-3, -2);
        Vector2d v6 = new Vector2d(5, 10);
        Vector2d v7 = new Vector2d(0, 10);
        Vector2d v8 = new Vector2d(5, 0);

        assertEquals(v1.opposite(), new Vector2d(-1, -2));
        assertEquals(v2.opposite(), new Vector2d(0, 0));
        assertEquals(v3.opposite(), new Vector2d(-1, 3));
        assertEquals(v4.opposite(), new Vector2d(5, -2));
        assertEquals(v5.opposite(), new Vector2d(3, 2));
        assertEquals(v6.opposite(), new Vector2d(-5, -10));
        assertEquals(v7.opposite(), new Vector2d(0, -10));
        assertEquals(v8.opposite(), new Vector2d(-5, 0));
    }
}

package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AnimalTest {
    Animal cat = new Animal();


    @Test
    public void toStringTest(){
        assertEquals(cat.toString(), "^");
        assertNotEquals(cat.toString(), ">");
        cat.move(MoveDirection.RIGHT);
        assertEquals(cat.toString(), ">");
    }

    @Test
    public void isAtTest(){
        assertTrue(cat.isAt(new Vector2d(2, 2)));
        assertFalse(cat.isAt(new Vector2d(2, 3)));

        cat.move(MoveDirection.FORWARD);
        assertTrue(cat.isAt(new Vector2d(2, 3)));
        assertFalse(cat.isAt(new Vector2d(2, 2)));

        cat.move(MoveDirection.RIGHT);
        assertTrue(cat.isAt(new Vector2d(2, 3)));
        assertFalse(cat.isAt(new Vector2d(2, 2)));

    }


    @Test
    public void moveTest(){
        assertEquals(cat.getPosition(),  new Vector2d(2, 2));
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.getPosition(), new Vector2d(2, 3));
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.getPosition(), new Vector2d(2, 4));
        cat.move(MoveDirection.RIGHT);
        assertEquals(cat.toString(), ">");
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.getPosition(), new Vector2d(3, 4));
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.getPosition(), new Vector2d(4, 4));
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.getPosition(), new Vector2d(4, 4));
        cat.move(MoveDirection.LEFT);
        assertEquals(cat.toString(), "^");
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.getPosition(), new Vector2d(4, 4));
        cat.move(MoveDirection.LEFT);
        assertEquals(cat.toString(), "<");
        cat.move(MoveDirection.LEFT);
        assertEquals(cat.toString(), "v");
        cat.move(MoveDirection.LEFT);
        assertEquals(cat.toString(), ">");
        cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.getPosition(), new Vector2d(3, 4));
        cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.getPosition(), new Vector2d(2, 4));
        cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.getPosition(), new Vector2d(1, 4));
        cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.getPosition(), new Vector2d(0, 4));
        cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.getPosition(), new Vector2d(0, 4));
    }
}

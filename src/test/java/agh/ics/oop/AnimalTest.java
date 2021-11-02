package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AnimalTest {
    Animal cat = new Animal();
    Animal dog = new Animal();
    Animal elephant = new Animal();
    Animal python = new Animal();

    @Test
    public void toStringTest(){
        assertEquals(cat.toString(), "Północ, (2, 2)");
        assertNotEquals(cat.toString(), "Ponoc, (2, 2)");
        assertNotEquals(cat.toString(), "Północ, (2, 3)");
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
    public void boundaryCheckTest(){
        cat.move(MoveDirection.FORWARD);
        cat.move(MoveDirection.FORWARD);
        cat.move(MoveDirection.FORWARD);
        cat.move(MoveDirection.FORWARD);
        cat.move(MoveDirection.FORWARD);
        assertTrue(cat.isAt(new Vector2d(2, 4)));

        dog.move(MoveDirection.BACKWARD);
        dog.move(MoveDirection.BACKWARD);
        dog.move(MoveDirection.BACKWARD);
        dog.move(MoveDirection.BACKWARD);
        dog.move(MoveDirection.BACKWARD);
        assertTrue(dog.isAt(new Vector2d(2, 0)));

        elephant.move(MoveDirection.LEFT);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        assertTrue(elephant.isAt(new Vector2d(0, 2)));

        python.move(MoveDirection.RIGHT);
        python.move(MoveDirection.FORWARD);
        python.move(MoveDirection.FORWARD);
        python.move(MoveDirection.FORWARD);
        python.move(MoveDirection.FORWARD);
        python.move(MoveDirection.FORWARD);
        assertTrue(python.isAt(new Vector2d(4, 2)));
    }

    @Test
    public void moveTest(){
        assertEquals(cat.toString(), "Północ, (2, 2)");
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.toString(), "Północ, (2, 3)");
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.toString(), "Północ, (2, 4)");
        cat.move(MoveDirection.RIGHT);
        assertEquals(cat.toString(), "Wschód, (2, 4)");
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.toString(), "Wschód, (3, 4)");
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.toString(), "Wschód, (4, 4)");
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.toString(), "Wschód, (4, 4)");
        cat.move(MoveDirection.LEFT);
        assertEquals(cat.toString(), "Północ, (4, 4)");
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.toString(), "Północ, (4, 4)");
        cat.move(MoveDirection.LEFT);
        assertEquals(cat.toString(), "Zachód, (4, 4)");
        cat.move(MoveDirection.LEFT);
        assertEquals(cat.toString(), "Południe, (4, 4)");
        cat.move(MoveDirection.LEFT);
        assertEquals(cat.toString(), "Wschód, (4, 4)");
        cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.toString(), "Wschód, (3, 4)");
        cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.toString(), "Wschód, (2, 4)");
        cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.toString(), "Wschód, (1, 4)");
        cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.toString(), "Wschód, (0, 4)");
        cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.toString(), "Wschód, (0, 4)");
    }
}

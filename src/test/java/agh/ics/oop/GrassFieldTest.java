package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GrassFieldTest {
    AbstractWorldMap map = new GrassField(10);

    Vector2d posCat = new Vector2d(2,2);
    Vector2d posDog = new Vector2d(3,4);


    Vector2d posRand1 = new Vector2d(-3, -2);
    Vector2d posRand2 = new Vector2d(20, 4);
    Vector2d posRand3 = new Vector2d(5, 5);

    Animal cat = new Animal(map, posCat);
    Animal dog = new Animal(map, posDog);
    boolean x = map.place(cat);
    boolean y = map.place(dog);

    @Test
    public void placeAnimal(){
        assertTrue(x);
        assertTrue(y);
        assertFalse(map.place(new Animal(map, posCat)));
        assertFalse(map.place(new Animal(map, posDog)));
    }

    @Test
    public void canMoveToTest(){

        assertFalse(map.canMoveTo(posCat));
        assertFalse(map.canMoveTo(posDog));

        assertTrue(map.canMoveTo(posRand1));
        assertTrue(map.canMoveTo(posRand2));
        assertTrue(map.canMoveTo(posRand3));
    }

    @Test
    public void isOccupiedTest(){
        assertTrue(map.isOccupied(posCat));
        assertTrue(map.isOccupied(posDog));

        assertFalse(map.isOccupied(posRand1));
        assertFalse(map.isOccupied(posRand2));
    }

    @Test
    public void objectAtTest(){
        assertEquals(cat, map.objectAt(posCat));
        assertEquals(dog, map.objectAt(posDog));

        assertNotEquals(cat, map.objectAt(posDog));
        assertNotEquals(dog, map.objectAt(posCat));
    }

}

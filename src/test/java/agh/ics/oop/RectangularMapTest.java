package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RectangularMapTest {
    AbstractWorldMap map = new RectangularMap(5, 5);

    Vector2d posCat = new Vector2d(2,2);
    Vector2d posDog = new Vector2d(3,4);


    Vector2d outsideMap1 = new Vector2d(6,2);
    Vector2d outsideMap2 = new Vector2d(3,-1);

    Vector2d onMap1 = new Vector2d(3, 3);
    Vector2d onMap2 = new Vector2d(0, 5);

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

        assertFalse(map.place(new Animal(map, outsideMap1)));
        assertFalse(map.place(new Animal(map, outsideMap2)));

    }

    @Test
    public void canMoveToTest(){

        assertFalse(map.canMoveTo(posCat));
        assertFalse(map.canMoveTo(posDog));
        assertFalse(map.canMoveTo(outsideMap1));
        assertFalse(map.canMoveTo(outsideMap2));

        assertTrue(map.canMoveTo(onMap1));
        assertTrue(map.canMoveTo(onMap2));
    }

    @Test
    public void isOccupiedTest(){
        assertTrue(map.isOccupied(posCat));
        assertTrue(map.isOccupied(posDog));
        assertFalse(map.isOccupied(outsideMap1));
        assertFalse(map.isOccupied(outsideMap2));

        assertFalse(map.isOccupied(onMap1));
        assertFalse(map.isOccupied(onMap2));
    }

    @Test
    public void objectAtTest(){
        assertEquals(cat, map.objectAt(posCat));
        assertEquals(dog, map.objectAt(posDog));

        assertNotEquals(cat, map.objectAt(posDog));
        assertNotEquals(dog, map.objectAt(posCat));
    }

}

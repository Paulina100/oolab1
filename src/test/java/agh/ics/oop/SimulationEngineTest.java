package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationEngineTest {
    @Test
    public void runTest(){
        IWorldMap map = new RectangularMap(10, 5);

        Vector2d posCat1 = new Vector2d(2,2);
        Vector2d posDog1 = new Vector2d(3,4);
        Vector2d[] positions = { posCat1, posDog1 };
        String[] tab = {"f", "b", "r", "l", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IEngine enegine = new SimulationEngine(directions, map, positions);
        List<Animal> animals = map.getAnimals();
        Animal cat = animals.get(0);
        Animal dog = animals.get(1);

        assertEquals(map.objectAt(posCat1), cat);
        assertEquals(map.objectAt(posDog1), dog);
        enegine.run();

        Vector2d posCat2 = new Vector2d(2, 3);
        Vector2d posDog2 = new Vector2d(3, 3);
        assertEquals(map.objectAt(posCat2), cat);
        assertEquals(map.objectAt(posDog2), dog);

        Vector2d posDuck1 = new Vector2d(0,0);
        Vector2d posOwl1 = new Vector2d(3,3);
        Vector2d[] positions2 = { posDuck1, posOwl1 };
        String[] tab2 = {"l", "r", "l", "f", "f", "f", "f"};
        MoveDirection[] directions2 = new OptionsParser().parse(tab2);
        IEngine enegine2 = new SimulationEngine(directions2, map, positions2);
        animals = map.getAnimals();
        Animal duck = animals.get(2);

        assertEquals(map.objectAt(posDuck1), duck);
        assertNotEquals(map.objectAt(posDuck1), dog);
        enegine2.run();

        Vector2d posCat3 = new Vector2d(2, 5);
        Vector2d posDog3 = new Vector2d(3, 4);
        System.out.println(cat.getPosition());
        assertEquals(map.objectAt(posCat3), cat);
        assertEquals(map.objectAt(posDog3), dog);
        assertEquals(map.objectAt(posDuck1), duck);
    }
}

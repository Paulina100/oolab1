package agh.ics.oop;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    private final AbstractWorldMap map;
    List<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map, Vector2d[] initialPositions){
        this.directions = directions;
        this.map = map;
        initializeMap(initialPositions);
    }


    private void initializeMap(Vector2d[] initialPositions){
        for (Vector2d position : initialPositions){
            Animal animal = new Animal(map, position);
            if (map.place(animal)) animals.add(animal);
        }
    }


    public void run(){
        out.println(map.toString());
        int i = 0;
        while (i < directions.length) {
            for (Animal animal : animals) {
                animal.move(directions[i]);

                out.println(directions[i].toString());
                out.println(map);
                i++;
                if (i >= directions.length) break;
            }
        }
    }
}

package agh.ics.oop;

// import static java.lang.System.out;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final List<Animal> animals;


    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialPositions){
        this.directions = directions;
        this.map = map;
        this.animals = map.getAnimals();
        initializeMap(initialPositions);
    }


    private void initializeMap(Vector2d[] initialPositions){
        for (Vector2d position : initialPositions){
            Animal animal = new Animal(map, position);
            map.place(animal);
        }
    }

    public void run(){
        // out.println(map.toString());
        int l = directions.length;
        int i = 0;
        while (i < l) {
            for (Animal animal : animals) {
                animal.move(directions[i]);

                /*out.println(directions[i].toString());
                out.println(map);*/
                i++;
                if (i >= l) break;
            }
        }
    }
}

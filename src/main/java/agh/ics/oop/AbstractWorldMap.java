package agh.ics.oop;


import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();

        if (objectAt(position) instanceof Animal) {
            throw new IllegalArgumentException(animal.getPosition() + " is already occupied");
        }

        animals.put(position, animal);
        animal.addObserver(this);
        return true;
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }


    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }


    public abstract Vector2d[] findBoundaries();


    public String toString(){
        MapVisualizer mapvis = new MapVisualizer(this);

        Vector2d[] boundaries = findBoundaries();
        return mapvis.draw(boundaries[0], boundaries[1]);
    }

}

package agh.ics.oop;


import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();

        if (objectAt(position) instanceof Animal) return false;

        animals.put(position, animal);
        return true;
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    protected abstract Vector2d[] find_boundaries();

    public String toString(){
        MapVisualizer mapvis = new MapVisualizer(this);

        Vector2d[] boundaries = find_boundaries();
        return mapvis.draw(boundaries[0], boundaries[1]);
    }


    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }

}

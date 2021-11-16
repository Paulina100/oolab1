package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();
    protected Vector2d[] boundaries = new Vector2d[2];

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals){
            if (animal.isAt(position)) return animal;
        }
        return null;
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();

        if (objectAt(position) instanceof Animal) return false;

        animals.add(animal);
        return true;
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    public String toString(){
        MapVisualizer mapvis = new MapVisualizer(this);

        return mapvis.draw(boundaries[0], boundaries[1]);
    }
}

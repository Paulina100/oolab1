package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    public final int width;
    public final int height;

    List<Animal> animals = new ArrayList<>();


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }


    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals){
            if (animal.isAt(position)) return animal;
        }
        return null;
    }


    @Override
    public boolean isOccupied(Vector2d position) {

        for (Animal animal : animals) {
            if (animal.isAt(position)) return true;
        }
        return false;
    }


    @Override
    public boolean place(Animal animal) {

        Vector2d position = animal.getPosition();

        if (isOccupied(position)) return false;

        animals.add(animal);
        return true;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d boundary_start = new Vector2d(0, 0);
        Vector2d boundary_end = new Vector2d(width, height);
        if (position.follows(boundary_start) && position.precedes(boundary_end)){
            return !isOccupied(position);
        }
        return false;
    }


    public String toString(){
        MapVisualizer mapvis = new MapVisualizer(this);
        Vector2d boundary_start = new Vector2d(0, 0);
        Vector2d boundary_end = new Vector2d(width, height);

        return mapvis.draw(boundary_start, boundary_end);
    }
}

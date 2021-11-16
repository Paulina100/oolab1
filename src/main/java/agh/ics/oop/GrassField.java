package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private final int grassAmount;
    private final List<Grass> grassList = new ArrayList<>();

    public GrassField(int grassAmount){
        this.grassAmount = grassAmount;
        this.initiate_map();
    }

    private int getRandomNumber() {
        return (int) (Math.random() * sqrt(this.grassAmount * 10));
    }

    private void initiate_map(){
        int i = 0;
        while (i < this.grassAmount){
            Vector2d position = new Vector2d(getRandomNumber(), getRandomNumber());

            if (! isOccupied(position)){
                this.grassList.add(new Grass(position));
                i += 1;
            }

        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null) return object;

        for (Grass grass : grassList){
            if (grass.getPosition().equals(position)) return grass;
        }

        return null;
    }

    public String toString(){
        MapVisualizer mapvis = new MapVisualizer(this);

        find_boundaries();
        return mapvis.draw(boundaries[0], boundaries[1]);
    }

    private void find_boundaries(){

        for (Animal animal : animals){
            boundaries[0] = boundaries[0].lowerLeft(animal.getPosition());
            boundaries[1] = boundaries[1].upperRight(animal.getPosition());
        }
        for (Grass grass : grassList){
            boundaries[0] = boundaries[0].lowerLeft(grass.getPosition());
            boundaries[1] = boundaries[1].upperRight(grass.getPosition());
        }

    }
}

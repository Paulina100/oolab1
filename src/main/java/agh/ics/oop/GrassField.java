package agh.ics.oop;


import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private final int grassAmount;
    protected Map<Vector2d, Grass> grassMap = new HashMap<>();
    private final MapBoundary boundary;

    public GrassField(int grassAmount){
        this.grassAmount = grassAmount;
        this.boundary = new MapBoundary(this);
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
                this.grassMap.put(position, new Grass(position));
                boundary.addPosition(position);
                i += 1;
            }
        }
    }

    @Override
    public boolean place(Animal animal) {
        super.place(animal);
        boundary.addPosition(animal.getPosition());
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null) return object;

        return grassMap.get(position);
    }


    protected Vector2d[] findBoundaries(){
        Vector2d[] boundaries = {(Vector2d) animals.keySet().toArray()[0],(Vector2d) animals.keySet().toArray()[0]};

        for (Vector2d pos : animals.keySet()){
            boundaries[0] = boundaries[0].lowerLeft(pos);
            boundaries[1] = boundaries[1].upperRight(pos);
        }
        for (Vector2d pos : grassMap.keySet()){
            boundaries[0] = boundaries[0].lowerLeft(pos);
            boundaries[1] = boundaries[1].upperRight(pos);
        }

        return boundaries;
    }
}

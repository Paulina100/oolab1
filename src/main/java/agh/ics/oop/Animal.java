package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private final IWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();


    public Animal(){
        this.map = new RectangularMap(4, 4);
        addObserver((IPositionChangeObserver) map);
    }


    public Animal (AbstractWorldMap map){
        this.map = map;
        addObserver(map);
    }


    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        addObserver(map);
    }

    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String toString(){
        return switch (this.orientation){
            case NORTH -> "^";
            case EAST -> ">";
            case WEST -> "<";
            case SOUTH -> "v";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }


    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (map.canMoveTo(newPosition)) {
                    positionChanged(position, newPosition);
                    this.position = newPosition;
                    }
                }
            case BACKWARD -> {
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector().opposite());
                if (map.canMoveTo(newPosition)) {
                    positionChanged(position, newPosition);
                    this.position = newPosition;
                    }
                }
            }
        }
    }


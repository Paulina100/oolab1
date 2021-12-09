package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;
    private final IWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();


    public Animal (IWorldMap map){
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
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
                    Vector2d oldPosition = this.position;
                    this.position = newPosition;
                    positionChanged(oldPosition, newPosition);
                    }
                }
            case BACKWARD -> {
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector().opposite());
                if (map.canMoveTo(newPosition)) {
                    Vector2d oldPosition = this.position;
                    this.position = newPosition;
                    positionChanged(oldPosition, newPosition);
                    }
                }
            }
        }
    }


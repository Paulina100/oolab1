package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    /*private final Vector2d boundary_start = new Vector2d(0, 0);
    private final Vector2d boundary_end = new Vector2d(4, 4);*/
    private final IWorldMap map;

    public Animal(){
        this.map = new RectangularMap(0, 4);
    }
    public Animal (IWorldMap map){
        this.map = map;
    }


    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
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
/*
    private void boundaryCheck(Vector2d position){
        if (position.follows(boundary_start) && position.precedes(boundary_end)){
            this.position = position;
        }
    }*/

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d new_position = this.position.add(this.orientation.toUnitVector());
                if (map.canMoveTo(new_position)) this.position = new_position;
                }
            case BACKWARD -> {
                Vector2d new_position = this.position.add(this.orientation.toUnitVector().opposite());
                if (map.canMoveTo(new_position)) this.position = new_position;
                }
            }
        }

    }


package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private final Vector2d boundary_start = new Vector2d(0, 0);
    private final Vector2d boundary_end = new Vector2d(4, 4);


    public String toString(){
        return this.orientation + ", " + this.position;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    private void boundaryCheck(Vector2d position){
        if (position.follows(boundary_start) && position.precedes(boundary_end)){
            this.position = position;
        }
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d new_position = this.position.add(this.orientation.toUnitVector());
                boundaryCheck(new_position);
                }
            case BACKWARD -> {
                Vector2d new_position = this.position.add(this.orientation.toUnitVector().opposite());
                boundaryCheck(new_position);
                }
            }
        }

    }


package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    private final static Vector2d boundaryStart = new Vector2d(0, 0);
    private final Vector2d boundaryEnd;

    public RectangularMap(int width, int height){

        this.boundaryEnd = new Vector2d(width, height);
    }

    private boolean isOnMap(Vector2d position){
        return position.follows(boundaryStart) && position.precedes(boundaryEnd);
    }


    @Override
    public boolean place(Animal animal) {
        if (!isOnMap(animal.getPosition())) {
            throw new IllegalArgumentException(animal.getPosition() + " is not on map");
        }

        return super.place(animal);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!isOnMap(position)) return false;

        return super.canMoveTo(position);
    }

    @Override
    protected Vector2d[] findBoundaries() {
        return new Vector2d[]{boundaryStart, boundaryEnd};
    }


}

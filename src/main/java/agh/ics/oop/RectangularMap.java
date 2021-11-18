package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    private final static Vector2d boundary_start = new Vector2d(0, 0);
    private final Vector2d boundary_end;

    public RectangularMap(int width, int height){

        this.boundary_end = new Vector2d(width, height);
    }

    private boolean isOnMap(Vector2d position){
        return position.follows(boundary_start) && position.precedes(boundary_end);
    }


    @Override
    public boolean place(Animal animal) {
        if (!isOnMap(animal.getPosition())) return false;

        return super.place(animal);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!isOnMap(position)) return false;

        return super.canMoveTo(position);
    }

    @Override
    protected Vector2d[] find_boundaries() {
        return new Vector2d[]{boundary_start, boundary_end};
    }


}

package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height){
        this.boundaries[0] = new Vector2d(0, 0);
        this.boundaries[1] = new Vector2d(width, height);
    }

    private boolean isOnMap(Vector2d position){
        return position.follows(this.boundaries[0]) && position.precedes(this.boundaries[1]);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (!isOnMap(position)) return null;

        return super.objectAt(position);
    }

    @Override
    public boolean isOccupied(Vector2d position){
        if (!isOnMap(position)) return true;
        return super.isOccupied(position);
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

    public String toString(){
        MapVisualizer mapvis = new MapVisualizer(this);

        return mapvis.draw(boundaries[0], boundaries[1]);
    }
}

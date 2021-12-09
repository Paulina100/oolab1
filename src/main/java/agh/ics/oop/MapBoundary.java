package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    public SortedSet <Vector2d> xSortedObjects = new TreeSet<>((position1, position2) -> {
        if(position1.y>position2.y){return 1;}
        else if(position1.y < position2.y) {return -1;}
        return position1.x-position2.x;
    });
    public SortedSet <Vector2d> ySortedObjects =  new TreeSet<>((position1, position2) -> {
        if(position1.y>position2.y){return 1;}
        else if(position1.y < position2.y) {return -1;}
        return position1.x-position2.x;
    });
    private final IWorldMap map;

    public MapBoundary(IWorldMap map){
        this.map = map;
    }


    public void addPosition (Vector2d position){
        xSortedObjects.add(position);
        ySortedObjects.add(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (!map.isOccupied(oldPosition)){
            xSortedObjects.remove(oldPosition);
            ySortedObjects.remove(oldPosition);
        }

        addPosition(newPosition);
    }

    public Vector2d getLowerLeft(){
        int x = this.xSortedObjects.first().x;
        int y = this.ySortedObjects.first().y;
        return new Vector2d(x, y);
    }


    public Vector2d getUpperRight(){
        int x = this.xSortedObjects.last().x;
        int y = this.ySortedObjects.last().y;
        return new Vector2d(x, y);
    }

}

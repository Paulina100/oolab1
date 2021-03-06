package agh.ics.oop;

public enum MapDirection{
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(){
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
    }

    public MapDirection next(){
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public MapDirection previous(){
        return switch (this) {
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case NORTH -> WEST;
        };
    }

    public Vector2d toUnitVector(){
        return switch (this) {
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            case NORTH -> new Vector2d(0, 1);
        };
    }
}
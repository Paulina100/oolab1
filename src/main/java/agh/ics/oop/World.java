package agh.ics.oop;
import static java.lang.System.out;


public class World {
    public static class Vector2d{
        public final int x;
        public final int y;

        public Vector2d(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "(" + this.x + ", " + this.y + ")";
        }

        public boolean precedes(Vector2d other){
            return this.x <= other.x && this.y <= other.y;
        }

        public boolean follows(Vector2d other){
            return this.x >= other.x && this.y >= other.y;
        }

        public Vector2d upperRight(Vector2d other){
            int a = Math.max(this.x, other.x);
            int b = Math.max(this.y, other.y);

            return new Vector2d(a, b);
        }

        public Vector2d lowerLeft(Vector2d other){
            int a = Math.min(this.x, other.x);
            int b = Math.min(this.y, other.y);

            return new Vector2d(a, b);
        }

        public Vector2d add(Vector2d other){
            return new Vector2d(this.x + other.x, this.y + other.y);
        }

        public Vector2d subtract(Vector2d other){
            return new Vector2d(this.x - other.x, this.y - other.y);
        }

        public boolean equals(Object other){
            if (this == other)
                return true;
            if (!(other instanceof Vector2d))
                return false;
            Vector2d that = (Vector2d) other;

            return this.x == that.x && this.y == that.y;
        }

        public Vector2d opposite(){
            return new Vector2d(-this.x, -this.y);
        }
    }

    enum MoveDirection{
        FORWARD,
        BACKWARD,
        RIGHT,
        LEFT
    }

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

    public static void run(Direction[] tab){
        for (Direction d : tab){
            switch (d) {
                case FORWARD -> out.println("zwierzak idzie do przodu");
                case BACKWARD -> out.println("zwierzak idzie do tyłu");
                case RIGHT -> out.println("zwierzak skręca w prawo");
                case LEFT -> out.println("zwierzak skręca w lewo");
            }
        }


    }

    public static Direction[] change(String[] args){
        int l = args.length;
        Direction[] dir = new Direction[l];

        for (int i = 0; i < l; i++){
            switch (args[i]) {
                case "f" -> dir[i] = Direction.FORWARD;
                case "b" -> dir[i] = Direction.BACKWARD;
                case "r" -> dir[i] = Direction.RIGHT;
                case "l" -> dir[i] = Direction.LEFT;
            }
        }
        return dir;
    }

    public static void main(String[] args) {
        out.println("system wystartowal");

        Direction[] dir = change(args);
        run(dir);

        out.print("system zakonczyl dzialanie");
    }
}

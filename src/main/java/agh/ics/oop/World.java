package agh.ics.oop;
import static java.lang.System.out;


public class World {
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

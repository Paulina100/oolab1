package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void run(Direction.direction[] tab){
        for (Direction.direction d : tab){
            switch (d){
                case FORWARD:
                    out.println("zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    out.println("zwierzak skręca w prawo");
                    break;
                case LEFT:
                    out.println("zwierzak skręca w lewo");
                    break;
            }
        }
    }
    /*
    public static void run(String[] tab) {

        for (String d : tab){
            switch (d){
                case "f":
                    out.println("zwierzak idzie do przodu");
                    break;
                case "b":
                    out.println("zwierzak idzie do tyłu");
                    break;
                case "r":
                    out.println("zwierzak skręca w prawo");
                    break;
                case "l":
                    out.println("zwierzak skręca w lewo");
                    break;
            }
        }

        int x = tab.length;
        for (String i : tab){
            out.print(i);
            out.print(", ");

        }
    }*/

    public static void main(String[] args) {
        out.println("system wystartowal");
        int l = args.length;
        Direction.direction[] dir = new Direction.direction[l];


        for (int i = 0; i < l; i++){
            switch (args[i]){
                case "f":
                    dir[i] = Direction.direction.FORWARD;
                    break;
                case "b":
                    dir[i] = Direction.direction.BACKWARD;
                    break;
                case "r":
                    dir[i] = Direction.direction.RIGHT;
                    break;
                case "l":
                    dir[i] = Direction.direction.LEFT;
                    break;
            }
        }

        run(dir);

        out.print("system zakonczyl dzialanie");
    }
}

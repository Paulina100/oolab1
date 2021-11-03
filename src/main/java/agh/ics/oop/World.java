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
                default -> out.print("");
            }
        }


    }

    public static Direction[] change(String[] args){
        int l = args.length;
        Direction[] dir = new Direction[l];

        for (int i = 0; i < l; i++){
            dir[i] = switch (args[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.NONE;
            };
        }
        return dir;
    }

    public static void main(String[] args) {
//        out.println("system wystartowal");
//
//        Direction[] dir = change(args);
//        run(dir);
//        out.print("system zakonczyl dzialanie");

        /*Animal cat = new Animal();
        out.println(cat);

        MoveDirection[] dir = OptionsParser.parse(args);

        for (MoveDirection i : dir){
            cat.move(i);
            out.println(cat);
        }*/


        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine enegine = new SimulationEngine(directions, map, positions);
        enegine.run();


    }
}


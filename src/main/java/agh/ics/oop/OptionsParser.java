package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] tab){

        MoveDirection[] dir = new MoveDirection[tab.length];

        for (int i =0; i < tab.length; i++){
            switch (tab[i]){
                case "f", "forward" -> dir[i] = MoveDirection.FORWARD;
                case "b", "backward" -> dir[i] = MoveDirection.BACKWARD;
                case "r", "right" -> dir[i] = MoveDirection.RIGHT;
                case "l", "left" -> dir[i] = MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(tab[i] + " is not legal move specification");
            }
        }


        return dir;
    }
}

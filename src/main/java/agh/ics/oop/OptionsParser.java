package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] tab){
        int len = 0;
        for (String i : tab){
            switch (i){
                case "f", "forward", "b", "backward", "r", "right", "l", "left" -> len = len + 1;
            }
        }

        MoveDirection[] dir = new MoveDirection[len];

        int index = 0;
        for (String i : tab){
            switch (i){
                case "f", "forward" -> dir[index] = MoveDirection.FORWARD;
                case "b", "backward" -> dir[index] = MoveDirection.BACKWARD;
                case "r", "right" -> dir[index] = MoveDirection.RIGHT;
                case "l", "left" -> dir[index] = MoveDirection.LEFT;
                default -> index = index - 1;
            }
            index = index + 1;
        }

        return dir;
    }
}

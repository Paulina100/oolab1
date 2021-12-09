package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static java.lang.System.exit;
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {
    @Test
    public void parseTest(){
        String[] tab = new String[8];
        tab[0] = "f";
        tab[1] = "b";
        tab[2] = "forward";
        tab[3] = "l";
        tab[4] = "left";
        tab[5] = "right";
        tab[6] = "backward";
        tab[7] = "r";
        MoveDirection[] dir = OptionsParser.parse(tab);

        assertEquals(dir[0], MoveDirection.FORWARD);
        assertEquals(dir[1], MoveDirection.BACKWARD);
        assertEquals(dir[2], MoveDirection.FORWARD);
        assertEquals(dir[3], MoveDirection.LEFT);
        assertEquals(dir[4], MoveDirection.LEFT);
        assertEquals(dir[5], MoveDirection.RIGHT);
        assertEquals(dir[6], MoveDirection.BACKWARD);
        assertEquals(dir[7], MoveDirection.RIGHT);

        try {
            String[] tab2 = {"ala"};
            MoveDirection[] dir2 = OptionsParser.parse(tab2);
        } catch (IllegalArgumentException ex){
            assertEquals(ex.getMessage(), "ala is not legal move specification");
        }

    }
}

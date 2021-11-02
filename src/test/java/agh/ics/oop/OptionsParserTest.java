package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OptionsParserTest {
    @Test
    public void parseTest(){
        String[] tab = new String[15];
        tab[0] = "for";
        tab[1] = "f";
        tab[2] = "b";
        tab[3] = "forward";
        tab[4] = "l";
        tab[5] = "left";
        tab[6] = "fo";
        tab[7] = "right";
        tab[8] = "backward";
        tab[9] = "br";
        tab[10] = "rb";
        tab[11] = "blf";
        tab[12] = "bb";
        tab[13] = "bbr";
        tab[14] = "r";
        MoveDirection[] dir = OptionsParser.parse(tab);

        assertEquals(dir[0], MoveDirection.FORWARD);
        assertEquals(dir[1], MoveDirection.BACKWARD);
        assertEquals(dir[2], MoveDirection.FORWARD);
        assertEquals(dir[3], MoveDirection.LEFT);
        assertEquals(dir[4], MoveDirection.LEFT);
        assertEquals(dir[5], MoveDirection.RIGHT);
        assertEquals(dir[6], MoveDirection.BACKWARD);
        assertEquals(dir[7], MoveDirection.RIGHT);
    }
}

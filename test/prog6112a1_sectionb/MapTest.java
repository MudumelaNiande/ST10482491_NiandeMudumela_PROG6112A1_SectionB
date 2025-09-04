/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog6112a1_sectionb;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author niand
 */
public class MapTest {
    String mode = "hard";
    int guesses = 3;
    int treasureRow = 2;
    int treasureCol = 2;
    boolean found = true;
    
    
    @Test
    public void testGetGuesses() {
        Map map = new Map(mode, guesses, treasureRow, treasureCol, found);
        map.setGrid();
        int expected = 0;
        int actual = map.getGuesses();
        System.out.println(expected);
        System.out.println(actual);
        assertEquals(expected,actual);
    }

    @Test
    public void testReport() {
        Map map = new Map(mode, guesses, treasureRow, treasureCol, found);
        String actual = map.report();
        String expected = "";
        int initialGuesses;
        
        if(!found){
            expected += "You lost!\n";
        }
        else{
            expected += "You won!\n";
        }
        
        expected += "Mode: " + mode + "\n";
        
        if(mode.equals("easy")){
            initialGuesses = 10;
            expected += "Initial guesses: 10\n";
        }
        else if(mode.equals("medium")){
            initialGuesses = 6;
            expected += "Initial guesses: 6\n";
        }
        else{
            initialGuesses = 3;
            expected += "Initial guesses: 3\n";
        }
        
        expected += "Guesses used: " +  (initialGuesses - guesses) + "\n";
        System.out.println(actual);
        System.out.println(expected);
        assertEquals(expected,actual);
    }
    
}

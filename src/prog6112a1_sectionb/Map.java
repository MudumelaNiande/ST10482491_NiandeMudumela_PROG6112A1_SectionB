/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog6112a1_sectionb;

/**
 *
 * @author niand
 */
import java.util.Random;
public class Map {
    String mode;
    int guesses;
    int treasureRow;
    int treasureCol;
    boolean found;
    public static String[][] blocks = new String[6][6];
    
    Random random = new Random();
    
    public Map(String mode, int guesses, int treasureRow, int treaureCol, boolean found){
        /*mode = "hard";
        guesses = 3;
        treasureRow = 2;
        treasureCol = 2;
        found = true;*/
    }
    public Map(){
        
    }
    
    public Map(String mode){     
        //number of guesses determined by mode
        if(mode.equals("easy")){
            guesses = 10;
            this.mode = "easy";
        }
        else if(mode.equals("medium")){
            guesses = 6;
            this.mode = "medium";
        }
        else{
            guesses = 3;
            this.mode = "hard";
        }
        //randomly choose where the x is 
        treasureRow = random.nextInt(1,6);
        treasureCol = random.nextInt(1,6);   
        
        found = false;
    }
    
    public int getGuesses(){
        return guesses;
    }
    
    public int getTreasureRow(){
        return treasureRow;
    }
    
    public int getTreasureCol(){
        return treasureCol;
    }
    
    public void setGrid(){      
        //coordinates in the table
        for(int row = 0; row < blocks.length; row++){
            for(int col = 0; col < blocks[1].length; col++){
                blocks[row][col] = "? ";
            }
        }
        //Sides of the table 
        blocks[0][0] = "  ";
        blocks[1][0] = "1 ";
        blocks[2][0] = "2 ";
        blocks[3][0] = "3 ";
        blocks[4][0] = "4 ";
        blocks[5][0] = "5 ";
        
        blocks[0][1] = "1 ";
        blocks[0][2] = "2 ";
        blocks[0][3] = "3 ";
        blocks[0][4] = "4 ";
        blocks[0][5] = "5 ";
    }
    
    public void displayGrid(){
        for(int row = 0; row < blocks.length; row++){
            for(int col = 0; col < blocks[1].length; col++){
                System.out.print(blocks[row][col]);
            }
            System.out.println("");
        }
    }
    
    public void checkGuess(int row, int col){
        //check if chosen block contains the x
        if(row == treasureRow & col == treasureCol){
            blocks[row][col] = "X ";
            found = true;
        }
        else{
            blocks[row][col] = "  ";
        }
        guesses--; //total guesses left decreases
        displayGrid();
    }
    
    public boolean checkFound(){
        return found;
    }
    
    public String report(){//report of performance at the end of each game
        String output = "";
        int initialGuesses;
        
        if(!found){
            output += "You lost!\n";
        }
        else{
            output += "You won!\n";
        }
        
        output += "Mode: " + mode + "\n";
        
        if(mode.equals("easy")){
            initialGuesses = 10;
            output += "Initial guesses: 10\n";
        }
        else if(mode.equals("medium")){
            initialGuesses = 6;
            output += "Initial guesses: 6\n";
        }
        else{
            initialGuesses = 3;
            output += "Initial guesses: 3\n";
        }
        
        output += "Guesses used: " +  (initialGuesses - guesses) + "\n";
        return output;
    }
    
    public String rules(){
        String output = "";
        output += "Rules: \n";
        output += "Guess the coordinate which has the treasure\n";
        output += "If you click the correct coordinate an 'X' will mark the treasure\n";
        output += "Guessing the same coordinate twice results in a wasted guess so be careful\n";
        output += "You have a limited amount of guesses based on the mode you pick\n";
        output += "Easy mode: 10 guesses\n";
        output += "Medium mode: 6 guesses\n";
        output += "Hard mode: 3 guesses\n";
        return output;
    }
    
    public void developer(){  //Shows the correct coordinates, for testing
        System.out.println("Row: " + treasureRow);
        System.out.println("Col: " + treasureCol);
    }
}

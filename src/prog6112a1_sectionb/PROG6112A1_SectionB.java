/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog6112a1_sectionb;

/**
 *
 * @author niand
 */
import java.util.Scanner;
public class PROG6112A1_SectionB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean running = true;
        int row;
        int col;
        
        Scanner scanner = new Scanner(System.in);
        
        String mode;
        System.out.println("-----------------------------");
        System.out.println("Welcome to the Teasure Hunt!");
        System.out.println("-----------------------------");
          
        Map map1 = new Map();
        System.out.println(map1.rules());
        
        while(running){           
            System.out.print("Select Mode: ");
            mode = scanner.nextLine();
            
            //validdate mode entered
            boolean valid = false;
            while(!valid){
                if(mode.toLowerCase().equals("easy")  || mode.toLowerCase().equals("medium") || mode.toLowerCase().equals("hard")){
                    valid = true;
                }
            }
            
            Map map = new Map(mode);
            map.setGrid();
            map.displayGrid();
            //map.developer();
            System.out.println("You have " + map.getGuesses() + " guesses");
            for(int i = map.getGuesses(); i > 0; i--){
                System.out.print("Choose which row you want to play in: ");
                row = scanner.nextInt();
                scanner.nextLine();
                
                System.out.print("Choose which column you want to play in: ");
                col = scanner.nextInt();
                scanner.nextLine();
                
                map.checkGuess(row, col);
                if(map.checkFound() == true){
                    System.out.println("------------------------");
                    System.out.println("You found the Treasure!");
                    System.out.println("------------------------\n");
                    System.out.println(map.report());
                    
                    System.out.println("Enter y to play again or any other key to stop the hunt!");
                    String choice = scanner.nextLine();
                    if(choice.toLowerCase().equals("y")){
                        break;
                    }
                    else{
                        System.out.println("Safe travels explorer!");
                        running = false;
                        break;
                    }
                }
                else{
                    System.out.println("You have " + map.getGuesses() + " guesses left");
                }                
            }
            if(map.checkFound() == false){
                System.out.println("-----------------------------");
                System.out.println("You have run out of guesses!");
                System.out.println("-----------------------------");
                System.out.println(map.report());
                map.checkGuess(map.getTreasureRow(), map.getTreasureCol());                
                
                System.out.println("Enter y to play again or any other key to stop the hunt!");
                    String choice = scanner.nextLine();
                    if(choice.toLowerCase().equals("y")){
                        
                    }
                    else{
                        System.out.println("Safe travels explorer!");
                        running = false;
                    }
            }
        }
                
    }
    
}

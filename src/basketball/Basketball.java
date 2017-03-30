
package basketball;

/** A simple basketball game simulator
 *
 * written by Cole Petersen
 */

import java.util.Scanner;

public class Basketball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        String input;
        boolean exit = false;

        System.out.println("Welcome.");
        
        while(!exit){
            Game ThisGame = new Game(4, 10, 5, 1.8);
            System.out.println("1. Change game settings");
            System.out.println("2. Play game");
            System.out.println("3. Exit");

            Scanner read = new Scanner(System.in);
            input = read.nextLine();
            switch (input) {
                case "1":
                    ThisGame.ChangeGame();
                    break;
                case "2":
                    ThisGame.PlayGame();
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
        }
        
    }
    
}

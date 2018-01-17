/*
 * Project07.java
 * 
 *   A program that plays the dice game high/low
 *   Used to practice breaking code up into methods. 
 * 
 * @author Chuanjing Guo
 * @version 20150306
 * 
 */

package osu.cse1223;
import java.util.Scanner;

public class Project07 {

    public static void main(String[] args) {
    	Scanner in=new Scanner(System.in);
    	boolean ifcon=true;
    	int remain=100;
       
       while(ifcon){
    	    
    	   int bet =getBet(in,remain);
    	   if(bet==0){
    	   System.out.println("You have "+remain+"left");
    	   System.out.println("Goodbye!");
    	   break;
       }
    	   char yourHighLow=getHighLow(in);
    	   int die1 =getRoll();
    	   int die2 =getRoll();
    	   int dice = die1 + die2;
    	   int winning=determineWinnings(yourHighLow,bet,dice);
    	   System.out.println("Die 1 rolls: "+die1);
    	   System.out.println("Die 1 rolls: "+die2);
    	   System.out.println("Total of two dice is: "+dice);
    	   System.out.println();
       
    	   if(winning>0){
    	   System.out.println("You won "+winning+" dollars");
    	   remain=remain+winning;
       }
    	   else{
    	   System.out.println("You lost!");
    	   System.out.println();
    	   remain=remain+winning;
    	   if(remain<=0){
    		  System.out.println("You have 0 dollars left");
    		  System.out.println("Goodbye!");
    		  ifcon=false;
    	   }
       }
       }
    }

// Given a Scanner and a current maximum amount of money, prompt the user for
// an integer representing the number of dollars that they want to bet.  This
// number must be between 0 and to maximum number of dollars.  If the user enters
// a number that is out of bounds, display an error message and ask again.
// Return the bet to the calling program.
    private static int getBet(Scanner inScanner, int currentPool) {
        System.out.println("You have " + currentPool + " dollars.");
        System.out.print("Enter an amount to bet (0 to quit): ");      
        int outcome = inScanner.nextInt();
        System.out.println();
        while (outcome > currentPool || outcome < 0) {
            System.out.println("Your bet MUST be between 0 and "+ currentPool+" dollars");
            System.out.print("Enter an amount to bet (0 to quit): ");            
            outcome = inScanner.nextInt();
            System.out.println();
        }
             
        
        return outcome;
    }

// Given a Scanner, prompt the user for a single character indicating whether they
// would like to bet High ('H'), Low ('L') or Sevens ('S').  Your code should accept
// either capital or lowercase answers, but should display an error if the user attempts
// to enter anything but one of these 3 values and prompt for a valid answer.
// Return the character to the calling program.
    private static char getHighLow(Scanner inScanner) {
        boolean valid = false;
        System.out.print("High, low or sevens (H/L/S): ");
    	String str = inScanner.nextLine();
    	str = inScanner.nextLine();
    	 System.out.println();
    	char choice =str.charAt(0);
        while(!valid){
        	
        	if((choice=='h'||choice=='H'||choice=='L'||choice=='l'||choice=='S'||choice=='s')&&str.length()==1){
        		valid=true;
            }       
            else{
        	System.out.println("ERROR, please chose from H/L/S.");
        	System.out.print("High, low or sevens (H/L/S): ");
        	str = inScanner.nextLine();
        	 System.out.println();
        	choice =str.charAt(0);
        	
            }
        }
        return choice;
    }

// Produce a random roll of a single six-sided die and return that value to the calling
// program
    private static int getRoll() {
        int roll = (int) (6 * Math.random()) + 1;
        return roll;
        // Fill in the body
    }

// Given the choice of high, low or sevens, the player's bet and the total result of
// the roll of the dice, determine how much the player has won.  If the player loses
// the bet then winnings should be negative.  If the player wins, the winnings should
// be equal to the bet if the choice is High or Low and 4 times the bet if the choice
// was Sevens.  Return the winnings to the calling program.
    private static int determineWinnings(char highLow, int bet, int roll) {
        int result = 0;
        if (highLow == 'H'||highLow=='h') {
            if (roll <= 7) {
                result = (-1) * bet;
            } else {
                result = bet;
            }
        }
        if (highLow == 'L'||highLow=='l') {
            if (roll >= 7) {
                result = (-1) * bet;
            } else {
                result = bet;
            }
        }
        if (highLow == 'S'||highLow=='s') {
            if (roll == 7) {
                result = 4 * bet;
            } else {
                result = (-1) * bet;
            }
        }
        return result;
    }
}

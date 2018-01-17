/*Project05.java
 * 
 * The program will randomly generate an integer between 1 and 100 and will enter a loop where it prompt the user for a guess. 
 * If the user has guessed the correct number, the program will end with a message indicating how many guesses it took to get the right answer
 * and a message that is determined by how many guesses it takes them to get the right answer.
 * If the user guesses incorrectly, the program should respond with a message that the user has guessed either "too high" or "too low" 
 * and let them guess again.
 *     
 *@authour Chuanjing Guo
 *@version 20150218 
 */
		
package osu.cse1223;
import java.util.Scanner;

public class Project05 {

	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String message ="";
		int answer = (int)(Math.random()*100)+1;
		int count=1;
		boolean target = false;
		System.out.print("Enter a guess between 1 and 100: ");
		int input = keyboard.nextInt();
		
		while(!target){
			if(input<1||input >100){
				System.out.println("Your guess is out of range. Pick a number between 1 and 100.");
				input=keyboard.nextInt();
				count++;
			}
			else{
				while(input!=answer){
					if(input<answer){
						System.out.println("Your guess was to low. Try again.");
						System.out.println();
						System.out.print("Enter a guess between 1 and 100: ");
						input=keyboard.nextInt();
						count++;
						
					}
					if(input>answer){
						System.out.println("Your gess was to high. Try again.");
						System.out.println();
						System.out.print("Enter a guess between 1 and 100: ");
						input=keyboard.nextInt();
						count++;
					}
				
					
				}
				target=true;
			}
			
		}
		if(count>=10){
			message="This just isn't your game.";
		}
		if(count<10){
			message="That was not very good.";
		}
		if(count<8){
			message="That was OK.";
		}
		if(count<7){
			message="That was good.";
		}
		if(count<5){
			message="That was amazing!";
		}
		if(count<2){
			message="That was lucky!";
		}
		System.out.println("Congratulations!  Your guess was correct!");
		System.out.println("I had chosen "+answer+" as the target number.");
		System.out.println("You guessed it in "+count+" tries.");
		System.out.println(message);
	
		

	}

}

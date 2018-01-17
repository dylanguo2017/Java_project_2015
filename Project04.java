/*Project04.java
 * 
 *  This program  plays the game Rock, Paper, Scissors with a human opponent.  
 *  This program  randomly generates a choice for itself, takes an choice from the user,
 *  and determines a winner based on the rules of Rock, Paper, Scissors.
 *  
 *  author@ Chuanjing Guo
 *  version@20150211
 */

package osu.cse1223;

import java.util.Scanner;

public class Project04 {

	
	public static void main(String[] args) {
		String myChoice="",userC="",myC="";
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please select one of [R/P/S]: ");
		String userChoice = keyboard.nextLine();
		if (userChoice.equals("R")||userChoice.equals("r")){
			if(userChoice.equals("r")){
				System.out.println("Invalid choice! Defaulting to Rock.");
			}
			userC="Rock";
		}
		if (userChoice.equals("P")||userChoice.equals("p")){
			if(userChoice.equals("p")){
				System.out.println("Invalid choice! Defaulting to Paper.");
			}
			userC="Paper";
		}
		if (userChoice.equals("S")||userChoice.equals("s")){
			if(userChoice.equals("s")){
				System.out.println("Invalid choice! Defaulting to Scissors.");
			}
			userC="Scissors";
		}
		int random = (int)(3*Math.random())+1;
		if(random==1){
			myChoice="R";
			myC="Rock";
		}
		if (random==2){
			myChoice="P";
			myC="Paper";
		}
		if (random==3){
			myChoice="S";
			myC ="Scissors";
		}
		
		if (userChoice.equals(myChoice)){
			System.out.println("You chose: "+userC);
			System.out.println("I chose: "+myC);
			System.out.println("A Tie!");
		}
		else{
			if(userC.equals("Rock")&&myC.equals("Scissors")){
				System.out.println("You chose: "+userC);
				System.out.println("I chose: "+myC);
				System.out.println("Rock beats scissors - you win!");
			}
			if(userC.equals("Rock")&&myC.equals("Paper")){
				System.out.println("You chose: "+userC);
				System.out.println("I chose: "+myC);
				System.out.println("Paper beats rock - you lose!");
			}
			if(userC.equals("Paper")&&myC.equals("Rock")){
				System.out.println("You chose: "+userC);
				System.out.println("I chose: "+myC);
				System.out.println("Paper beats rock - you win!");
			}
			if(userC.equals("Paper")&&myC.equals("Scissors")){
				System.out.println("You chose: "+userC);
				System.out.println("I chose: "+myC);
				System.out.println("Scissors beats paper - you lose!");
			}
			if(userC.equals("Scissors")&&myC.equals("Rock")){
				System.out.println("You chose: "+userC);
				System.out.println("I chose: "+myC);
				System.out.println("Rock beats Scissors - you lose!");
			}
			if(userC.equals("Scissors")&&myC.equals("Paper")){
				System.out.println("You chose: "+userC);
				System.out.println("I chose: "+myC);
				System.out.println("Scissors beats paper - you win!");
			}
		}
			
		

	}

}

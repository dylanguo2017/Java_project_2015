/*
 * Project03
 * 
 * This program randomly generates math questions, takes an answer from the user,
 * and computes a final score based on the number of questions correctly answered.
 * 
 * @author Chuanjing Guo
 * @version 20150205
 */
package osu.cse1223;

import java.util.Scanner;

public class Project03 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = keyboard.nextLine();
		System.out.print("Welcome "+name);
		System.out.println("!   Please anwser the following questions: ");
		int x = (int)(20*Math.random())+1;
		int y = (int)(20*Math.random())+1;
		double record = 0;
		System.out.print(x+" + "+y+" = ");
		int userAnswer = keyboard.nextInt();
		int realAnswer = x + y;
		if (x+y==userAnswer){
			System.out.println("Correct!");
			record = record +1;
		}
		else{
			System.out.println("Wrong!");
			System.out.println("The correct answer is "+realAnswer);
		}
		System.out.print(x+" * "+y+" = ");
		userAnswer = keyboard.nextInt();
		realAnswer = x*y;
		if (x*y==userAnswer){
			System.out.println("Correct!");
			record = record +1;	
		}
		else{
			System.out.println("Wrong!");
			System.out.println("The correct answer is "+realAnswer);
		}
		System.out.print(x+" / "+y+" = ");
		userAnswer = keyboard.nextInt();
		realAnswer = x/y;
		if (x/y==userAnswer){
			System.out.println("Correct");
			record = record+1;
		}
		else{
			System.out.println("Wrong!");
			System.out.println("The correct answer is "+realAnswer);
		}
		System.out.print(x+" % "+y+" = ");
		userAnswer = keyboard.nextInt();
		realAnswer = x%y;
		if (x%y==userAnswer){
			System.out.println("Correct");
			record = record+1;	
		}
		else{
			System.out.println("Wrong!");
			System.out.println("The correct answer is "+realAnswer);
		}
		System.out.println("You got "+record+" correct answers");
		double percentage = (record/4)*100;
		System.out.println("That's "+percentage+"%");

	}

}

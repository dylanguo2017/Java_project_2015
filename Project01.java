/*
 * Project01.java
 * A simple program that prompt the user to enter two numbers.
 * The program will display a series of arithmetic operations using those two numbers
 * 
 * @author Chuanjing Guo
 * @version 20150123
 * 
 */

package osu.cse1223;

import java.util.Scanner;

public class Project01 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		System.out.print("Enter the first number:");
		int firstNumber =keyboard.nextInt();
		System.out.print("Enter the second number:");
		int secondNumber =keyboard.nextInt();
		int average = (firstNumber + secondNumber)/2;
		System.out.println("The average of your two numbers is :"+ average);
		int addition = firstNumber + secondNumber;
		System.out.println("The addition of your two numbers is :"+ addition);
		int subtraction = firstNumber - secondNumber;
		System.out.println("The subtraction of your two numbers is :"+ subtraction);
		int multiplication = firstNumber * secondNumber;
		System.out.println("The multiplication of your two numbers is :"+ multiplication);
		int division = firstNumber / secondNumber;
		System.out.println("The division of your two numbers is :"+ division);
		int remainder = firstNumber % secondNumber;
		System.out.println("The remainder of your two numbers is :"+ remainder);
	

	}

}

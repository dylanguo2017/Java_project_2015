/*
 * @author chuanjing guo
 * @version 20150130
 */

package osu.cse1223;

import java.util.Scanner;

public class Project02 {

	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a long string: ");
		String longString = keyboard.nextLine();
		System.out.print("Enter a substring: ");
		String subString = keyboard.nextLine();
		int longStringLength = longString.length();
		System.out.println("Length of your string: "+ longStringLength);
		int subStringLength = subString.length();
		System.out.println("Length of your substring: "+ subStringLength);
		int startPosition = longString.indexOf(subString);
		System.out.println("Starting position of your substring in string: " + startPosition);
		String beforeSubstring = longString.substring(0,startPosition);
		System.out.println("String before your substring: "+beforeSubstring);
		int beforeS = beforeSubstring.length();
		String afterSubstring = longString.substring(beforeS+subStringLength,longStringLength);
		System.out.println("String after your substring: "+afterSubstring);
		int endNumber = longStringLength-1;
		System.out.print("Enter a position between 0 and "+ endNumber);
		System.out.print(" :");
		int enterNumber = keyboard.nextInt();
		char orderChar = longString.charAt(enterNumber);
		System.out.print("The character at the positon "+enterNumber);
		System.out.println("  is: "+orderChar);
		System.out.print("Enter a replacement string: ");
		keyboard.nextLine();
		String replaceMent = keyboard.nextLine();
	
		System.out.println("Your new string is: "+beforeSubstring+replaceMent+afterSubstring);
		
		}

}

/*
 * Project09.java
 * 
 *   A program that converts Roman numerals to decimal numbers.
 *   Used to practice breaking code up into methods. 
 * 
 * @author Chuanjing Guo
 * @version 20150329
 * 
 */
package osu.cse1223;
import java.util.Scanner;


public class Project09 {

	public static void main(String[] args) {
		boolean ifQuit=true;
		Scanner in =new Scanner (System.in);
		String str="";
		while(ifQuit){
			 str=promptUserForNumeral(in);
			if (str.charAt(0)=='Q'){
				System.out.println("Goodbye! ");
				ifQuit=false;
			}
			else{
				System.out.println("The numeral "+str+" is the decimal number "+convertNumeralToNumber(str) );
			}	
		}
	}

	// Given a Scanner as input, prompts the user to input a Roman numeral.  Checks to make
	// sure that the user does not enter an empty String.  If the user does enter an
	// empty String, report an error and ask for a new String until a non-empty String is
	// provided.  Return the String input by the user to the calling program.
	private static String promptUserForNumeral(Scanner inScanner) {
		boolean volid =true;
		String str="";
		while(volid){
			System.out.print("Enter a roman numeral (Q to quit): ");
			str= inScanner.nextLine();
			if(str.length()==0){
				System.out.println("ERROR!  You must enter a non-empty line!");				
			}
			else{				
				volid=false;
			}	
		}
		return str;
	}
	// Given a String as input, converts the String to a number assuming that the String
	// is a Roman numeral (following the rules in the writeup for Project 09).  Returns the
	// number to the calling program.  NOTE:  This method can possibly get long and complex.
	// This about how you can break it up into two or three smaller methods to make it
	// less complex.
	private static int convertNumeralToNumber(String numeral) {
		int result =0;
		String neo ="";
		neo=numeral;
		while(neo.length()!=0){
			if(neo.length()==1){
				result=result+convertCharacterToNumber(neo.charAt(0));
				break;
			}
			else{
				if(convertCharacterToNumber(neo.charAt(0))>=convertCharacterToNumber(neo.charAt(1)) ){
					result=result+convertCharacterToNumber(neo.charAt(0));
					neo=neo.substring(1,neo.length());
				}
				else{
					result=result+convertCharacterToNumber(neo.charAt(1))-convertCharacterToNumber(neo.charAt(0));
					neo =neo.substring(2, neo.length());
				}				
			}			
		}
		return result;		
	}

	// Given a character that contains a single numeral, returns the integer value for
	// that character.  Use the tables in the write up for Project 09 to fill in this method.
	// For example, if the method is called with:
	//     convertCharacterToNumber('X')
	// the method should return the value 10.  And if the method is called with:
	//     convertCharacterToNumber('L')
	// the method should return the value 50.
	// Use this method with convertNumeralToNumber above to convert an entire Roman numeral
	// into a number.
	private static int convertCharacterToNumber(char numeral) {
		int result=0;
		
		if(numeral=='I'){result=1;}
		if(numeral=='V'){result=5;}
		if(numeral=='X'){result=10;}
		if(numeral=='L'){result=50;}
		if(numeral=='C'){result=100;}
		if(numeral=='D'){result=500;}
		if(numeral=='M'){result=1000;}
		return result;
	
		
	}
	
	

	
}

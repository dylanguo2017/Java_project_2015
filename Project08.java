/*
 * Project08.java
 * 
 *   A program that converts decimal numbers to Roman numerals.
 *   Used to practice breaking code up into methods. 
 * 
 * @author Chuanjing Guo
 * @version 20150313
 */
package osu.cse1223;
import java.util.Scanner;

public class Project08 {

	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int input;
		boolean ifQuit=true;
		while(ifQuit){
			
			input=promptUserForNumber(in);
			if(input==0){
				System.out.println("Goodbye!");
				ifQuit=false;
			}
			else{
				System.out.println("The number "+input+" is the Roman numeral "+convertNumberToNumeral(input));
			}
			
		}
		
		
		

	}
	// Given a Scanner as input, prompts the user to input a number between 1 and 3999.
	// Checks to make sure the number is within range, and provides an error message until
	// the user provides a value within range.  Returns the number input by the user to the
	// calling program.
	private static int promptUserForNumber(Scanner inScanner) {
		boolean valid =true;
		int result=0;
		while(valid){
			System.out.print("Enter a number between 1 and 3999 (0 to quit): ");
			result=inScanner.nextInt();
			if(result<0||result>3999){
				System.out.println("ERROR! Number must be between 1 and 3999");
				System.out.println();		
			}
			else{
				valid=false;
			}
		}
		return result;
		
	}
	
	// Given a number as input, converts the number to a String in Roman numeral format, 
	// following the rules in the writeup for Lab 09.  Returns the String to the calling
	// program.  NOTE:  This method can possibly get long and complex.  Use the 
	// convertDigitToNumeral method below to break this up and make it a bit simpler to code.
	private static String convertNumberToNumeral(int number) {
		String ones="",tens="",hundreds="",thousands="";
		String result="";
		int ONE,TEN,HUN,THOU;
		ONE=number%10;
		if(ONE==0){
			ones="";
		}
		else{
			ones=convertDigitToNumeral(ONE,'I','V','X');	
		}
		TEN=(number/10)%10;
		if(TEN==0){
			tens="";
		}
		else{
			tens=convertDigitToNumeral(TEN,'X','L','C');
		}
		HUN=(number/100)%10;
		if(HUN==0){
			hundreds="";
		}
		else{
			hundreds=convertDigitToNumeral(HUN,'C','D','M');
		}
		THOU=(number/1000)%10;
		if(THOU==0){
			thousands="";
		}
		else{
			if(THOU==1){thousands="M";}
			if(THOU==2){thousands="MM";}
			if(THOU==3){thousands="MMM";}
		}
		result=thousands+hundreds+tens+ones;
		return result;
		
		
		
	}
	
	// Given a digit and the Roman numerals to use for the "one", "five" and "ten" positions,
	// returns the appropriate Roman numeral for that digit.  For example, if the number to
	// convert is 49 we would call convertDigitToNumeral twice.  The first call would be:
	//     convertDigitToNumeral(9, 'I','V','X')
	// and would return a value of "IX".  The second call would be:
	//     convertDigitToNumeral(4, 'X','L','C')
	// and would return a value of "XL".  Putting those togeter we would see that 49 would be the
	// Roman numeral XLIX.
	// Call this method from convertNumberToNumeral above to convert an entire number into a 
	// Roman numeral.
	private static String convertDigitToNumeral(int digit, char one, char five, char ten) {
		String result="";
		if(digit==1){result=result+one;}
		if(digit==2){result=result+one+one;}
		if(digit==3){result=result+one+one+one;}
		if(digit==4){result=result+one+five;}
		if(digit==5){result=result+five;}
		if(digit==6){result=result+five+one;}
		if(digit==7){result=result+five+one+one;}
		if(digit==8){result=result+five+one+one+one;}
		if(digit==9){result=result+one+ten;}
		return result;
	}

}

/* Project06.java
 * 
 * For this lab you will write a Java program that checks UPC strings to see if they are valid.  
 * Your program should first prompt the user to enter a string of numbers as a UPC code, or enter a blank line to quit the program.  
 * If the user doesn't quit, your program should ensure that this string is exactly 12 characters in length.  
 * If the user enters a string that is not 12 characters in length, your program should print an error message and ask again for a valid string.  
 * Your program should use the algorithm below to compute what the check digit should be and then compare it to the actual value in the provided string 
 * and report whether the UPC is valid or wrong.  If it is wrong, your program should report what the correct check digit should be for the input UPC.  
 * Your program should keep asking for new UPC until the user enters a blank line to quit the program.
 * 
 * @author Chuanjing Guo
 * @version 20150227
 */
package osu.cse1223;

import java.util.Scanner;

public class Project06 {
	 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i=0;
		int j=0;
		int z=0;
		int checkNumber=0;
		System.out.print("Enter a UPC (enter a blank line to quit): ");
		String input =in.nextLine();
		if(input.length()==0){
			System.out.println("Goodbye!");
		}
		while(i < 11  ){
			char c = input.charAt(i);
			int inputCheck=Character.getNumericValue(input.charAt(input.length()-1));
			
			if(Character.isDigit(c) && input.length()==12){
				int x =Character.getNumericValue(c);
				if(i%2==0){
					j=j+x;	
				}
				else{
					z=z+x;	
				}
				
				i++;
					
			}
			else{
				System.out.println("ERROR! UPC MUST have exactly 12 digits");
				System.out.println();
				System.out.print("Enter a UPC (enter a blank line to quit): ");
				input = in.nextLine();
				if(input.length()==0){
					System.out.println("Goodbye!");
				}
				else{
					i=0;
					j=0;
					z=0;
				}
			}
			if(i==11){
				int result = (3*j+z)%10;
				if(result!=0){
					checkNumber=10-result;
				}
				if(checkNumber==inputCheck){
					System.out.println("Check digit should be: "+checkNumber);
					System.out.println("Check digit is: "+inputCheck);
					System.out.println("UPC is valid");
					System.out.println();
					System.out.print("Enter a UPC (enter a blank line to quit): ");
					input = in.nextLine();
					if(input.length()==0){
						System.out.println("Goodbye!");
					}
					else{
						i=0;
						j=0;
						z=0;
					}
				}
				else{
					System.out.println("Check digit should be: "+checkNumber);
					System.out.println("Check digit is: "+inputCheck);
					System.out.println("UPC is not valid");
					System.out.println();
					System.out.print("Enter a UPC (enter a blank line to quit): ");
					input = in.nextLine();
					if(input.length()==0){
						
						System.out.println("Goodbye!");
					}
					else{
						i=0;
						j=0;
						z=0;
					}
				}
			}
		}
			
		

	}

}

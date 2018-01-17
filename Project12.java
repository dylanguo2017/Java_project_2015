

/* Project12.java
 *
 *   A program that plays simple word guessing game.  In this game the user provides a list of
 *   words to the program.  The program randomly selects one of the words to be guessed from
 *   this list.  The player then guesses letters in an attempt to figure out what the hidden
 *   word might be.  The number of guesses that the user takes are tracked and reported at the
 *   end of the game.
 *   
 *   See the write-up for Project 12 for more details.
 *
 * @author Chuanjing Guo
 * @version 20150424
 */
package osu.cse1223;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Project12 {

    
    public static void main(String[] args) throws IOException {
    	Scanner in= new Scanner (System.in);
    	System.out.println("Enter a filename containing your wordlist: ");
    	String getName=in.nextLine();
    	ArrayList<String> list = new ArrayList<String>();
    	ArrayList<Character> list2= new ArrayList<Character>();
    	File file= new File(getName);
    	Scanner input=new Scanner(file);
    	list=getList(input);
    	System.out.println("Read "+list.size()+"words from the file. ");
    	System.out.println();
    	input.close();
    	boolean playAgain= true;
    	while(playAgain){
    		String str=getRandomWord(list);
    		String star=starWord(str);
    		System.out.println("The word to guess is: "+star);
    		int count=0;
    		char ch=' ';
    		String myGuess="";
    		boolean iftrue= true;
    		
    		while(iftrue){
    			boolean finish=true;
    			while(iftrue && finish){
    				String history=list2.toString().replace("[", "").replace("]","");
        			if(count==0){
        				System.out.println("Previously character guessed: ");
        				ch=getCharacterGuess(in);
        				list2.add(ch);
        				finish=false;
        			}
        			else{
        				System.out.println("Previous characters guessed: "+ history.toUpperCase());
        				ch=getCharacterGuess(in);
        				if(checkInList(ch,list2)){
        					System.out.println("You've already guessed "+ ch+ " try another character.");
        					System.out.println();	
        				}
        				else{
        					list2.add(ch);
        					history=list2.toString().replace("[", "").replace("]","");
        					finish=false;
        				}
        			}	
    			}
    			System.out.println("The character "+ch+" occurs in "+checkChar(ch,str )+" position.");
        		star=modifyGuess(ch,str,star.toUpperCase());
        		System.out.println("The word to guess is now: " + star);
    			System.out.print("Enter your guess: ");
    			myGuess = in.nextLine().toUpperCase();
    			count++;
    			print(myGuess, str,count);
    			boolean stop = fulfill(myGuess, str);//try to determine if the word has matched.
    			if (stop) {iftrue = false;}
    		}
    		System.out.println("Would you like a rematch [y/n]? ");
    		String onceMore=in.nextLine();
    		if(onceMore.equals("n")){
    			System.out.println("Thanks for playing!  Goodbye! ");
    			playAgain=false;
    			
    		}
    		
    	}  
    }
    
    
    // Given a Scanner as input, returns a List<String> of strings read from the Scanner.
    // The method should read words from the Scanner until there are no more words in the file
    // (i.e. inScanner.hasNext() is false).  The list of strings should be returned to the calling program.
    private static ArrayList<String> getList(Scanner inScanner) {
        
        ArrayList<String> list = new ArrayList<String>();
        while(inScanner.hasNext()){
        	list.add(inScanner.nextLine());
        }
        
        return list;
    }

    // Given two strings as input, compares the first string (guess) to the second
    // (solution) character by character.  If the two strings are not exactly the same,
    // return false.  Otherwise return true.
    private static boolean checkWord(String guess, String solution) {
    	boolean result=true;
		if(guess.toUpperCase().equals(solution.toUpperCase())){
			
			result = true;
			}
		else{
			result = false;
			}
		
		return result;
    }
    
    
    // Given a ArrayList<String> list of strings as input, randomly selects one of the strings
    // in the list and returns it to the calling program.
    private static String getRandomWord(ArrayList<String> inList) {
        String result="";
        int i=inList.size();
        int l=(int)Math.random()*i;
        result=inList.get(l);
        return result;
    }
    

    // Given a Scanner as input, prompt the user to enter a character.  If the character
    // enters anything other than a single character provide an error message and ask
    // the user to input a single character.  Otherwise return the single character to
    // the calling program.
    private static char getCharacterGuess(Scanner inScanner) {
        System.out.println("Enter a character to guess: ");
        String str =inScanner.nextLine();
        char c='a';
        boolean valid= true;
        while(valid){
            if(str.length()!=1){
                System.out.println("You should type in just one single character! ");
                str =inScanner.nextLine();
            }
            else{
                c =str.charAt(0);
                valid = false;
            }
            
        }
        return c ;
        
        
    }
    
    // Given a character inChar and a ArrayList<Character> list of characters, check to see if the
    // character inChar is in the list.  If it is, return true.  Otherwise, return false.
    private static boolean checkInList(char inChar, ArrayList<Character> inList) {
        int i=0;
        boolean result=false;
        while(i<inList.size()){
            if(inChar==inList.get(i)){
                result=true;
                i++;
            }
            else{
                i++;
            }
        }
        return result;
    }
    
    // Given a String, return a String that is the exact same length but consists of
    // nothing but '*' characters.  For example, given the String DOG as input, return
    // the string ***
    private static String starWord(String inWord) {
        String result="";
        int i= inWord.length();
        int y=0;
        while(y<i){
            result=result+"*";
        }
        return result;
    }
    
    // Given a character and a String, return the count of the number of times the
    // character occurs in that String.
    private static int checkChar(char guessChar, String guessWord) {
        int count =0;
        int i=0;
        while(i< guessWord.length()){
            if(guessChar==guessWord.charAt(i)){
                count++;
                i++;
            }
            else{
                i++;
            }
        }
        return count;
        
        
    }

    // Given a character, a String containing a word, and a String containing a 'guess'
    // for that word, return a new String that is a modified version of the 'guess'
    // string where characters equal to the character inChar are uncovered.
    // For example, given the following call:
    //   modfiyGuess('G',"GEOLOGY", "**O*O*Y")
    // This functions should return the String "G*O*OGY".
    private static String modifyGuess(char inChar, String word, String currentGuess) {
        ArrayList<Character> list = new ArrayList<Character>();
        int y=0;
        while (y<word.length()){
            list.add(currentGuess.charAt(y));
            y++;
        }
        int i =0;
        while ( i< word.length()){
            if(inChar==word.charAt(i)){
                list.set(i,inChar);
                i++;    
            }
            else{
                i++;
            }
            
        }
        int z=0;
        String result="";
        while(z<list.size()){
            result=result+list.get(z);
            z++;
        }
        return result;     
    }
	private static void print (String guess, String solution, int trytimes)
	{
		guess = guess.toUpperCase();
		solution = solution.toUpperCase();
		if(checkWord(guess, solution))
		{
			System.out.println("You achieved the correct answer in "+ trytimes +" guesses!");
			System.out.println("Congratulations! "+solution+ " is the correct word!");
			System.out.println();
			
		}
		else
		{	
			System.out.println("That is not the correct word. ");
			System.out.println();
			System.out.println("Please guess another letter and try again. ");
		}
	}
	//use the following method to determine if the while loop in the main method need to go on.
private static boolean fulfill (String guess, String solution)
	{	boolean stop = true;
		guess = guess.toUpperCase();
		solution = solution.toUpperCase();
		if(checkWord(guess, solution))
		{
			System.out.println();
			stop =true;
			
		}
		else
		{
			stop = false;
		}
		return stop;
	}
}
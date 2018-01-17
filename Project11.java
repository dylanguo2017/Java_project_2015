/*
 * Project11.java
 * 
 *   A program that reads in a text file that uses a specific input format and uses it to
 *   produce a formatted report for output.
 *   
 *   See the write-up for Homework Lab 13 for more details.
 *   
 *   This skeleton is more "skeletal" than previous labs.  You MUST break your code up into
 *   more methods than what you see here.  Consider methods to display the formatted report
 *   as well as more methods to compute values for the report.
 * 
 * @author Chuanjing Guo
 * @version  20150417
 */
package osu.cse1223;
import java.io.*;
import java.util.*;

public class Project11 {
	
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		System.out.print("Enter an input file name: ");
		String input =in.nextLine();
		System.out.print("Enter an output file name: ");
		String output=in.nextLine();
		PrintWriter outputFile =new PrintWriter(output);
		outputFile.println("Final Overall Scores Report");
		outputFile.println();
		outputFile.println("Name                    Mean  Median   Max   Min");
		outputFile.println("--------------------  ------  ------ ----- -----");
		
		File file =new File(input);
		Scanner inputFile =new Scanner (file);
		String personName;
		List <Integer> single = new ArrayList<Integer>();
		int mean, median, max,min;
		String highest="", lowest="";
		int Max=0, Min=100;
		int count=0;
		
		while(inputFile.hasNext()){
			personName = inputFile.nextLine();
			single = readNextSeries(inputFile);
			mean=getAverage(single);
			median=getMedian(single);
			Collections.sort(single);
			max=single.get(single.size()-1);
			min=single.get(0);
			if(mean>Max){
				 highest=personName;
				 Max=mean;
			}
			if(mean<Min){
				 lowest=personName;
				 Min=mean; 
			}	
			count++;
			outputFile.format("%-20s%8d%8d%6d%6d\n", personName, mean, median, max, min);	
		}
		outputFile.println();
		outputFile.println("Total number of participants: "+count);
		outputFile.println("Highest average score: "+highest+" ("+Max+")");
		outputFile.println("Lowest average score: "+lowest+" ("+Min+")");
		
		inputFile.close();
		outputFile.close();
	}
	
	// Given a Scanner as input read in a list of integers one at a time until a negative
	// value is read from the Scanner.  Store these integers in an ArrayList<Integer> and
	// return the ArrayList<Integer> to the calling program.
	private static List<Integer> readNextSeries(Scanner inScanner) {
		ArrayList <Integer> result = new ArrayList<Integer>();
		
		
		String tempLine = inScanner.nextLine();
		int tempInt = Integer.parseInt(tempLine);
		
		while(tempInt != -1){
			
			result.add(tempInt);
			
			tempLine = inScanner.nextLine();
			tempInt = Integer.parseInt(tempLine);
			
		}
		return result;
		
	}
	
	// Given a List<Integer> of integers, compute the median of the list and return it to
	// the calling program.
	private static int getMedian(List<Integer> inList) {
		
		Collections.sort(inList);
		int result=0;
		int size=inList.size();
		if(size%2==0){
			result=(inList.get(size/2)+inList.get((size/2)-1))/2;	
		}
		else{
			result=inList.get(size/2);
		}
		
		
		return result;
	}
	
	// Given a List<Integer> of integers, compute the average of the list and return it to
	// the calling program.
	private static int getAverage(List<Integer> inList) {
		int result =0,total=0,count=0;
		for(int i=0; i<inList.size(); i++){
			total=total+inList.get(i);
			count++;	
		}
		result=total/count;
		return result;
		
	}
	
	

}

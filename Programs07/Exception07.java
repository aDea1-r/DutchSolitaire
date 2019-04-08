import java.io.*;


/**
 *	Exception07.java  07-21-10  by Leon Schram
 *
 *	This program executes the second catch block.  The correct data file name is used	
 *	so that the first catch block will not activate.  Do not expect to see multiple		
 *	outputs from multiple catch blocks.  That is not possible.  The moment any segment	
 *	of a try block generates an exception, the execution of the remaining <try> block		
 *	statements is cancelled.															
 *																							
 *	In this example the intent is to read in a text file and to convert the text to		
 *	integers with <Integer.parseInt>.  This can work as long as the input string only	
 *	contains numerical characters.  In this example the "Data.txt" file contains only		  
 *	non-numeric characters.  The attempt to convert a string of characters to a			
 *	is not successfull.	
 **/																
import java.io.*;


public class Exception07
{
	public static void main (String args[]) 
	{	
		try
		{
			FileReader inFile = new FileReader("Data.txt");
			BufferedReader inStream = new BufferedReader(inFile);
			String inString = inStream.readLine();
			int number = Integer.parseInt(inString);				
			System.out.println(number);	
		}
		catch (IOException e)
		{
			System.out.println("The code generated the following I/O exception.\n");
			System.out.println(e.getMessage());
		}
		catch (NumberFormatException e)
		{
			System.out.println("The code generated the following Number Format exception.\n");
			System.out.println(e.getMessage());
		}
					
		System.out.println();	
	}
}
 
import java.io.*;


/**
 *	Exception04.java  07-21-10  by Leon Schram
 *																																								
 *	This program is intentionally altered to guarantee an error during runtime.	 The	
 *	name of the data file is changed to Data2.txt.  This file does not exist.			
 *																							
 *	In the catch block a method of the IOException class, getMessage, is called with	
 *	object <e>.  Since we have now followed the rules, Java rewards us with an error		
 *	message during runtime.																		
 *																							
 *	The significant demonstration of this program is that the execution did not stop	
 *	with a runtime error.  It did display an error message - as requested - and then	
 *	the program is allowed to proceed with the remainder of the execution.
 *
 *	It is not guaranteed that all exceptions handled in this manner allow program execution
 *	to proceed.  Some errors are not able to be forgiven and the program crashes.				 
 **/
public class Exception04
{
	public static void main (String args[]) 
	{	
		try
		{
			FileReader inFile = new FileReader("Data2.txt");
			BufferedReader inStream = new BufferedReader(inFile);
			String inString = inStream.readLine();				
			System.out.println(inString);
			inStream.close();	
		}
		catch (IOException e)
		{
			System.out.println("There were problems with the code as stated below\n");
			System.out.println(e.getMessage());
		}
									
		System.out.println();
		System.out.println("The program can continue now.\n");	
	}
}
 
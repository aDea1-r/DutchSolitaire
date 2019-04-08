import java.io.*;


/**
 *	Exception05.java  07-21-10  by Leon Schram
 *																					
 *	The "finally" keyword is demonstrated in this program.  There are now three parts	
 * 	dealing with exceptions.  Essentially, you are saying:  try this block of code		
 *	first.  If the execution of the code causes problems, tell me what is wrong, and 	
 *	follow my instructions, and then, finally, go ahead and execute this code.
 **/			  
public class Exception05
{
	public static void main (String args[]) 
	{	
		try
		{
			FileReader inFile = new FileReader("Data2.txt");
			BufferedReader inStream = new BufferedReader(inFile);
			String inString = inStream.readLine();				
			System.out.println(inString);	
		}
		catch (IOException e)
		{
			System.out.println("Executing the code in the try block generated the following exception.\n");
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("The program will now continue without file handling.");			
		}
									
		System.out.println();	
	}
}
 
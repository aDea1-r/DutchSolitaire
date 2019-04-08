import java.io.*;


/**
 *	Exception03.java  07-21-10  by Leon Schram
 *																							
 *	This program example uses the "try & catch" approach to Exception handling.			
 *	The program places the problematic code - file handling code - inside the "try" 	
 *	block.  Is is fine to include some code that may not be troublesome, but you must	
 *	include any process that has potential problems.  This includes constructing		
 *	an object that accesses an external file and any method calls that read in or		
 *	write out to the file.  You tell Java to go ahead and give this code segment a try.	
 *																							
 *	Now if the code causes an error, or as Java prefers to say, an exception, then 		
 *	move on and execute the "catch" block.  The catch block starts by creating an		
 *	object of the expected exception class.  In this case this is an <IOException>, which	
 *	means Input/Output Exception.														
 *																							
 *	Right now <catch> does nothing, because the catch block is empty.  For all practical	
 *	purposes this program is the same as the previous program, which used the			
 *	"throws IOException" option.														 
 **/
public class Exception03
{
	public static void main (String args[]) 
	{	
		try
		{
			FileReader inFile = new FileReader("Data.txt");
			BufferedReader inStream = new BufferedReader(inFile);
			String inString = inStream.readLine();				
			System.out.println(inString);
			inStream.close();	
		}
		catch (IOException e)
		{
		}
									
		System.out.println();	
	}
}
 
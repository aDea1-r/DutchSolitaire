import java.io.*;


/**
 *	Exception02.java  07-21-10  by Leon Schram
 *																																																									
 *	This program compiles and executes correctly.  Note that line 22 has added two		
 *	words:  "throws IOException".														
 *																							
 *	You have told Java to mind its own business and you do not care about the possible	
 *	consequences of running a program with troublesome file handling.  This is not the 	
 *	same as doing nothing.  You have done something, which tells Java to relax.			
 *																							
 *	It must be understood that this option is the quickest approach to writing the		
 *	program so that it compiles and satisfies Java.  On the other hand, such a program	
 *	is now going to get the consequences of any problems without the benefit of			
 *	instructions how to handle problems.  You have just told Java to deal with any		
 *	headaches along the way.  This should not be used in any serious program.			
 **/
public class Exception02
{
	public static void main (String args[]) throws IOException
	{
		FileReader inFile = new FileReader("Data.txt");			
		BufferedReader inStream = new BufferedReader(inFile);			
		String inString = inStream.readLine();				
		System.out.println(inString);        				
		inStream.close();    									
		System.out.println();	
	}
}
 
import java.io.*;


/**
 *	Exception01.java  07-21-10  by Leon Schram
 *																							
 *	There are many potential problems with the execution of a program.  In this program	
 *	example the intention is to read the contents of an external data file.  Working	
 *	with external files can be problematic.  What happens if the specified file name is	
 *	wrong or the file does not exist?  Java requires that special procedures are 		
 *	followed for potential problems.  These procedures are called "Exception Handling."	
 *	Java calls errors exceptions.  The programmer has the option to ignore any kind		
 *	of problems or specify how to handle the problems.  However, you do not have the	
 *	option to simply ignore the situation.												
 *																							
 *	This program attempts to ignore the whole business of input/output errors and		
 *	Java rewards this attempt with an error messages, which indicates that the exception 	
 *	must be	"caught" or "thrown".														
 *																							
 *	Java means by "caught" that the programmer gives explicit instructions in the		
 *	source code how to handle any errors that are found.  If the errors are properly	
 *	handled, the program is possibly able to handle problems without "crashing" and allows		
 *	continued execution in many cases.													
 *																						
 *	Java means by "thrown" that the programmer does not give instructions in the		
 *	source code how to handle errors.  Basically, it means that the programmer			
 *	is aware of potential problems and tells Java to not worry about any of the			
 *	possible consequences.
 *
 *	The lab assignment for Unit06 is to create a new game, called "Dutch Solitaire",
 *  in stages without any introductory partial programs.  This unit does provide the
 *  exception handling examples since it is anticipated that this knowledge will be
 *  required to complete the game.
 **/  															
public class Exception01
{
	public static void main (String args[]) 
	{
		FileReader inFile = new FileReader("Data.txt");			
		BufferedReader inStream = new BufferedReader(inFile);			
		String inString = inStream.readLine();				
		System.out.println(inString);        				
		inStream.close();    									
		System.out.println();	
	}
}
 
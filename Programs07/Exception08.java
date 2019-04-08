import java.io.*;


/**
 *	Exception08.java  07-21-10  by Leon Schram
 *
 *	<Exception> is the superclass of all exception subclasses like <IOException> and
 *	many others.  The program code benefits from readability by using the specific type
 *	of exception you are catching.  However, it is not necessary.  As this program
 *	example shows, you can use the <Exception> class and it will catch the appropriate
 *	errors to help debug the program.
 **/
import java.io.*;


public class Exception08
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
		catch (Exception e)
		{
			System.out.println("The code generated the following exception.\n");
			System.out.println(e.getMessage());
		}

		System.out.println();
	}
}

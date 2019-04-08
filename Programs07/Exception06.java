import java.io.*;


/**
 *	Exception06.java  07-21-10  by Leon Schram
 *
 *	You may use multiple catch blocks, each with different exceptions.  This program
 *	adds a catch block for "NumberFormatException."  In this program there is no
 *	reason to do this, since numbers are not an issue.  It does show that only the
 *	exception catch block, which is appropriate, is used.
 **/
public class Exception06
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

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


/**
 *	Exception12.java  07-21-10  by Leon Schram
 *																						
 *	We now return to the program that first introduced the <Robot> class and its		
 *	requirements for exception handling.  The first introduction was done in a program	
 *	written as an application.  The same program logic will now be repeated but this	
 *	time the program is written as an applet.											
 *																							
 *	The first impression is good since the program compiles.  A switch to execution		
 *	in a web page is discouraging with a text window full of writing starting with		
 *	AccessControlException.																
 *																							
 *	Java was created to work with web pages in a secure manner.  The <Robot> class		
 *	allows low-level access of a computer, which is a security hazard.  This is not		
 *	an issue with files names and other potential problems that can be processed with	
 *	exception handling.  It is now a security issue and Java does not allow such		
 *	access with its potential hazardous consequences.
 **/									
public class Exception12 extends Applet
{
		
	public void paint (Graphics g)
	{
		try
		{
			Robot robot = new Robot();
			Color pixel = robot.getPixelColor(400,400);
			System.out.println(pixel.getRed() + "  " + pixel.getGreen() + "  " + pixel.getBlue());
		}
		catch (AWTException e)
		{
			System.out.println(e.getMessage());
		} 
		
	}

}



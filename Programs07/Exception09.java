import java.awt.*;
import java.awt.event.*;


/**
 *	Exception09.java  07-21-10  by Leon Schram
 *
 *	In the world of graphics there exist special errors when using low-level routines.
 *	The <Robot> class allows low-level access to computer information and requires
 *	exception handling.  Graphics problems generate <AWTException>s.
 *
 *	This program uses the <getPixelColor> method of the <Robot> class.  The red, green
 *	and blue color values of the specified screen location will be displayed on the
 *	text output window.
 *
 *	Note that this program displays graphics output as an application program and not
 *	an applet program.	It is possible that the main method makes no sense at all.
 *	Explaining that code is part of another unit on graphics.
 *
 *	This program finds the pixel displayed at the (400,400) location and then returns
 *	the "red", "green" and "blue" values of this pixel.
 **/
public class Exception09
{
	public static void main(String args[])
	{
		Screen screen = new Screen();
		screen.setSize(1000,750);
		screen.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		screen.show();
	}
}


class Screen extends Frame
{

	public void paint (Graphics g)
	{
		try
		{
			Robot robot = new Robot();
			Color pixel = robot.getPixelColor(400,400);
			System.out.println(pixel.getRed() + "  " + pixel.getGreen() + "  " + pixel.getBlue());
			Color q = new Color(300,300,300);
		}
		catch (AWTException e)
		{
			System.out.println("Executing the code in the try block generated the following exception.\n");
			System.out.println(e.getMessage());
		}
	}

}



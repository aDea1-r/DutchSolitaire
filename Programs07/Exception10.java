import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.Robot;
import java.io.*;;


/**
 *	Exception10.java  07-21-10  by Leon Schram
 *																										
 *	This program uses the <Robot> class once more, which requires proper exception		
 *	handling.  The <createScreenCapture> method of the <Robot> class is used to take	
 *	a screenshot of a specified area.  This screenshot is saved in an object of the		
 *	<BufferedImage> class and then saved as a JPG file on the hard drive.				
 *																							
 *	You can exit JCreator and load the image in a program, such as "Picture Manager"		
 *	to view the picture.  The next program will also display the captured image.
 **/		 
public class Exception10
{
	
	public static void main(String[] args) 
	{
		try 
		{
			Robot robot = new Robot();
			Rectangle rectangle = new Rectangle(10,10,300,200);
			BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
			File imageFile = new File("Exception10.jpg");
			ImageIO.write(bufferedImage, "jpg", imageFile);
			System.out.println("The image is captured and stored");
		} 
		catch (Exception e) 
		{
			e.getMessage();
		} 	
	}
	
}


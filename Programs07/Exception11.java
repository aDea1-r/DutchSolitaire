import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


/**
 *	Exception11.java  07-21-10 by Leon Schram
 *																							
 *	This program example serves two purposes:  											
 *																							
 *	First, it retrieves the saved image	that was captured by program Exception10.java	
 *	and then displays it in three different locations.									
 *																							
 *	Second, it shows the curious nature of Java exception handling.						
 *	You see, in this program we load an image into memory and then display it on 		
 *	the monitor in three places.  It seems that such a process has potential			
 *	issues with missing files, wrong names and wrong locations.  Yet Java does not		
 *	require any exception handling.  If you try a wrong file name, you simply get		
 *	an empty white applet window staring at you.										
 *																							
 *	It may be difficult to determine if exception handling is required or not.			
 *	In practice that issue becomes simple.  If you fail to use exception handling		
 *	when it is required, Java will let you know with a compile error message.
 *
 *	You must first execute program <Exception10.java> to store an image before you
 *	can execute this program correctly.
 *
 *	You may be confused by the switch to an "applet" program.  The screen segment was
 *	"captured" with a low-level <Robot> class routine, which is not allowed in an applet.
 *	Now that the screen is captured, and a file is saved externally, Java is happy to
 *	display the image in an applet program.
 **/			    
public class Exception11 extends Applet
{
	
	Image picture;
		
	public void init()
	{
		picture = getImage(getDocumentBase(),"Exception10.jpg");	
	}
		
	public void paint (Graphics g)
	{
		g.drawImage(picture,0,0,this);
		g.drawImage(picture,600,150,this);		
		g.drawImage(picture,300,400,this);		
	}

}



import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Card {

    private String shape;
    private int count;
    private BufferedImage image;

    public Card(String shape, int count) {
        this.count=count;
        this.shape=shape;
        this.image = getImage();
    }

    public void draw(Graphics g, int x, int y) {
        g.drawImage(image,x*73+30,y*97+30,null);
    }

    private BufferedImage getImage() {
        String fileName = "CardImages/"+count+shape.substring(0,1).toLowerCase()+".gif";
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(fileName));
//            System.out.println(fileName + " found");
        }
        catch(Exception e) {
            System.out.println(fileName + " not found");
        }
        return image;
    }

    public String getShape() {
        return shape;
    }

    public int getCount() {
        return count;
    }

    public void setShape(String s) {
        this.shape=s;
        image = getImage();
    }

    public void setCount(int x) {
        this.count=x;
        image = getImage();
    }

    public void setCard(String s, int x) {
        shape = s;
        count = x;
        image = getImage();
    }

}

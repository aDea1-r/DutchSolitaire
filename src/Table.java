import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import static java.awt.event.KeyEvent.VK_ESCAPE;

public class Table extends Canvas implements MouseListener, KeyListener {
    private Cards layout;
    private boolean selected = false;
    private int selectedCard1R;
    private int selectedCard1C;
    private BufferedImage winMessage;
    private MediaPlayer winSound;
    Boolean gameWon = false;


    public Table() {
        BufferedImage confetti = null;
        try {
            winMessage = ImageIO.read(new File("confetti.png"));
            confetti = ImageIO.read(new File("winMessage.png"));
        } catch(IOException e) {
            System.out.println("image not found");
        }
        Graphics win = winMessage.createGraphics();
        win.drawImage(confetti,100,100,null);

//        winSound = new MediaPlayer(new Media(new File("win.mp3").toURI().toString()));

        setBackground(Color.GREEN);

        layout = new Cards();
        layout.shuffle();
        layout.moveAces();

        this.addMouseListener(this);
        this.addKeyListener(this);

        setVisible(true);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        BufferedImage temp = (BufferedImage)createImage(getWidth(),getHeight());
        Graphics back = temp.createGraphics();
        back.setColor(Color.GREEN);
        back.fillRect(0,0,getWidth(),getHeight());
        layout.drawAllCards(back);
        back.setColor(Color.RED);
        if (selected) {
            back.fillRect(selectedCard1C*73 - 4+30, selectedCard1R*97 - 4+30, 81, 105);
            layout.drawCard(back,selectedCard1R,selectedCard1C);
        }
        layout.drawCheat(back);
        if(layout.gameWon()){
            back.drawImage(winMessage,0,0,null);
            if(!gameWon) {
                gameWon = true;
//                winSound.play();
            }
            else
                gameWon = false;
        } else {
            gameWon = false;
        }
        g.drawImage(temp, 0,0,null);
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        int r = (y-30)/97;
        int c = (x-30)/73;

        if(x<30 || r>3 || y<30 || c>13) {
            selected = false;
            repaint();
            return;
        }

        if(!selected) {
            selectedCard1R = r;
            selectedCard1C = c;
            selected = true;
            repaint();
        }
        else {
            int selectedCard2R = r;
            int selectedCard2C = c;
            selected = false;
            if (layout.canSwap(selectedCard1R, selectedCard1C, selectedCard2R, selectedCard2C)) {
                layout.swap(selectedCard1R, selectedCard1C, selectedCard2R, selectedCard2C);
            }
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='c') {
            layout.enableCheat();
//            System.out.println("cheat enabled");
            repaint();
        }
//        System.out.println("keytyped");
        else if(e.getKeyChar()==VK_ESCAPE) {
            selected = false;
            repaint();
        }

        else if(e.getKeyChar()=='w') {
            layout.forceWin();
//            System.out.println("w pressed");
//            for (double i=0; i<1000000; i+=0.001);
            repaint();
        }
    }

    public void keyPressed(KeyEvent e) {
//        System.out.println("keypressed");
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()=='c') {
            layout.disableCheat();
//            System.out.println("cheat disabled");
            repaint();
        }
    }

}

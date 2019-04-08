import javax.swing.*;

public class DutchSolitaire extends JFrame {

    private static final int WIDTH = 1098;
    private static final int HEIGHT = 537;

    public DutchSolitaire() {
        super("Dutch Solitaire");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Table theGame = new Table();
        (theGame).setFocusable(true);

        getContentPane().add(theGame);

        setVisible(true);
    }

    public static void main(String args[]) throws Exception {
        DutchSolitaire run = new DutchSolitaire();
    }

}

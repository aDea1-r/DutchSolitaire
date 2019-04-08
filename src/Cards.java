import java.awt.*;

public class Cards {

    private Card[][] matrix;
    private boolean cheat;

    public Cards() {
        matrix = new Card[4][14];
        String[] shapes = {"c","d","h","s"};

        int r = 0;
        int c=0;
        for (int count = 2; count<=15; count++) {
            for (String shape: shapes) {
                Card temp = new Card(shape,count);
//                System.out.println("matrix["+r+"]["+c+"] called");
                matrix[r][c] = temp;
                r++;
            }
            r=0;
            c++;
        }
    }

    public void drawAllCards(Graphics g) {
        for (int r=0; r<matrix.length; r++) {
            for (int c=0; c<matrix[r].length; c++) {
                matrix[r][c].draw(g,c,r);
            }
        }
    }

    public void enableCheat() {
        cheat = true;
    }

    public void disableCheat() {
        cheat = false;
    }

    public void drawCheat(Graphics g) {
        Color temp = g.getColor();
        g.setColor(Color.MAGENTA);
        if(cheat)
            g.drawString("Cheat Mode Enabled",75,460);
        g.setColor(temp);
    }

    public void swap(int r1, int c1, int r2, int c2) {
        Card temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    public void shuffle() {
        for (int r=0; r<matrix.length; r++) {
            for (int c=0; c<matrix[r].length-1; c++) {
                int[] other = getRandomSpot();
                swap(r,c,other[0],other[1]);
            }
        }
    }

    public int[] getRandomSpot() {
        int[] spot = new int[2];
        spot[0] = (int)(Math.random()*4);
        spot[1] = (int)(Math.random()*13);
        return spot;
    }

    public void moveAces() {
        for (int r=0; r<matrix.length; r++) {
            for (int c=0; c<matrix[r].length; c++) {
                if(matrix[r][c].getCount()==14) {
                    if (matrix[r][c].getShape().equals("c")) {
                        swap(r,c,0,13);
                    }
                    else if (matrix[r][c].getShape().equals("d")) {
                        swap(r,c,1,13);
                    }
                    else if (matrix[r][c].getShape().equals("h")) {
                        swap(r,c,2,13);
                    }
                    else if (matrix[r][c].getShape().equals("s")) {
                        swap(r,c,3,13);
                    }
                }
            }
        }
        for (int r=0; r<matrix.length; r++) {
            int rand = (int)(Math.random()*4);
            swap(r,13,rand,13);
        }
    }

    public boolean canSwap(int r1, int c1, int r2, int c2) {
        if(cheat)
            return true;
        Card blank = null;
        Card full = null;
        int blankR=0;
        int blankC=0;
        int fullR=0;
        int fullC = 0;
        if (matrix[r1][c1].getCount()==15) {
            blank = matrix[r1][c1];
            blankR = r1;
            blankC = c1;
            full = matrix[r2][c2];
            fullR = r2;
            fullC = c2;
        } else if (matrix[r2][c2].getCount()==15) {
            blank = matrix[r2][c2];
            blankR = r2;
            blankC = c2;
            full = matrix[r1][c1];
            fullR = r1;
            fullC = c1;
        }
        if(blank==null || full == null)
            return false;

        Card blankLeft;
        Card blankRight;
        if (blankC-1>=0)
            blankLeft = matrix[blankR][blankC-1];
        else
            blankLeft = null;
        if (blankC+1<=13)
            blankRight = matrix[blankR][blankC+1];
        else
            blankRight = null;
        if(full.getCount()==14)
            return false;
        if(blankLeft!=null && blankLeft.getShape().equals(full.getShape()) && blankLeft.getCount()+1==full.getCount())
            return true;
        if(blankRight!=null && blankRight.getShape().equals(full.getShape()) && blankRight.getCount()-1==full.getCount())
            return true;
        if(full.getCount()==2 && blankC==0)
            return true;

        return false;

    }

    public void drawCard(Graphics g, int r, int c) {
        Card temp = matrix[r][c];
        temp.draw(g,c,r);
    }

    public boolean gameWon() {
        for(int r=0; r<matrix.length; r++) {
            String shape = matrix[r][13].getShape();
            for (int c=1; c<matrix[r].length; c++) {
                if(!shape.equals(matrix[r][c].getShape())) {
                    System.out.println(shape + " is not " + matrix[r][c].getShape()+"at"+ r +" " + c);
                    return false;
                }
                if(matrix[r][c].getCount()!=c+1) {
                    System.out.println(matrix[r][c].getCount() + "!=" + c+1 +"at"+ r +" " + c);
                    return false;
                }
            }
        }
        return true;
    }

    public void forceWin() {
        for(int r=0; r<matrix.length; r++) {
            String shape = matrix[r][13].getShape();
            for (int c=1; c<matrix[r].length; c++) {
                if(!shape.equals(matrix[r][c].getShape())) {
//                    System.out.println(shape + " is not " + matrix[r][c].getShape()+"at"+ r +" " + c);
                    matrix[r][c].setShape(shape);
                }
                if(matrix[r][c].getCount()!=c+1) {
//                    System.out.println(matrix[r][c].getCount() + "!=" + c+1 +"at"+ r +" " + c);
                    matrix[r][c].setCount(c+1);
                }
            }
        }
        for(int r=0; r<matrix.length; r++) {
            String shape = matrix[r][1].getShape();
            int count = 15;
            matrix[r][0].setCard(shape,count);
        }
    }
}

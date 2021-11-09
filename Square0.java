import java.awt.*;

public class Square0 extends FigureSuper {

    public Square0(int inputX, int inputY) {
        super(inputX, inputY);
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(xCoord, yCoord, 60, 60);

    }

    // If pressed mouse is in square, return true.
    public boolean ifClickInFigure(int x1, int y1) {
        return ((x1 >= xCoord) && (y1 >= yCoord) && (x1 < xCoord + 60) && (y1 < yCoord + 60));
    }

}

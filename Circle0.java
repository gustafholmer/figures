import java.awt.*;

public class Circle0 extends FigureSuper {

        final private int radius = 30; // unique for circle

        public Circle0(int inputX, int inputY) {
            super(inputX, inputY);
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillOval(xCoord, yCoord, radius*2, radius*2);
        }

        // If pressed mouse is in square, return true.
        public boolean ifClickInFigure(int x1, int y1) {
            int distancesquared = (x1 - (xCoord + 30)) * (x1 - (xCoord + 30)) + (y1 - (yCoord + 30)) * (y1 - (yCoord + 30));
            return distancesquared <= radius * radius;
        }
}


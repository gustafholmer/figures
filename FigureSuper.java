import java.awt.*;

abstract public class FigureSuper {
    int xCoord;
    int yCoord;
    int latestRelX = 0;
    int latestRelY = 0;
    int mouseBeganMomentX = 0;
    int mouseBeganMomentY = 0;

    // this constructor exists in all subclass of FigureSuper
    public FigureSuper(int inputX, int inputY) {
        xCoord = inputX;
        yCoord = inputY;

        if (latestRelX == 0) {
            latestRelX = inputX;
            latestRelY = inputY;
        }
    }

    // is used to return last location of object to be used in the copying phase in DrawArea
    public int getLastX() {
        return xCoord;
    }
    public int getLastY() {
        return yCoord;
    }

    // fills the shape. Is different in all subclassed figures
    abstract public void draw(Graphics g);

    // saves the mouse press for calculating the change of objects position
    public void mousePressFigure (int inputX, int inputY) {
        mouseBeganMomentX = inputX;
        mouseBeganMomentY = inputY;
    }

    // is different in all the subclassed figures as the shape area is different
    abstract public boolean ifClickInFigure(int x1, int y1);

    // Changes the position of figure. Calculates the relative coordinates
    public void changePositionFigure ( int intChangeX, int intChangeY) {
        xCoord = intChangeX - (mouseBeganMomentX - latestRelX);
        yCoord = intChangeY - (mouseBeganMomentY - latestRelY);
    }
}


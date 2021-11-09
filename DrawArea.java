import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//
//  Class which "drives" the program
//
class DrawArea extends JPanel  {

    // ArrayList to store the figure-objects location
    private ArrayList<FigureSuper> figureCollection =
            new ArrayList<>();

    public DrawArea() {
        setBackground(Color.GRAY);
        MouseListener0 ml = new MouseListener0(this); // connects drawarea with MouseListern object
        addMouseListener(ml);
        addMouseMotionListener(ml);
    }

    // draws new figures after user have clicked on draw area. It is also called when figure is released from mouse.
    public void addFigure(FigureSuper s) {
        figureCollection.add(0, s);
        Graphics g = getGraphics();
        s.draw(g);
    }

    // Checks if mousepress is in figure.
    public FigureSuper ifClickInFigureDrawVersion (int x, int y) {
        for (FigureSuper f1 : figureCollection) {
            if (f1.ifClickInFigure(x, y)) { // checks the figure
                // Transforms the objects z-index
                int index = figureCollection.indexOf(f1);
                figureCollection.remove(index);
                figureCollection.add(0, f1);
                return f1;
            }
        }
        return null;
    }

    // is connected to a change position method in figure superclass
    public void changePositon (FigureSuper sInput, int xInput, int yInput) {
        try {
        for (FigureSuper f1 : figureCollection) {
            if (f1 == sInput) {
                f1.changePositionFigure(xInput, yInput);
                repaint();
            }
        }
        } catch (Exception e){}
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Iterate list in reverse order to be able to draw the shapes so z-index is achieved
        for (int i = figureCollection.size() - 1; i >= 0; i--) {
            figureCollection.get(i).draw(g);
        }

    }

    // Method is used when user have released mouse,
    // in that way the figure object is deleted and a new one is added.
    public void removeFigure (FigureSuper s) {
        figureCollection.remove(s);
        repaint();
    }

    // when mouse is released with shape, this method removes the shape and creates a new one in its place
    public void mouseRelFigureDraw (FigureSuper sInput) {
        try {
            for (FigureSuper f1 : figureCollection) {
                if (f1 == sInput) {
                    FigureSuper s = new Square0(0, 0); // Var need to be assigned, else compiler error occur.

                    removeFigure(f1);
                    int getX = f1.getLastX();
                    int getY = f1.getLastY();
                    int index = figureCollection.indexOf(f1);

                    Class var1 = f1.getClass();
                    if (var1 == Square0.class) {
                        s = new Square0(getX, getY);
                    } else if (var1 == Circle0.class) {
                        s = new Circle0(getX, getY);
                    } else {
                        s = new Triangle0(getX, getY);
                    }
                    addFigure(s);
                    figureCollection.add(index, s);
                }
            }
        } catch (Exception e){};
    }

    // checks if mouse is in figure during mouse press
    public void mousePressFigureDraw (FigureSuper sInput, int inputX, int inputY) {
        for (FigureSuper f1 : figureCollection) {
            if (f1 == sInput) {
                f1.mousePressFigure(inputX, inputY);
            }
        }
    }

}

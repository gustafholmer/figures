import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class MouseListener0 extends MouseAdapter
        implements MouseMotionListener {

    DrawArea drawArea;

    FigureSuper choosen;

    public MouseListener0 (DrawArea a) {
        drawArea = a;
    }

    /*
     * mousePressed important for deciding if click is in shape. Starts the chain which moves all figures
     */
    public void mousePressed (MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        choosen = drawArea.ifClickInFigureDrawVersion(x, y);
        if (choosen != null) {
            drawArea.mousePressFigureDraw(choosen, x, y);
        }
    }

    public void mouseDragged (MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (choosen != null) {
            drawArea.changePositon(choosen, x, y);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (choosen != null) {
            drawArea.mouseRelFigureDraw(choosen);
        }
    }

    // creates a random shape figure
    public void mouseClicked (MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (choosen == null) {
            Random rand = new Random();
            int rand_int1 = rand.nextInt(3);

            if (rand_int1 == 0) {
                Square0 s = new Square0(x, y);
                drawArea.addFigure(s);
            } else if (rand_int1 == 1) {
                Circle0 c = new Circle0(x, y);
                drawArea.addFigure(c);
            } else {
                Triangle0 t = new Triangle0(x, y);
                drawArea.addFigure(t);
            }
        }
    }







}
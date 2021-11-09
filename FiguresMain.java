import javax.swing.*;

/*
*
* Main class
*
*           OBSERVE!!!
* Activates the drawarea where the the figures will turn up
* Click on the window area to generate random figures
*
 */
public class FiguresMain extends JFrame {
    public FiguresMain () {

        super("Figures programme");

        JPanel s = new DrawArea();

        add(s);
        setVisible(true);
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] arg) {
        new FiguresMain();
    }
}
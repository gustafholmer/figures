import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

class Triangle0 extends FigureSuper {

    // lists which stores all the coordiantes for the polygon
    ArrayList<Integer> xCoordArray1= new ArrayList<Integer>();
    ArrayList<Integer> yCoordArray1= new ArrayList<Integer>();

    public Triangle0(int inputX, int inputY) {
        super(inputX, inputY);
    }

    // convert Integer ArrayList to int[] array. Needed because of Polygons need for int[] as arguments
    public static int[] convertIntegers(ArrayList integers) {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

    // Fixes the triangle position with the x and y input from constructor
    public void adjustPosition () {
        for (int i = 0; i < 3; i++) {

            if (i == 0) {
                xCoordArray1.add(xCoord + 30);
                yCoordArray1.add(yCoord + 60 );
            } else if (i == 1) {
                xCoordArray1.add(xCoord - 30);
                yCoordArray1.add(yCoord + 60 );
            } else {
                xCoordArray1.add(xCoord);
                yCoordArray1.add(yCoord);
            }
        }
    }
    /*
     * method  is here more complex as triangle is a polygon
     */
    public void draw(Graphics g) {
        xCoordArray1.clear();
        yCoordArray1.clear();
        adjustPosition();
        g.setColor(Color.BLUE);
        g.fillPolygon(convertIntegers(xCoordArray1), convertIntegers(yCoordArray1), 3);
    }

    //----------------Code here after this point checks if click inside-----------------

    /* A utility function to calculate area of triangle
     formed by (x1, y1) (x2, y2) and (x3, y3) */
    static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+
                x3*(y1-y2))/2.0);
    }

    /* A function to check whether point P(x, y) lies
       inside the triangle formed by A(x1, y1),
       B(x2, y2) and C(x3, y3) */
    static boolean isInside(int x1, int y1, int x2,
                            int y2, int x3, int y3, int x, int y)
    {
        /* Calculate area of triangle ABC */
        double A = area (x1, y1, x2, y2, x3, y3);

        /* Calculate area of triangle PBC */
        double A1 = area (x, y, x2, y2, x3, y3);

        /* Calculate area of triangle PAC */
        double A2 = area (x1, y1, x, y, x3, y3);

        /* Calculate area of triangle PAB */
        double A3 = area (x1, y1, x2, y2, x, y);

        /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
    }

    /*
     * method is here more complex as triangle is a polygon
     * If pressed mouse is in triangle, return true.
     */
    public boolean ifClickInFigure(int x1, int y1) {
        int leftX =0, leftY=0, rightX=0, rightY=0, topX=0, topY=0;
        int counterX = 0;
        int counterY = 0;

        for (Integer int1 :  xCoordArray1) {
            if (counterX == 0) {
                leftX = int1;
            } else if (counterX == 1) {
                rightX = int1;
            } else {
                topX = int1;
            }
            counterX++;
        }

        for (Integer int1 :  yCoordArray1) {
            if (counterY == 0) {
                leftY = int1;
            } else if (counterY == 1) {
                rightY = int1;
            } else {
                topY = int1;
            }
            counterY++;
        }

        return isInside(leftX, leftY, rightX, rightY, topX, topY, x1, y1);
    }

}

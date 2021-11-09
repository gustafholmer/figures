# figures
A programming project using swing to practise object-oriented programming. Different shapes moves around in a window. This project was an assignment in a course about object-oriented programming.

# Author: Gustaf Holmer

# How to run the program:
Compile, then run FiguresMain.java. Click anywhere in the window that appears to create random shapes.

# Program structure:
I have organized the program that it has a total of six classes, one of which is an abstract class from which three subclasses inherit. These three subclasses are the figures: square, circle and triangle.

# FiguresMain.java
Is the main class that activates the program by creating "Drawarea" objects based on DrawArea.java and gives it a size and makes it visible. Not much else happens in this class.

# DrawArea.java
This class / object handles everything that goes on in the program and acts as a "bridge" between all objects. In this class there is an arrayList that saves all figure objects and their position. The most important methods here are addFigure () which ensures that a figure is created by mouse clicks in the box. This method is also activated when a figure is removed after mouse release and creates a copy of this figure at the same position. The paintcomponent () method paints all saved objects in the arraylist. This method is also called when the program requires that all figures need to be unpainted, which is done by all objects themselves. This repainting occurs when the user interacts with the program. The mouseRelFigureDraw () method is activated after the user releases the mouse after moving the figures around. It then removes the moved object and creates a new object in its place. This method must be modified if a new character is to be added to the program.

# MouseListener0.java
Used in DrawArea.java to record mouse clicks or mouse movements and send the data to the figures. The most important method here is: mouseclicked () which is activated when the user clicks on the box, it then creates randomized figures where the mouse is clicked. It is in this method that the user must modify if new characters are to be added to the program.

# FigureSuper.java
Is an abstract class extended by Triangle0 (), Square0 () and Circle0 (). It contains variables and methods inherited from the subclasses. But also abstract methods such as draw () and ifClickInFigure () which are defined in the subclasses due to the unique shape of the figures. The changePositionFigure () method is important for continuously calculating the new coordinates of the movements performed by the class.
Triangle0.java, Square0.java, Circle0.java All three inherit from FigureSuper.java. They all have unique implementations of the draw () and ifclickInfigure () methods. Triangle0.java is the figure that has the most own methods as the figure requires more code to calculate the correct area and more. The triangle was created using the class Polygon ().java.

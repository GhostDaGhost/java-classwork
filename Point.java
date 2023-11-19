/**
    @author Alexander Arizola
*/

// THIS CLASS IS USED TO STORE AND MANIPULATE THE LOCATION OF A POINT ON THE PLANE
public class Point {
    private double x;
    private double y;

    // CREATE FREE OF ARGUMENTS CONSTRUCTOR FOR CLASS, IT INITIALIZES THE 'X' AND 'Y' VALUES AUTOMATICALLY
    public Point() {
        this.x = 1.0;
        this.y = 1.0;
    }

    /**
        * CREATE ARGUMENT-REQUIRED CONSTRUCTOR FOR CLASS, IT TAKES PARAMETERS TO ASSIGN 'X' AND 'Y' VALUES MANUALLY
        * @param pX The new x-coordinate of the point.
        * @param pY The new y-coordinate of the point.
    */
    public Point(double pX, double pY) {
        this.x = pX;
        this.y = pY;
    }

    /**
        * GETTER FOR THE X-COORDINATE
        * @return The current x-coordinate of the point.
    */
    public double getX() {
        return x;
    }

    /**
        * GETTER FOR THE Y-COORDINATE
        * @return The current y-coordinate of the point.
    */
    public double getY() {
        return y;
    }

    /**
        * SETTER FOR THE X-COORDINATE
        * @param pX The new x-coordinate of the point.
    */
    public void setX(double pX) {
        this.x = pX;
    }

    /**
        * SETTER FOR THE Y-COORDINATE
        * @param pY The new x-coordinate of the point.
    */
    public void setY(double pY) {
        this.y = pY;
    }

    /**
        * THIS MOVES THE X-COORDINATE AND Y-COORDINATE OF A POINT
        * @param dx The amount to move the point along the x-axis.
        * @param dy The amount to move the point along the y-axis.
    */
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // THE METHOD TO ROTATE THE POINT BY 90 DEGREES CLOCKWISE AROUND THE ORIGIN
    public void rotate() {
        double oldX = this.x;
        this.x = this.y;
        this.y = -oldX;
    }
}

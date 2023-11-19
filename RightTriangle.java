/**
    @author Alexander Arizola
*/

// THIS CLASS REPRESENTS A RIGHT-ANGLED TRIANGLE
public class RightTriangle {
    private double legA;
    private double legB;

    // CREATE FREE OF ARGUMENTS CONSTRUCTOR FOR CLASS, IT INITIALIZES THE 'legA' AND 'legB' VALUES AUTOMATICALLY
    public RightTriangle() {
        this.legA = 1.0;
        this.legB = 1.0;
    }

    /**
        * CREATE ARGUMENT-REQUIRED CONSTRUCTOR FOR CLASS, IT TAKES PARAMETERS TO ASSIGN 'legA' AND 'legB' VALUES MANUALLY
        * @param pLegA The new length of legA.
        * @param pLegB The new length of legB.
    */
    public RightTriangle(double pLegA, double pLegB) throws IllegalArgumentException {
        if (legA <= 0 || legB <= 0) {
            throw new IllegalArgumentException("Legs cannot be zero or a negative number!");
        }

        // ASSIGN VARIABLES WITH NEW VALUES
        this.legA = pLegA;
        this.legB = pLegB;
    }

    /**
        * GETTER FOR 'legA' VALUE
        * @return The length of leg A.
    */
    public double getLegA() {
        return legA;
    }

    /**
        * GETTER FOR 'legB' VALUE
        * @return The length of leg B.
    */
    public double getLegB() {
        return legB;
    }

    /**
        * SETTER FOR 'legA' VALUE
        * @param pLegA The length of leg A.
        * @throws IllegalArgumentException If pLegA is 0 or negative.
    */
    public void setLegA(double pLegA) throws IllegalArgumentException {
        if (pLegA <= 0) {
            throw new IllegalArgumentException("Leg A cannot be zero or a negative number!");
        }

        // ASSIGN NEW VALUE TO VARIABLE
        this.legA = pLegA;
    }

    /**
        * SETTER FOR 'legB' VALUE
        * @param pLegB The length of leg A.
        * @throws IllegalArgumentException If pLegB is 0 or negative.
    */
    public void setLegB(double pLegB) throws IllegalArgumentException {
        if (pLegB <= 0) {
            throw new IllegalArgumentException("Leg B cannot be zero or a negative number!");
        }

        // ASSIGN NEW VALUE TO VARIABLE
        this.legB = pLegB;
    }

    /**
        * CALCULATES AND RETURNS HYPOTENUSE OF THE TRIANGLE.
        * @return The hypotenuse of the triangle.
    */
    public double getHypotenuse() {
        return Math.sqrt(this.legA * this.legA + this.legB * this.legB);
    }

    /**
        * CALCULATES AND RETURNS THE AREA OF THE RIGHT TRIANGLE.
        * @return The area of the right triangle.
    */
    public double getArea() {
        return 0.5 * this.legA * this.legB;
    }

    /**
        * CALCULATES AND RETURNS THE PERIMETER OF THE TRIANGLE.
        * @return The perimeter of the triangle.
    */
    public double getPerimeter() {
        return this.legA + this.legB + getHypotenuse();
    }

    /**
        * REPRESENTS OBJECT AS A STRING IN THE FOLLOWING EXAMPLE FORMAT: "legA = 3.0, legB = 4.0"
        * IT OVERRIDES THE CURRENT 'toString' FUNCTION.
        * @return A string representation of the right triangle.
    */

    @Override
    public String toString() {
        return "legA = " + legA + ", legB = " + legB;
    }
}

/**
 * This class represents a Point object in the first quadrant of a
 * Cartesian coordinate system.
 *
 * @author Shaked Kodman Kolran
 * @version 2-11-2023
 */
public class Point
{
    // declarations of constants and variables
    private int _x;
    private int _y;
    private final int DEFAULT_VALUE = 0;

    // declaration of constructor(s)

    /**
     * Constructor and initializes a new point at the given x and y coordinates.
     *
     * @param x the X coordinate of the new point
     * @param y the Y coordinate of the new point
     */
    public Point(int x, int y)
    {
        _x = Math.max(x, DEFAULT_VALUE);

        _y = (y >= DEFAULT_VALUE) ? y : DEFAULT_VALUE;
    }

    /**
     * Constructor and initializes a new point at the default coordinates.
     */
    public Point()
    {
        _x = 0;
        _y = 0;
    }

    /**
     * Copy constructor for Point.
     * Construct a point with the same coordinates as other point.
     *
     * @param other The point object from which to construct the new point
     */
    public Point(Point other)
    {
        if (other == null)
            return;

        _x = other._x;
        _y = other._y;
    }

    // declarations of methods

    /**
     * Moves the point by the given amount.
     * for x - deltaX
     * and for y - deltaY.
     * if one of the values given is not in the first quadrant, the point will not move.
     *
     * @param deltaX the amount to move in the x direction
     * @param deltaY the amount to move in the y direction
     */
    public void move(int deltaX, int deltaY)
    {
        if (_x + deltaX >= DEFAULT_VALUE && _y + deltaY >= DEFAULT_VALUE)
        {
            _x += deltaX;
            _y += deltaY;
        }
    } // End of method move

    /**
     * Moves the point by the given amount.
     * if one of the values given is not in the first quadrant, the point will not move.
     *
     * @param delta the amount to move in the x and y direction
     */
    public void move(int delta)
    {
        if (_x + delta >= DEFAULT_VALUE && _y + delta >= DEFAULT_VALUE)
        {
            _x += delta;
            _y += delta;
        }
    } // End of method move

    /**
     * Moves the point by the given amount.
     * if one of the values given is not in the first quadrant, the point will not move.
     *
     * @param delta the amount to move in the x and y direction
     */
    public void move(double delta)
    {
        if (_x + delta >= DEFAULT_VALUE && _y + delta >= DEFAULT_VALUE)
        {
            _x += delta;
            _y += delta;
        }
    } // End of method move

    /**
     * Moves the point by the given amount.
     * for x - deltaX
     * and for y - deltaY.
     * if one of the values given is not in the first quadrant, the point will not move.
     *
     * @param deltaX the amount to move in the x direction
     * @param deltaY the amount to move in the y direction
     */
    public void move(double deltaX, double deltaY)
    {
        if (_x + deltaX >= DEFAULT_VALUE && _y + deltaY >= DEFAULT_VALUE)
        {
            _x += deltaX;
            _y += deltaY;
        }
    } // End of method move

    /**
     * Prints the point coordinates in a format of (x, y).
     */
    public void printStatus()
    {
        System.out.println("(" + _x + ", " + _y + ")");
    }

    /**
     * checks if the given point is below this point.
     * @param other the point to check if it is below this point
     * @return true if the given point is below this point
     */
    public boolean isAbove(Point other)
    {
        return _y > other._y;
    }

    /**
     * checks if the given point is above this point.
     * @param other the point to check if it is above this point
     * @return true if the given point is above this point
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }

    /**
     * checks if the given point is left to this point.
     * @param other the point to check if it is left to this point
     * @return true if the given point is left to this point
     */
    public boolean isLeft(Point other)
    {
        return _x < other._x;
    }

    /**
     * checks if the given point is right to this point.
     * @param other the point to check if it is right to this point
     * @return true if the given point is right to this point
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    }

    /**
     * Calculates the distance between this point and the given point.
     * @param p the point to calculate the distance from
     * @return the distance between this point and the given point
     */
    public double distance(Point p)
    {
        return Math.sqrt(Math.pow(_x - p._x, 2) + Math.pow(_y - p._y, 2));
    }

    // getters and setters
    public int getX()
    {
        return _x;
    }

    public int getY()
    {
        return _y;
    }

    public void setX(int x)
    {
        if (x >= DEFAULT_VALUE)
            _x = x;
    } // End of method setX

    public void setY(int y)
    {
        if (y >= DEFAULT_VALUE)
            _y = y;
    } // End of method setY

    // overrides
    /**
     * Checks if the given point object is equal to this point object.
     * @param other the point to check equality with
     * @return true if the given point is equal to this point
     */
    public boolean equals(Point other)
    {
        return (_x == other._x) && (_y == other._y);
    } // End of method equals

    /**
     * Returns a string representation of this point.
     * @return a string representation of this point
     */
    public String toString()
    {
        return "(" + _x + ", " + _y + ")";
    } // End of method toString
} // End of class
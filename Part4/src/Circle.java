/**
 * This class represent a circle in the first quadrant of the Cartesian coordinate system.
 *
 * @author Shaked Kodman Kolran
 * @version 30-11-2023
 */
public class Circle
{
    private double _radius;
    private Point _center;
    public final int DEFAULT_RADIUS = 1;
    public final int MIN_VAL = 0;

    /**
     * Constructor for objects of class Circle. Construct a new circle with the specified radius and center point.
     * If the radius is negative the radius will be set to 1.
     * If the center is not in the first quadrant the center will be set to (0,0).
     *
     * @param x      The x coordinate of the center point
     * @param y      The y coordinate of the center point
     * @param radius The radius of the circle
     */
    public Circle(int x, int y, double radius)
    {
        _radius = (radius >= MIN_VAL) ? radius : DEFAULT_RADIUS;
        _center = new Point(x, y);
    }

    /**
     * Constructor for objects of class Circle. Construct a new circle with the specified radius and center point.
     * If the radius is negative the radius will be set to 1.
     * If the center is not in the first quadrant the center will be set to (0,0).
     *
     * @param center The center point of the circle
     * @param radius The radius of the circle
     */
    public Circle(Point center, double radius)
    {
        _radius = (radius >= MIN_VAL) ? radius : DEFAULT_RADIUS;
        _center = new Point(center); // copy constructor
    }

    /**
     * Copy constructor for Circle. Construct a circle with the same radius and center as other circle.
     *
     * @param other The circle object from which to construct the new circle
     */
    public Circle(Circle other)
    {
        if (other == null)
            return;

        _radius = other._radius;
        _center = new Point(other._center); // copy constructor
    }

    /**
     * Returns the radius of the circle.
     *
     * @return The radius of the circle
     */
    public double getRadius()
    {
        return _radius;
    }

    /**
     * Returns the center point of the circle.
     *
     * @return The center point of the circle
     */
    public Point getCenter()
    {
        return new Point(_center); // copy constructor
    }

    /**
     * Sets the radius of the circle.
     * If the radius is negative the radius will remain unchanged.
     *
     * @param r The new radius of the circle
     */
    public void setRadius(double r)
    {
        if (r >= MIN_VAL)
            _radius = r;
    }

    /**
     * Sets the center point of the circle.
     * If the center is not in the first quadrant the center will remain unchanged.
     *
     * @param p The new center point of the circle
     */
    public void setCenter(Point p)
    {
        if (p.getX() >= MIN_VAL && p.getY() >= MIN_VAL)
            _center = new Point(p); // copy constructor
    }

    /**
     * Returns the perimeter of the circle as a double.
     * @return The perimeter of the circle
     */
    public double perimeter()
    {
        return 2 * Math.PI * _radius;
    }

    /**
     * Returns the area of the circle as a double.
     * @return The area of the circle.
     */
    public double area()
    {
        return Math.PI * Math.pow(_radius, 2);
    }

    /**
     * Moves the circle by moving the center point.
     * @param deltaX The amount to move in the x direction
     * @param deltaY The amount to move in the y direction
     */
    public void move(double deltaX, double deltaY)
    {
        _center.move(deltaX, deltaY);
    }

    /**
     * Check if the circle is equal to another circle that has been given.
     * @param other the circle to check.
     * @return true if equals, false if not
     */
    public boolean equals(Circle other)
    {
        return ((_radius == other._radius) && (_center.equals(other._center)));
    }

    /**
     * checks if this circle area is larger than the other circle area.
     * @param other the circle to check if this circle area is larger than.
     * @return true if this circle's area is larger, false if not.
     */
    public boolean isLarger(Circle other)
    {
        return (getRadius() > other.getRadius());
    }

    /**
     * checks if a point given is inside the circle
     * @param p the point to check
     * @return true if the point is in the circle, false if it isn't
     */
    public boolean isInCircle(Point p)
    {
        return (_center.distance(p) <= _radius);
    }

    /**
     * returns a string representation of this circle.
     * @return string representation of this circle.
     */
    public String toString()
    {
        return "The center of the circle = " + _center.toString() + " and the radius = " + _radius;
    }
} // End of class Circle

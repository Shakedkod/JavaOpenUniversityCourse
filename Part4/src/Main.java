public class Main
{
    public static void main(String[] args)
    {
        Point p1 = new Point(10, 20);
        p1.printStatus();
        p1.move(5, 5);
        p1.printStatus();
        System.out.println("x = " + p1.getX());

        Point p2 = new Point(10, 20);
        p2.printStatus();
        p2.move(5.5, 5.5);
        p2.printStatus();
        System.out.println("x = " + p2.getX());

        Point p3 = new Point(10, 20);
        p3.printStatus();
        System.out.println("points are equal: " + p1.equals(p3));
    }
}
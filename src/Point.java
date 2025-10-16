// represents a point in 3d Cartesian space

public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setZ(double z) {
        this.z = z;
    }
    // check the precision stuff (doubles) with this stuff later
    public boolean compareWith(Point point) {
        if (this.x == point.x && this.y == point.y && this.z == point.z) {
            return true;
        } else {
            return false;
        }
    }
    // returns the String representation of this Point
    // for example, calling toString() would provide (x1.000, y2.000, z0.000)
    // rounded to 3 decimal places
    public String toString() {
        return ("(" + "x" + String.format("%.3f", this.x) +
                ", y" + String.format("%.3f", this.y) +
                ", z" + String.format("%.3f", this.z) + ")");
    }
}

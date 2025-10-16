// represents a Unit Vector in 3D Cartesian Space
// may have any direction, but must have magnitude 1

public class UnitVector {
    private double i;
    private double j;
    private double k;

    // check precision stuff later (within 0.0001)
    public UnitVector(double i, double j, double k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
}

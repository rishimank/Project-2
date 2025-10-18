// represents a Unit Vector in 3D Cartesian Space
// may have any direction, but must have magnitude 1

public class UnitVector {
    private double i;
    private double j;
    private double k;

    public UnitVector(double i, double j, double k) {
        this.i = i;
        this.j = j;
        this.k = k;
        double magnitude = Math.sqrt(i * i + j * j + k * k);
        if (magnitude == 0) { // if the magnitude is 0, all fields are 0
            this.i = 0;
            this.j = 0;
            this.k = 0;
            // confirming magnitude is equal to 1.0
        } else if (magnitude < 1.0001 && magnitude > .9999) {
            magnitude = 1.0;
        } else { // if magnitude isn't equal to 1, scale it
            this.i = i / magnitude;
            this.j = j / magnitude;
            this.k = k / magnitude;
        }
    }

    public UnitVector(Point start, Point end) {
        i = end.getX() - start.getX();
        j = end.getY() - start.getY();
        k = end.getZ() - start.getZ();
        // using getters because the fields x,y,z are private in the other class

        double magnitude = Math.sqrt(i * i + j * j + k * k);
        if (magnitude == 0) { // if the magnitude is 0, all fields are 0
            this.i = 0;
            this.j = 0;
            this.k = 0;
            // confirming magnitude is equal to 1.0
        } else if (magnitude < 1.0001 && magnitude > .9999) {
            magnitude = 1.0;
        } else { // if magnitude isn't equal to 1, scale it
            this.i = i / magnitude;
            this.j = j / magnitude;
            this.k = k / magnitude;


        }
    }
    // defines an invalid vector
    public UnitVector() {
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }
    public double getI() {
        return i;
    }
    public double getJ() {
        return j;
    } public double getK() {
        return k;
    }
    public boolean compareWith(UnitVector vector) {
        if ((this.i >= vector.i - 0.0001 && this.i <= vector.i + 0.0001) &&
                (this.j >= vector.j - 0.0001 && this.j <= vector.j + 0.0001) &&
                (this.k >= vector.k - 0.0001 && this.k <= vector.k + 0.0001)) {
            return true;
        } else {
            return false;
        }
    }
    public UnitVector crossProduct(UnitVector b) {
        i = this.j * b.k - this.k * b.j;
        j = this.k * b.i - this.i * b.k;
        k = this.i * b.j - this.j * b.i;

        double magnitude = Math.sqrt(i * i + j * j + k * k);
        if (magnitude == 0) { // if the magnitude is 0, all fields are 0
            i = 0;
            j = 0;
            k = 0;
            // confirming magnitude is equal to 1.0
        } else if (magnitude < 1.0001 && magnitude > .9999) {
            magnitude = 1.0;
        } else { // if magnitude isn't equal to 1, scale it
            i = i / magnitude;
            j = j / magnitude;
            k = k / magnitude;

        }
        return new UnitVector(i, j, k);
    }
    // returns string representation of this UnitVector
    // review this section

    public String toString() {
        if (Math.abs(i) <= 0.0001 && Math.abs(j) <= 0.0001 && Math.abs(k) <= 0.0001) {
            return "<InvalidUnitVector>";
        }
        String stringI = String.format("%.3f", i) + "i";
        String stringJ = String.format("%.3f", j) + "j";
        String stringK = String.format("%.3f", k) + "k";
        return "<" + stringI + "," + stringJ + "," + stringK + ">";
    }
}

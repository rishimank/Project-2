public class Triangle {
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;
    private UnitVector surfaceNormal;

    public Triangle (Point vertA, Point vertB, Point vertC) {
        this.vertexA = vertA;
        this.vertexB = vertB;
        this.vertexC = vertC;
        UnitVector AB = new UnitVector(vertexA, vertexB);
        UnitVector AC = new UnitVector(vertexA, vertexC);
        this.surfaceNormal = AB.crossProduct(AC);
    }

    public Triangle() {
        this.vertexA = new Point(0.000, 0.000, 0.000);
        this.vertexB = new Point(0.000, 0.000, 0.000);
        this.vertexC = new Point(0.000, 0.000, 0.000);
        this.surfaceNormal = new UnitVector(0.000, 0.000, 0.000);
    }

    public Point getVertexA() {
        return vertexA;
    }

    public Point getVertexB() {
        return vertexB;
    }

    public Point getVertexC() {
        return vertexC;
    }
    public UnitVector getSurfaceNormal() {
        return surfaceNormal;
    }
    // returns an array of points representing this Triangle
    public Point[] getVertices() {
        return new Point[]{vertexA, vertexB, vertexC};
    }

    public boolean compareWith(Triangle triangle) {
        double precision = 0.0001;
        if (
                Math.abs(this.vertexA.getX() - triangle.vertexA.getX()) <= precision &&
                        Math.abs(this.vertexA.getY() - triangle.vertexA.getY()) <= precision &&
                        Math.abs(this.vertexA.getZ() - triangle.vertexA.getZ()) <= precision &&

                        Math.abs(this.vertexB.getX() - triangle.vertexB.getX()) <= precision &&
                        Math.abs(this.vertexB.getY() - triangle.vertexB.getY()) <= precision &&
                        Math.abs(this.vertexB.getZ() - triangle.vertexB.getZ()) <= precision &&

                        Math.abs(this.vertexC.getX() - triangle.vertexC.getX()) <= precision &&
                        Math.abs(this.vertexC.getY() - triangle.vertexC.getY()) <= precision &&
                        Math.abs(this.vertexC.getZ() - triangle.vertexC.getZ()) <= precision &&

                        Math.abs(this.surfaceNormal.getI() - triangle.surfaceNormal.getI()) <= precision &&
                        Math.abs(this.surfaceNormal.getJ() - triangle.surfaceNormal.getJ()) <= precision &&
                        Math.abs(this.surfaceNormal.getK() - triangle.surfaceNormal.getK()) <= precision
        ) {
            return true;
        } else {
            return false;
        }
    }
    // returns the String representation of this Triangle
    public String toString() {
        if (vertexA.equals(vertexB) || vertexA.equals(vertexC) || vertexB.equals(vertexC)) {
            return "[InvalidTriangle]";
        }

        // Check if surfaceNormal is invalid (all zero components)
        if (surfaceNormal.getI() == 0 && surfaceNormal.getJ() == 0 && surfaceNormal.getK() == 0) {
            return "[InvalidTriangle]";
        }

        return "[A" + vertexA.toString() +
                "; B" + vertexB.toString() +
                "; C" + vertexC.toString() +
                "; N<" + String.format("%.3f", surfaceNormal.getI()) + "i, " +
                String.format("%.3f", surfaceNormal.getJ()) + "j, " +
                String.format("%.3f", surfaceNormal.getK()) + "k>]";
    }

}
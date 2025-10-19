// represents a single face of a cube in 3D cartesian space
// comprised of 2 Triangles that share 2 Vertices (Points)
// & have identical Surface Normals (UnitVectors point in same direction)
// review logic in this class
public class Face {
    private Triangle[] mesh; // array of Triangles to make this Face (bounded square)
    private UnitVector surfaceNormal; // surface normal of this Face

    public Face (Triangle one, Triangle two) {
        mesh = new Triangle[] {one, two};
        int sharedVertices = 0;

        if (one.getVertexA().equals(two.getVertexA()) ||
                one.getVertexA().equals(two.getVertexB()) ||
                one.getVertexA().equals(two.getVertexC())) {
            sharedVertices++;
        }

        if (one.getVertexB().equals(two.getVertexA()) ||
                one.getVertexB().equals(two.getVertexB()) ||
                one.getVertexB().equals(two.getVertexC())) {
            sharedVertices++;
        }

        if (one.getVertexC().equals(two.getVertexA()) ||
                one.getVertexC().equals(two.getVertexB()) ||
                one.getVertexC().equals(two.getVertexC())) {
            sharedVertices++;
        }

        // Check if surface normals are equal
        boolean sameNormal =
                one.getSurfaceNormal().getI() == two.getSurfaceNormal().getI() &&
                        one.getSurfaceNormal().getJ() == two.getSurfaceNormal().getJ() &&
                        one.getSurfaceNormal().getK() == two.getSurfaceNormal().getK();

        if (sharedVertices >= 2 && sameNormal) {
            mesh = new Triangle[]{one, two};
            this.surfaceNormal = one.getSurfaceNormal();
        }
        else {
            mesh = new Triangle[]{new Triangle(), new Triangle()};
            this.surfaceNormal = new UnitVector(0.000, 0.000, 0.000);
        }
    }
    public Face() {
        // each triangle should be set to Triangle
        mesh = new Triangle[]{new Triangle(), new Triangle()};
        // unit vector should be set to invalid
        this.surfaceNormal = new UnitVector(0.000, 0.000, 0.000);
    }
    public Triangle[] getMesh() {
        return mesh;
    }

    public UnitVector getSurfaceNormal() {
        return surfaceNormal;
    }

    public boolean compareWith(Face face) {
            double precision = 0.0001;

            // Get the triangle arrays for both faces
            Triangle[] otherMesh = face.getMesh();

            // Loop through both triangles (assuming exactly 2 triangles per face)
            for (int t = 0; t < 2; t++) {
                Triangle thisTriangle = this.mesh[t];
                Triangle otherTriangle = otherMesh[t];

                // Compare vertices A, B, C
                if (Math.abs(thisTriangle.getVertexA().getX() - otherTriangle.getVertexA().getX()) > precision ||
                        Math.abs(thisTriangle.getVertexA().getY() - otherTriangle.getVertexA().getY()) > precision ||
                        Math.abs(thisTriangle.getVertexA().getZ() - otherTriangle.getVertexA().getZ()) > precision ||

                        Math.abs(thisTriangle.getVertexB().getX() - otherTriangle.getVertexB().getX()) > precision ||
                        Math.abs(thisTriangle.getVertexB().getY() - otherTriangle.getVertexB().getY()) > precision ||
                        Math.abs(thisTriangle.getVertexB().getZ() - otherTriangle.getVertexB().getZ()) > precision ||

                        Math.abs(thisTriangle.getVertexC().getX() - otherTriangle.getVertexC().getX()) > precision ||
                        Math.abs(thisTriangle.getVertexC().getY() - otherTriangle.getVertexC().getY()) > precision ||
                        Math.abs(thisTriangle.getVertexC().getZ() - otherTriangle.getVertexC().getZ()) > precision
                ) {
                    return false;
                }

                // Compare surface normals
                UnitVector thisNormal = thisTriangle.getSurfaceNormal();
                UnitVector otherNormal = otherTriangle.getSurfaceNormal();

                if (Math.abs(thisNormal.getI() - otherNormal.getI()) > precision ||
                        Math.abs(thisNormal.getJ() - otherNormal.getJ()) > precision ||
                        Math.abs(thisNormal.getK() - otherNormal.getK()) > precision
                ) {
                    return false;
                }
            }

            // If all comparisons passed
            return true;
        }

    public String toString() {

    }

    }



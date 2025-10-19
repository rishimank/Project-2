// represents a single face of a cube in 3D cartesian space
// comprised of 2 Triangles that share 2 Vertices (Points)
// & have identical Surface Normals (UnitVectors point in same direction)
// review logic in this class
public class Face {
    private Triangle[] mesh;
    private UnitVector surfaceNormal;

    // Constructor with 2 triangles
    public Face(Triangle one, Triangle two) {
        int sharedVertices = 0;

        // Count shared vertices using for loops
        for (Point p1 : one.getVertices()) {
            for (Point p2 : two.getVertices()) {
                if (p1.compareWith(p2)) {
                    sharedVertices++;
                }
            }
        }

        // Check if surface normals are equal
        boolean sameNormal = one.getSurfaceNormal().compareWith(two.getSurfaceNormal());

        // Assign fields based on instructions
        if (sharedVertices >= 2 && sameNormal) {
            mesh = new Triangle[]{one, two};
            surfaceNormal = one.getSurfaceNormal();
        } else {
            mesh = new Triangle[]{new Triangle(), new Triangle()};
            surfaceNormal = new UnitVector(); // invalid vector
        }
    }

    // Default constructor (invalid face)
    public Face() {
        mesh = new Triangle[]{new Triangle(), new Triangle()};
        surfaceNormal = new UnitVector(); // invalid vector
    }

    // Get the triangle mesh
    public Triangle[] getMesh() {
        return mesh;
    }

    // Get the surface normal
    public UnitVector getSurfaceNormal() {
        return surfaceNormal;
    }

    // Compare this face with another face
    public boolean compareWith(Face face) {
        return mesh[0].compareWith(face.mesh[0]) &&
                mesh[1].compareWith(face.mesh[1]) &&
                surfaceNormal.compareWith(face.surfaceNormal);
    }

    // String representation
    public String toString() {
        if (mesh[0].toString().equals("[InvalidTriangle]") ||
                mesh[1].toString().equals("[InvalidTriangle]")) {
            return "{InvalidFace}";
        }

        return "{F" +
                mesh[0].toString() + " " +
                mesh[1].toString() + " " +
                "N<" + String.format("%.3f", surfaceNormal.getI()) + "i, " +
                String.format("%.3f", surfaceNormal.getJ()) + "j, " +
                String.format("%.3f", surfaceNormal.getK()) + "k>}";
    }
}

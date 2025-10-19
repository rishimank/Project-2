// represents a cube in 3d cartesian space
// comprised of 6 Faces (squares)
// each face shares an edge (has 2 common vertices) with 4 other faces
// faces that don't share an edge have opposite surface normal vectors
// one face has the inverse UnitVector of the other
public class Cube {
    private Face[] mesh;

    public Cube (Face one, Face two, Face three, Face four, Face five, Face six) {
        mesh = new Face[]{one, two, three, four, five, six};
        boolean valid = true;

        // Check for duplicate faces
        for (int i = 0; i < mesh.length; i++) {
            for (int j = i + 1; j < mesh.length; j++) {
                if (mesh[i].compareWith(mesh[j])) {
                    valid = false;
                    break;
                }
            }
            if (!valid) break;
        }

        // Check that each face shares exactly one edge with 4 other faces
        if (valid) {
            for (int i = 0; i < mesh.length; i++) {
                int sharedEdges = 0;
                for (int j = 0; j < mesh.length; j++) {
                    if (i != j) {
                        int sharedVertices = 0;
                        Point[] vertsI = mesh[i].getMesh()[0].getVertices();
                        Point[] vertsJ0 = mesh[j].getMesh()[0].getVertices();
                        Point[] vertsJ1 = mesh[j].getMesh()[1].getVertices();

                        // Count shared vertices with triangle 0
                        for (Point pi : vertsI) {
                            for (Point pj : vertsJ0) {
                                if (pi.compareWith(pj)) sharedVertices++;
                            }
                            for (Point pj : vertsJ1) {
                                if (pi.compareWith(pj)) sharedVertices++;
                            }
                        }

                        if (sharedVertices == 2) sharedEdges++;
                    }
                }
                if (sharedEdges != 4) {
                    valid = false;
                    break;
                }
            }
        }

        // Check that opposed faces have opposite surface normals
        if (valid) {
            for (int i = 0; i < mesh.length; i++) {
                for (int j = i + 1; j < mesh.length; j++) {
                    int sharedVertices = 0;
                    Point[] vertsI = mesh[i].getMesh()[0].getVertices();
                    Point[] vertsJ0 = mesh[j].getMesh()[0].getVertices();
                    Point[] vertsJ1 = mesh[j].getMesh()[1].getVertices();

                    for (Point pi : vertsI) {
                        for (Point pj : vertsJ0) if (pi.compareWith(pj)) sharedVertices++;
                        for (Point pj : vertsJ1) if (pi.compareWith(pj)) sharedVertices++;
                    }

                    if (sharedVertices == 0) { // opposed faces
                        UnitVector normalI = mesh[i].getSurfaceNormal();
                        UnitVector normalJ = mesh[j].getSurfaceNormal();
                        if (!(normalI.getI() == -normalJ.getI() &&
                                normalI.getJ() == -normalJ.getJ() &&
                                normalI.getK() == -normalJ.getK())) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (!valid) break;
            }
        }

        // Invalidate all faces if any check failed
        if (!valid) {
            for (int i = 0; i < mesh.length; i++) {
                mesh[i] = new Face();
            }
        }
    }

    public Face[] getMesh() {
        return mesh;
    }
}



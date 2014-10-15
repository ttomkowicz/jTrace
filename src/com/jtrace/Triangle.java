package com.jtrace;

public class Triangle extends Object3d {

    private Vec3[] vert;

    public Triangle(Vec3[] vertices, Vec3 dColor, double reflect){
        super(dColor, reflect);
        vert = new Vec3[3];
        vert[0] = vertices[0];
        vert[1] = vertices[1];
        vert[2] = vertices[2];
    }

    // algorytm Möller'a–Trumbore'a
    public boolean intersect(Ray r){
        Vec3 edge1 = new Vec3(0.);
        Vec3 edge2 = new Vec3(0.);
        Vec3 tvec = new Vec3(0.);
        Vec3 pvec = new Vec3(0.);
        Vec3 qvec = new Vec3(0.);
        double det = 0.;
        double invDet = 0.;

        Algebra.sub(edge1, vert[1], vert[0]);
        Algebra.sub(edge2, vert[2], vert[0]);

        Algebra.cross(pvec, r.getDirection(), edge2);
        Algebra.dot(det, edge1, pvec);

        return false;
    }
}

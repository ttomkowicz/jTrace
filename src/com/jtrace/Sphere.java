package com.jtrace;

public class Sphere extends Object3d{

    //  == POLA ==
    private Vec3 center;
    private double radius;
    private double radSqr;


    //  == KONSTRUKTORY ==
    public Sphere(Vec3 center, double radius, Vec3 dColor, double reflect){
        super(dColor, reflect);
        this.center = center;
        this.radius = radius;
        radSqr = radius * radius;
    }


    //  == GET / SET ==
    public Vec3 getCenter() {
        return center;
    }
    public void setCenter(Vec3 center) {
        this.center = center;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Vec3 getColor() {
        return super.getdColor();
    }
    public void setColor(Vec3 color) {
        super.setdColor(color);
    }

    //  == METODY ==
    public boolean intersect(Ray r){
        double A = r.getDirection().dot(r.getDirection());
        //System.out.println("A = " + A);
        double B = r.getDirection().multiply(2.).dot(r.getOrigin().minus(getCenter()));
        //System.out.println("B = " + B);
        double C = r.getOrigin().minus(getCenter()).dot(r.getOrigin().minus(getCenter())) - radSqr;
        //System.out.println("C = " + C);

        double delta = B*B - 4*A*C;
       // System.out.println("delta = " + delta);
        if (delta < 0.){
            return false;
        }
        if (delta == 0.){
            r.setT(-B / (2*A));
            r.setIntPt((r.getT()));
            //System.out.println("t = " + r.getT());
            //System.out.println("intPt = [" + r.getIntPt().getX() + ", " + r.getIntPt().getY() + ", " + r.getIntPt().getZ() + "]");
            return true;
        }
        double x0 = (-B - Math.sqrt(delta)) / (2*A);
        double x1 = (-B + Math.sqrt(delta)) / (2*A);
        if (x0 < 0. && x1 < 0.) return false;
        r.setT(x0 < x1 ? x1 : x0);
        //System.out.println("t = " + r.getT());
        r.setIntPt(r.getT());
        //System.out.println("intPt = [" + r.getIntPt().getX() + ", " + r.getIntPt().getY() + ", " + r.getIntPt().getZ() + "]");
        return true;
    }
}

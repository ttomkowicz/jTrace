package com.jtrace;

public class Ray {

    //  == POLA ==
    private Vec3 origin;
    private Vec3 direction;
    private double t;
    private Vec3 intPt;

    //  == KONSTRUKTORY ==
    public Ray(Vec3 o, Vec3 d){
        origin = o;
        direction = d.normalize();
        t = Double.POSITIVE_INFINITY;
        intPt = new Vec3();
    }

    //  == GET / SET ==
    public Vec3 getOrigin() {
        return origin;
    }
    public void setOrigin(Vec3 origin) {
        this.origin = origin;
    }
    public Vec3 getDirection() {
        return direction;
    }
    public void setDirection(Vec3 direction) {
        this.direction = direction;
    }
    public double getT() {
        return t;
    }
    public void setT(double t) {
        this.t = t;
    }
    public Vec3 getIntPt() {return intPt;}
    public void setIntPt(double t){this.intPt = origin.plus(direction.multiply(t));}


}

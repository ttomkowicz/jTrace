package com.jtrace;

public class Plane extends Object3d {

    private Vec3 width, height;

    public Plane(Vec3 width, Vec3 height, Vec3 dColor, double reflect){
        super(dColor, reflect);
        this.width = width;
        this.height = height;
    }

    public boolean intersect(Ray r){

        return false;
    }
}

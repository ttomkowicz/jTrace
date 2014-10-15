package com.jtrace;

public class Object3d {

    private Vec3 dColor;
    private Vec3 center;
    private double reflect;

    public Object3d(Vec3 center, Vec3 dColor, double reflect){
        this.center = center;
        this.dColor = dColor;
        this.reflect = reflect;
    }

    public Vec3 getCenter() {
        return center;
    }

    public void setCenter(Vec3 center) {
        this.center = center;
    }

    public Vec3 getdColor() {
        return dColor;
    }

    public void setdColor(Vec3 dColor) {
        this.dColor = dColor;
    }

    public double getReflect() {
        return reflect;
    }

    public void setReflect(double reflect) {
        this.reflect = reflect;
    }
}

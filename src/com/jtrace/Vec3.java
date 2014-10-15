package com.jtrace;

import java.lang.*;

public class Vec3 {
    private double x, y, z;

    public Vec3(){
        x = 0.;
        y = 0.;
        z = 0.;
    }
    public Vec3(double n){
        x = n;
        y = n;
        z = n;
    }
    public Vec3(double a, double b, double c){
        x = a;
        y = b;
        z = c;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }

    public double length(){ return Math.sqrt(x*x + y*y + z*z); }
    public Vec3 normalize(){
        double invLen = 1/length();
        return new Vec3(x*invLen, y*invLen, z*invLen);
    }
    public double dot(Vec3 v){
        return x*v.getX() + y*v.getY() + z*v.getZ();
    }
    public Vec3 cross(Vec3 v){ return new Vec3(y*v.z - z*v.y, z*v.x - x*v.z, x*v.y - y*v.x); }
    public Vec3 plus(Vec3 v) { return new Vec3(x+v.x, y+v.y, z+v.z); }
    public Vec3 minus(Vec3 v){
        return new Vec3(x-v.getX(), y-v.getY(), z-v.getZ());
    }
    public Vec3 multiply(double n){
        return new Vec3(x*n, y*n, z*n);
    }

    @Override
    public String toString() {
        return "Vec3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}

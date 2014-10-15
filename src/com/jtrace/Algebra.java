package com.jtrace;

public class Algebra {

    public static void sub(Vec3 dest, Vec3 v1, Vec3 v2){
        dest.setX(v1.getX() - v2.getX());
        dest.setY(v1.getY() - v2.getY());
        dest.setZ(v1.getZ() - v2.getZ());
    }

    public static void cross(Vec3 dest, Vec3 v1, Vec3 v2){
        dest.setX(v1.getY()*v2.getZ() - v1.getZ()*v2.getY());
        dest.setY(v1.getZ()*v2.getX() - v1.getX()*v2.getZ());
        dest.setZ(v1.getX()*v2.getY() - v1.getY()*v2.getX());
    }

    public static void dot(double dest, Vec3 v1, Vec3 v2){
        dest = v1.getX()*v2.getX() + v1.getY()*v2.getY() + v1.getZ()*v1.getZ();
    }
}

package com.jtrace;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    //public static Vec3 color = new Vec3(0.);
    public static Vec3 pixCol = new Vec3(0.);

    public static void trace(Sphere s, Ray r){
        if(s.intersect(r)){
            pixCol.setX(s.getColor().getX());
            pixCol.setY(s.getColor().getY());
            pixCol.setZ(s.getColor().getZ());
            return;
            //System.out.println(color.toString());
        }
        pixCol.setX(.15);
        pixCol.setY(.15);
        pixCol.setZ(.15);
    }

    public static void main(String[] args) {

        int width = 100;
        int height = 100;
        int red, green, blue, col;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        File file = new File("Rendered.png");
        Sphere s = new Sphere(new Vec3(0., 0, 3.), .33, new Vec3(0.3, 0.6, 0.9), 0.);
        Ray r = new Ray(new Vec3(0.), new Vec3(0.));

        long start = System.currentTimeMillis();
        for (int i=0; i<width-1; i++){
            for (int j=0; j<height-1; j++){
                double x = -Math.tan(Math.toRadians(15.))+j*2*(Math.tan(Math.toRadians(15.))/width);
                double y = -Math.tan(Math.toRadians(15.))+i*2*(Math.tan(Math.toRadians(15.))/height);
                r.setDirection(new Vec3(x, y, 1));
                trace(s, r);
                red = (int)(pixCol.getX() * 255);
                green = (int)(pixCol.getY()*255);
                blue = (int)(pixCol.getZ()*255);
                col = (red << 16) | (green << 8) | blue;
                img.setRGB(j, i, col);
            }

        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(diff + "ms elapsed");
        try {
            ImageIO.write(img, "PNG", file);
        } catch (IOException ex){
            ex.printStackTrace();
        }

        //System.out.println(s.intersect(r));
        //System.out.println("intPt = [" + r.getIntPt().getX() + ", " + r.getIntPt().getY() + ", " + r.getIntPt().getZ() + "]");
    }
}

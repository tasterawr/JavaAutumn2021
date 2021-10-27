package org.loktevik;

import java.util.Random;

public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
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

    public double getLength(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double getScalarProduct(Vector vector){
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public Vector getCrossProduct(Vector vector){
        double resultX = y * vector.z - z * vector.y;
        double resultY = z * vector.x - x * vector.z;
        double resultZ = x * vector.y - y * vector.x;

        return new Vector(resultX, resultY, resultZ);
    }

    public double getAngle(Vector vector){
        double scalarProduct = getScalarProduct(vector);

        return scalarProduct / getLength() * vector.getLength();
    }

    public Vector getVectorSum(Vector vector){
        double resultX = x + vector.x;
        double resultY = y + vector.y;
        double resultZ = z + vector.z;

        return new Vector(resultX, resultY, resultZ);
    }

    public Vector getVectorDifference(Vector vector){
        double resultX = x - vector.x;
        double resultY = y - vector.y;
        double resultZ = z - vector.z;

        return new Vector(resultX, resultY, resultZ);
    }

    public static Vector[] getRandomVectors(int n){
        Vector[] vectors = new Vector[n];

        Random random = new Random(47);
        for (int i = 0; i<n; i++){
            vectors[i] = new Vector(random.nextDouble(), random.nextDouble(), random.nextDouble());
        }

        return vectors;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

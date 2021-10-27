package org.loktevik;

public class Main {
    public static void main(String[] args) {
        Vector[] vectors = Vector.getRandomVectors(5);

        for (Vector v : vectors){
            System.out.println(v);
        }
        System.out.println();

        Vector vector = new Vector(4, 5.1, 2);
        Vector vector1 = new Vector(0.3, 2.6, 7);

        System.out.println("Вектор 1: " + vector);
        System.out.println("Длина: " + vector.getLength() + "\n");

        System.out.println("Вектор 2: " + vector1);
        System.out.println("Длина: " + vector1.getLength() + "\n");

        System.out.println("Скалярное произведение: " + vector.getScalarProduct(vector1));
        System.out.println("Векторное произведение: " + vector.getCrossProduct(vector1));
        System.out.println("Сумма векторов: " + vector.getVectorSum(vector1));
        System.out.println("Разность векторов: " + vector.getVectorDifference(vector1));
        System.out.println("Угол между векторами: " + vector.getAngle(vector1));
    }
}

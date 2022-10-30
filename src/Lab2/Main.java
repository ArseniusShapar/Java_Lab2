package Lab2;

public class Main {
    public static void main(String[] args) {
        double[][] array1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        float[][] array2 = {
                {1, 0.5f, 1.2f},
                {2, -1, 3.4f},
                {3, -2, 4.5f}};
        Double[][] array3 = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}};
        int[][] array4 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        ImmutableMatrix matrix = new ImmutableMatrix(array3);
        matrix.print();



    }
}
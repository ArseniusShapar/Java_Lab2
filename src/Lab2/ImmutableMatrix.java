package Lab2;

import java.util.Scanner;

public final class ImmutableMatrix extends Matrix {
    public ImmutableMatrix() {
        super();
    }

    public ImmutableMatrix(int height, int width) {
        super(height, width);
    }

    public ImmutableMatrix(double[][] array) {
        super(array);
    }

    public ImmutableMatrix(float[][] array) {
        super(array);
    }

    public ImmutableMatrix(int[][] array) {
        super(array);
    }

    public ImmutableMatrix(short[][] array) {
        super(array);
    }

    public ImmutableMatrix(long[][] array) {
        super(array);
    }

    public ImmutableMatrix(byte[][] array) {
        super(array);
    }

    public <T extends Number> ImmutableMatrix(T[][] array) {
        super(array);
    }

    public ImmutableMatrix(Matrix matrix) {
        super(matrix);
    }

    @Override
    public double[] getRow(int i) {
        int width = getDimension().second;
        double[] row = new double[width];
        System.arraycopy(super.getRow(i), 0, row, 0, width);
        return row;
    }

    @Override
    public double[][] getArray() {
        return secureCopy(super.getArray());
    }

    @Override
    public ImmutableMatrix fillMatrix() {
        int height = getDimension().first;
        int width = getDimension().second;
        double[][] array = getArray();
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.printf("matrix[%d][%d] = ", i, j);
                array[i][j] = in.nextFloat();
            }
        }

        return new ImmutableMatrix(array);
    }

    @Override
    public ImmutableMatrix round() {
        Matrix matrix = new Matrix(this);
        matrix.round();
        return new ImmutableMatrix(matrix);
    }

    @Override
    public ImmutableMatrix toUpperTriangle() {
        int height = getDimension().first;
        int width = getDimension().second;
        double[][] array = getArray();

        if (height != width) throw new IllegalArgumentException("Matrix are not square");

        for (int i = 0; i < height; i++) {
            for (int j = i + 1; j < height; j++) {
                subtractRows(array, j, i, array[j][i] / array[i][i]);
            }
        }

        return new ImmutableMatrix(array);
    }

    @Override
    public ImmutableMatrix toLowerTriangle() {
        int height = getDimension().first;
        int width = getDimension().second;
        double[][] array = getArray();

        if (height != width) throw new IllegalArgumentException("Matrix are not square");

        for (int i = height - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                subtractRows(array, j, i, array[j][i] / array[i][i]);
            }
        }

        return new ImmutableMatrix(array);
    }

    private void subtractRows(double[][] array, int i, int j, double a) {
        for (int k = 0; k < array[0].length; k++) array[i][k] -= a * array[j][k];
    }

}

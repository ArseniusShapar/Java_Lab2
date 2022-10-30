package Lab2;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix implements IMatrix {
    private final int height;
    private final int width;
    private final double[][] array;

    public Matrix() {
        height = 0;
        width = 0;
        array = new double[0][0];
    }

    public Matrix(int height, int width) {
        this.height = height;
        this.width = width;
        array = new double[height][width];
    }

    public Matrix(double[][] array) {
        height = array.length;
        width = array[0].length;
        this.array = secureCopy(array);
    }

    public Matrix(float[][] array) {
        height = array.length;
        width = array[0].length;
        this.array = new double[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.array[i][j] = array[i][j];
            }
        }
    }

    public Matrix(int[][] array) {
        height = array.length;
        width = array[0].length;
        this.array = new double[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.array[i][j] = array[i][j];
            }
        }
    }

    public Matrix(short[][] array) {
        height = array.length;
        width = array[0].length;
        this.array = new double[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.array[i][j] = array[i][j];
            }
        }
    }

    public Matrix(long[][] array) {
        height = array.length;
        width = array[0].length;
        this.array = new double[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.array[i][j] = array[i][j];
            }
        }
    }

    public Matrix(byte[][] array) {
        height = array.length;
        width = array[0].length;
        this.array = new double[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.array[i][j] = array[i][j];
            }
        }
    }

    public <T extends Number> Matrix(T[][] array) {
        height = array.length;
        width = array[0].length;
        this.array = arrayToDouble(array);
    }

    public Matrix(Matrix matrix) {
        height = matrix.height;
        width = matrix.width;
        array = secureCopy(matrix.array);
    }

    private <T extends Number> double[][] arrayToDouble(T[][] array) {
        int height = array.length;
        int width = array[0].length;
        double[][] doubleArray = new double[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                doubleArray[i][j] = array[i][j].doubleValue();
            }
        }
        return doubleArray;
    }

    protected double[][] secureCopy(double[][] array) {
        double[][] copyArray = new double[height][width];
        for (int i = 0; i < height; i++) {
            System.arraycopy(array[i], 0, copyArray[i], 0, width);
        }
        return copyArray;
    }

    public Pair<Integer> getDimension() {
        return new Pair<>(height, width);
    }

    public double getElement(int i, int j) {
        return array[i][j];
    }

    public double[] getRow(int i) {
        return array[i];
    }

    public double[] getColumn(int j) {
        if (height == 0 || width == 0) throw new ArrayIndexOutOfBoundsException("Index 0 out of bounds for length 0");

        double[] column = new double[height];
        for (int i = 0; i < height; i++) column[i] = array[i][j];
        return column;
    }

    public double[][] getArray() {
        return array;
    }

    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public Matrix fillMatrix() {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.printf("matrix[%d][%d] = ", i, j);
                array[i][j] = in.nextDouble();
            }
        }
        return this;
    }

    public Matrix round() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                array[i][j] = (double) Math.round(array[i][j] * 100) / 100;
            }
        }
        return this;
    }

    public static Matrix identityMatrix(int n) {
        Matrix matrix = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            matrix.array[i][i] = 1;
        }

        return matrix;
    }

    public Matrix toUpperTriangle() {
        if (height != width) throw new IllegalArgumentException("Matrix are not square");

        for (int i = 0; i < height; i++) {
            for (int j = i + 1; j < height; j++) {
                subtractRows(j, i, array[j][i] / array[i][i]);
            }
        }
        return this;
    }

    public Matrix toLowerTriangle() {
        if (height != width) throw new IllegalArgumentException("Matrix are not square");

        for (int i = height - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                subtractRows(j, i, array[j][i] / array[i][i]);
            }
        }
        return this;
    }

    private void subtractRows(int i, int j, double a) {
        for (int k = 0; k < width; k++) array[i][k] -= a * array[j][k];
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(array);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix that)) return false;

        if (this.height != that.height) return false;
        if (this.width != that.width) return false;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (this.array[i][j] != that.array[i][j]) return false;
            }
        }
        return true;
    }

}

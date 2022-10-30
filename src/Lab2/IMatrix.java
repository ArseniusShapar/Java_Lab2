package Lab2;

interface IMatrix {
    double getElement(int i, int j);

    double[] getRow(int i);

    double[] getColumn(int j);

    double[][] getArray();

    Pair<Integer> getDimension();

    Matrix toUpperTriangle();

    Matrix toLowerTriangle();
}

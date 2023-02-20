package com.example.graphics;

public class SearchABC {
    private static double[] x = {1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9,
            2.0, 2.1, 2.2, 2.3, 2.4, 2.5, 2.6, 2.7, 2.8, 2.9};
    private static double[] y = {129.71, 128.12, 126.67, 125.33, 124.07, 122.85, 121.65, 120.44, 119.2, 117.9,
            116.51, 114.98, 113.27, 111.3, 108.9, 105.9, 102.0, 96.62, 88.25, 73.3};

    public SearchABC() {

    }

    public double sumArgs(double [] x, double degreeX, double []y, double degreeY) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(y[i], degreeY) * Math.pow(x[i], degreeX);
        }
        return sum;
    }

    public double [][] setFirstViewForMatrix() {
        return new double[][]{
                {sumArgs(x, 4, y, 0), sumArgs(x, 3, y, 0), sumArgs(x, 2, y, 0)},
                {sumArgs(x, 3, y, 0), sumArgs(x, 2, y, 0), sumArgs(x, 1, y, 0)},
                {sumArgs(x, 2, y, 0), sumArgs(x, 1, y, 0), 20.0}
        };
    }

    public double[][] setMatrixArgs(int numColumn) {
        double [][] matrixArg = setFirstViewForMatrix();
        matrixArg[0][numColumn - 1] = sumArgs(x, 2, y, 1);
        matrixArg[1][numColumn - 1] = sumArgs(x, 1, y, 1);
        matrixArg[2][numColumn - 1] = sumArgs(x, 0, y, 1);
        return matrixArg;
    }

    public double detMatrix (double [][] matrix) {
        return matrix[0][0] * matrix[1][1] * matrix[2][2] + matrix[0][1] * matrix [1][2] * matrix [2][0] +
                matrix[0][2] * matrix[1][0] * matrix[2][1] - matrix[0][2] * matrix[1][1] * matrix[2][0] -
                matrix[0][1] * matrix[1][0] * matrix[2][2] - matrix[0][0] * matrix[1][2] * matrix[2][1];
    }

    public double searchArg (int numColumn) {
        double [][] matrixArg = setMatrixArgs(numColumn);
        return detMatrix(matrixArg) / detMatrix(setFirstViewForMatrix());
    }

    public double[] getY() {
        return y;
    }

    public double[] getX() {
        return x;
    }

}

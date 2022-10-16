package Matrix;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    double[][] matrix;
    int n, m;


    public Matrix() {
        initMatrix(0, 0);
    }


    public Matrix(int n) {
        initMatrix(n, n);
    }


    public Matrix(int n, int m) {
        initMatrix(n, m);
    }


    public Matrix(Matrix matr) {
        CopyOfMatrix(matr.matrix);
    }


    public void CopyOfMatrix(double[][] masf) {
        if (masf != null) {
            initMatrix(masf.length, masf[0].length);
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++) {
                    this.matrix[i][j] = masf[i][j];
                }
            }
        } else {
            this.matrix = null;
        }
    }


    private void initMatrix(int n, int m) {
        this.n = n;
        this.m = m;
        if (n != 0 && m != 0)
            this.matrix = new double[n][m];
        else
            this.matrix = null;
    }


    public String GetTheElementOfMatrix(int i, int j) {
        return " " + this.matrix[i][j];
    }


    public String GetTheRowOfMatrix(int i) {
        StringBuilder row = new StringBuilder();
        for (int j = 0; j < this.m; j++)
            row.append(matrix[i][j]).append(" ");
        return row.toString();
    }


    public String GetTheColumnOfMatrix(int j) {
        StringBuilder column = new StringBuilder();
        for (int i = 0; i < this.n; i++)
            column.append(matrix[i][j]).append(" ");
        return column.toString();
    }


    public int[] Get_Size() {
        int[] size = {this.n, this.m};
        System.out.println("Розмір: ");
        return size;
    }


    public void TheGenerationOfMatrix(int n, int m) {
        initMatrix(n, m);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix[i][j] = round(Math.random() * 2001 - 1000);
            }
        }
    }


    public void TheGenerationOfMatrix(int n) {
        TheGenerationOfMatrix(n, n);
    }


    private static double round(double val) {
        double force = Math.pow(10, 3);
        return Math.round(val * force) / force;
    }


    public void TheDisplayOfMatrix() {
        if (this.n != 0 && this.m != 0) {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++)
                    System.out.print(this.matrix[i][j] + " ");
                System.out.println();
            }
        }
        System.out.println();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Matrix mx = (Matrix) o;
        return n == mx.n && m == mx.m && Arrays.deepEquals(matrix, mx.matrix);
    }


    //@Override
    //public int hashCode() {
    //    int result = Objects.hash(n, m);
    //    for (int i = 0; i < n; i++)
    //        result = 31 * result + Arrays.deepHashCode(matrix);
    //    return result;
    //}


    public void TheGenerationOfMatrixRow(int n) {
        TheGenerationOfMatrix(1, n);
    }


    public void TransposeMatrix() {
        Matrix temp = new Matrix(this);
        initMatrix(this.m, this.n);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix[i][j] = temp.matrix[j][i];
            }
        }
    }
}
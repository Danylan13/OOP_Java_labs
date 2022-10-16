package Matrix;


import java.util.Arrays;
import java.util.Objects;

final class ImmutableMatrix {
    private final double [][] matrix;
    private final int n, m;


    public ImmutableMatrix(int n, int m) {
        this.matrix = new double[n][m];
        this.n = n;
        this.m = m;
    }


    public ImmutableMatrix() {
        this(0, 0);
    }


    public ImmutableMatrix(int n) {
        this(n, n);
    }


    public ImmutableMatrix(double[][] matr) {
        this(matr.length, matr[0].length);
        CopyOfMatrix(matr);
    }


    public ImmutableMatrix(Matrix matr) {
        this(matr.n, matr.m);
        CopyOfMatrix(matr.matrix);
    }


    public ImmutableMatrix(ImmutableMatrix matr) {
        this(matr.n, matr.m);
        CopyOfMatrix(matr.matrix);
    }


    public void CopyOfMatrix(double[][] masf) {
        if (masf != null)
            for (int i = 0; i < masf.length; i++)
                for (int j = 0; j < masf[0].length; j++)
                    this.matrix[i][j] = masf[i][j];
    }

    public void CopyOfMatrix(Matrix masf) {
        CopyOfMatrix(masf.matrix);
    }


    public void CopyOfMatrix(ImmutableMatrix masf) {
        CopyOfMatrix(masf.matrix);
    }


    public double[][] GetTheImmutableMatrix() {
        return this.matrix;
    }


    public void TheGenerationOfMatrix(int n, int m) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        ImmutableMatrix mx = (ImmutableMatrix) o;
        return n == mx.n && m == mx.m && Arrays.deepEquals(matrix, mx.matrix);
    }


    //@Override
    //public int hashCode() {
    //    int result = Objects.hash(n, m);
    //    for (int i = 0; i < this.n; i++)
    //        result = 31 * result + Arrays.deepHashCode(matrix);
    //    return result;
    //}


    public void TheGenerationOfMatrixRow(int n) {
        TheGenerationOfMatrix(1, n);
    }


    public void TransposeMatrix() {
        ImmutableMatrix temp = new ImmutableMatrix(this);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.matrix[i][j] = temp.matrix[j][i];
            }
        }
    }
}
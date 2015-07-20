package chapter1;

public class Problem7 {
    public static void main (String[] args) {
        int[][] mockMatrix = new int[][] {
            {1,2,3,2}, {0,3,2,0}, {2,2,3,0}, {3,1,1,3}
        };
        System.out.println("Original matrix: ");
        printMatrix(mockMatrix);
        System.out.println("Matrix after check zero: ");
        setRowZero(mockMatrix);
        printMatrix(mockMatrix);
    }
    
    public static void printMatrix (int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                System.out.print(matrix[i][j] + " , ");
            }
            System.out.println(matrix[i][n-1]);
        }
    }
    
    public static void setRowZero(int[][] matrix) {
        int n = matrix.length;
        boolean[] isRowSet = new boolean[n];
        boolean[] isColSet = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!isRowSet[i]) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] == 0) {
                        isRowSet[i] = true;
                        isColSet[j] = true;
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isRowSet[i] || isColSet[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
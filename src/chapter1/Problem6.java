package chapter1;

public class Problem6 {
    public static void main (String[] args) {
        int[][] matrix = new int[][] {
            {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}
        };
        System.out.println("Matrix before rotate: ");
        printMatrix(matrix);
        System.out.println("Matrix after rotate: ");
        rotateMatrix(matrix);
        printMatrix(matrix);
    }
    
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                System.out.print(matrix[i][j] + " , ");
            }
            System.out.println(matrix[i][n-1]);
        }
    }

    private static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int layer_count = n/2;
        for(int i = 0; i < layer_count; i++) {
            for(int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}

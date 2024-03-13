import java.util.Scanner;

class printDiagonally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
            int n = scanner.nextInt();
            int[][] mat = new int[n][n];
            System.out.println("enter the array elements:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = scanner.nextInt();
                }
            }
            
            int[] ans = matrixDiagonally(mat);
            System.out.println("Diagonally printed format is:");
            for (int it = 0; it < ans.length; it++) {
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        
        scanner.close();
    }
    public static  int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int[] arr = new int[n * n];
        int k = 0, i = 0, j = 0, dr = 1;
        while (k < arr.length) {
            if (dr == 1) {
                arr[k++] = mat[i][j];
                i--;
                j++;
                if (i < 0 && j >= n) {
                    i += 2;
                    j--;
                    dr = -1;
                }
                else if (i < 0) {
                    i++;
                    dr = -1;
                } else if (j >= n) {
                    i += 2;
                    j--;
                    dr = -1;
                }
            } else if (dr == -1) {
                arr[k++] = mat[i][j];
                i++;
                j--;
                if (i >= n && j < 0) {
                    i--;
                    j += 2;
                    dr = 1;
                } else if (j < 0) {
                    j++;
                    dr = 1;
                } else if(i>=n) {
                    i--;
                    j += 2;
                    dr = 1;
                }
            }
        }
        return arr;
    }
}
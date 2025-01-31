//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        solve(mat);
    }
    private static boolean isValid(int[][] mat, int row, int col, int num){
        for(int i=0;i<mat.length;i++){
            if(mat[row][i]==num || mat[i][col]==num){
                return false;
            }
        }
        int rStart=(row/3)*3;
        int cStart=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(mat[rStart+i][cStart+j]==num){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean solve(int[][] mat){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(mat[i][j]==0){
                    for(int num=1;num<=9;num++){
                        if(isValid(mat, i, j, num)){
                            mat[i][j]=num;
                            if(solve(mat)){
                                return true;
                            }
                            else{
                                mat[i][j]=0;
                            }
                        }
                    }
                    return false;
                } 
            }
        }
        return true;
    }

}
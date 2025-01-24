//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int r, int c, int[][] a)
    {
        // code here
        List<Integer> list=new ArrayList<>();
        int[] arr=new int[r*c];
        int len=arr.length-1;
        int top=0;
        int bottom=r-1;
        int left=0;
        int right=c-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                arr[len--]=a[top][i];
            }
            top++;
            for(int i=top;i<=bottom;i++){
                arr[len--]=a[i][right];
                
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    arr[len--]=a[bottom][i];
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    arr[len--]=a[i][left];
                }
                left++;
            }
        }
        return arr;
    }
}
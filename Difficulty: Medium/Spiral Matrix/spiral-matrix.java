//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
	{
	    // Your code goes here
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=m-1;
        
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                if(--k==0) return a[top][i];
            }
            top++;
            for(int i=top;i<=bottom;i++){
                if(--k==0) return a[i][right];
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    if(--k==0) return a[bottom][i];
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    if(--k==0) return a[i][left];
                }
                left++;
            }
        }
        return -1;
    }
	
}
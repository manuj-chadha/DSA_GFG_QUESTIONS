//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
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
    public ArrayList<String> permutation(String s)
    {
        // Code here
        ArrayList<String> list=find("", s);
        Collections.sort(list);
        return list;
    }
    private ArrayList<String> find(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0, i);
            String s=p.substring(i, p.length());
            list.addAll(find(f+up.charAt(0)+s, up.substring(1)));
            
        }
        return list;
    }
}

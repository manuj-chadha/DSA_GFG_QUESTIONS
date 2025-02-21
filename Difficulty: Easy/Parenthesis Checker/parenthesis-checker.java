//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
                else return false;
            }
            else if(s.charAt(i)==']'){
                if(!stack.isEmpty() && stack.peek()=='[') stack.pop();
                else return false;
            }
            else if(s.charAt(i)=='}'){
                if(!stack.isEmpty() && stack.peek()=='{') stack.pop();
                else return false;
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}

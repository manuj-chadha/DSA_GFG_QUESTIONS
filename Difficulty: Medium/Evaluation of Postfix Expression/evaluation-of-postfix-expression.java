//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i].matches("-?\\d+")){
                stack.push(Integer.parseInt(arr[i]));
            }
            else{
                int v1=stack.pop();
                int v2=stack.pop();
                
                switch(arr[i]) {
                    case "+":
                        stack.push(v2 + v1);
                        break;
                    case "-":
                        stack.push(v2 - v1);
                        break;
                    case "*":
                        stack.push(v2 * v1);
                        break;
                    case "/":
                        stack.push(v2 / v1);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + arr[i]);
                }
            }
        }
        return stack.pop();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
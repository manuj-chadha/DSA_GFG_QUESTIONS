//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        list.add(node.data);
        if(node.left==null && node.right==null) return list;
        leftBoundary(node.left, list);
        leafNodes(node, list);
        rightBoundary(node.right, list);
        return list;
    }
    private void leftBoundary(Node root, ArrayList<Integer> list){
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        list.add(root.data);
        if(root.left==null && root.right!=null){
            leftBoundary(root.right, list);
        }
        leftBoundary(root.left, list);
    }
    
    private void leafNodes(Node root, ArrayList<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            list.add(root.data);
            return;
        } 
        leafNodes(root.left, list);
        leafNodes(root.right, list);
    }
    
    private void rightBoundary(Node root, ArrayList<Integer> list){
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        if(root.right!=null){
            rightBoundary(root.right, list);
        }
        else{
            rightBoundary(root.left, list);
        }
        list.add(root.data);
    }
}

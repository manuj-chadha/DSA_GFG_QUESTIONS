//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            S = br.readLine().trim().split(" ");
            int E = Integer.parseInt(S[0]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(adj);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> queue=new LinkedList<>();
        int[] coloured=new int[adj.size()];
        Arrays.fill(coloured, -1);
        for(int i=0;i<coloured.length;i++){
            if(coloured[i]==-1){
                queue.offer(i);
                coloured[i]=0;
                while(!queue.isEmpty()){
                    int removed=queue.poll();
                    for(int j=0;j<adj.get(removed).size();j++){
                        if(coloured[adj.get(removed).get(j)]==-1){
                            queue.offer(adj.get(removed).get(j));
                            coloured[adj.get(removed).get(j)]=(coloured[removed]+1)%2; 
                        }
                        else{
                            if(coloured[adj.get(removed).get(j)]==coloured[removed]){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
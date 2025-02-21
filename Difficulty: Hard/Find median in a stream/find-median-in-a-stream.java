//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b) -> (b-a));
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        ArrayList<Double> list=new ArrayList<>();
        
        
        for(int i=0;i<arr.length;i++){
            insertHeap(arr[i]);
            if(minHeap.size()==maxHeap.size()){
                list.add((double)(maxHeap.peek()+minHeap.peek())/2);
            }
            else if(maxHeap.size()>minHeap.size()){
                list.add((double) maxHeap.peek());
            }
        }
        return list;
    }
    public void insertHeap(int val){
        if(maxHeap.isEmpty()){
            maxHeap.offer(val);
            return;
        }
        if(maxHeap.peek()>val){
            maxHeap.offer(val);
        }
        else{
            minHeap.offer(val);
        }
        balanceHeap();
    }
    public void balanceHeap(){
        if(maxHeap.size()-1>minHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
        else if(maxHeap.size()<minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        
    }
}
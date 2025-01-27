//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
    static int capacity=0;
    static LinkedHashMap<Integer, Integer> hashMap;
    
    LRUCache(int cap) {
        // code here
        this.capacity=cap;
        hashMap=new LinkedHashMap<>(cap, 0.75f , true);
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        // your code here
        return hashMap.getOrDefault(key, -1);
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        // your code here
        if(hashMap.containsKey(key)){
            hashMap.put(key, value);
        }
        else{
            if (hashMap.size() == capacity) {
                Integer firstKey = hashMap.keySet().iterator().next();
                hashMap.remove(firstKey);
            }
            hashMap.put(key, value);
        }
    }
}

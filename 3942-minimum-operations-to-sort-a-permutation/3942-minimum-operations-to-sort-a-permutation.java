import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        // Find index of 0 to check if nums is a cyclic shift of increasing order
        int idx0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx0 = i;
                break;
            }
        }
        
        boolean isIncreasing = true;
        for (int j = 0; j < n; j++) {
            if (nums[(idx0 + j) % n] != j) {
                isIncreasing = false;
                break;
            }
        }
        
        // Construct reversed array to check if it's a cyclic shift of increasing order
        int[] rev = new int[n];
        for (int i = 0; i < n; i++) {
            rev[i] = nums[n - 1 - i];
        }
        
        int rev_idx0 = -1;
        for (int i = 0; i < n; i++) {
            if (rev[i] == 0) {
                rev_idx0 = i;
                break;
            }
        }
        
        boolean revIsIncreasing = true;
        for (int j = 0; j < n; j++) {
            if (rev[(rev_idx0 + j) % n] != j) {
                revIsIncreasing = false;
                break;
            }
        }
        
        // If neither is possible, sorting is impossible
        if (!isIncreasing && !revIsIncreasing) {
            return -1;
        }
        
        // Identify target states
        Set<Integer> targets = new HashSet<>();
        if (isIncreasing) {
            targets.add(encode(0, idx0, n));
        }
        if (revIsIncreasing) {
            targets.add(encode(1, rev_idx0, n));
        }
        
        // BFS on 2n states
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[2 * n];
        Arrays.fill(dist, -1);
        
        // Start state: (type = 0, shift = 0) representing the input array
        int startState = encode(0, 0, n);
        queue.add(startState);
        dist[startState] = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int type = curr / n;
            int shift = curr % n;
            
            if (targets.contains(curr)) {
                return dist[curr];
            }
            
            // Operation 1: Rotate Left
            int next1 = encode(type, (shift + 1) % n, n);
            if (dist[next1] == -1) {
                dist[next1] = dist[curr] + 1;
                queue.add(next1);
            }
            
            // Operation 2: Reverse
            int next2 = encode(1 - type, (n - shift) % n, n);
            if (dist[next2] == -1) {
                dist[next2] = dist[curr] + 1;
                queue.add(next2);
            }
        }
        
        return -1;
    }
    
    private int encode(int type, int shift, int n) {
        return type * n + shift;
    }
}
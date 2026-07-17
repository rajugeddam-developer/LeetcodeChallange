// 
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int ans = -1;
        
        for (int num : nums) {
            // Check if the number is even
            if (num % 2 == 0) {
                int freq = map.getOrDefault(num, 0) + 1;
                map.put(num, freq);
                
                // Update the answer if:
                // 1. We found a strictly greater frequency, OR
                // 2. We found the same frequency but the current number is smaller
                if (freq > maxFreq || (freq == maxFreq && (ans == -1 || num < ans))) {
                    maxFreq = freq;
                    ans = num;
                }
            }
        }
        
        return ans;
    }
}
import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        
        // Count frequency of each letter
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Sort frequencies in ascending order
        Arrays.sort(freq);
        
        int totalPushes = 0;
        
        // Iterate from most frequent to least frequent
        for (int i = 0; i < 26; i++) {
            int count = freq[25 - i];
            if (count == 0) break; // No more characters left
            
            int multiplier = (i / 8) + 1; // 1 push for first 8, 2 for next 8, etc.
            totalPushes += count * multiplier;
        }
        
        return totalPushes;
    }
}
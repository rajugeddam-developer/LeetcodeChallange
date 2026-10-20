import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        int totalSum = 0;
        
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            
            boolean valid = true;
            for (int i = 0; i < n; i += k) {
                // Check if target segment sortedNums[i ... i+k-1] is a cyclic rotation 
                // of nums[i ... i+k-1].
                if (!isCyclicRotation(nums, i, sortedNums, i, k)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                totalSum += k;
            }
        }
        
        return totalSum;
    }
    
    private boolean isCyclicRotation(int[] arr1, int start1, int[] arr2, int start2, int k) {
        int[] pattern = new int[k];
        for (int i = 0; i < k; i++) {
            pattern[i] = arr2[start2 + i];
        }
        
        int[] text = new int[2 * k];
        for (int i = 0; i < k; i++) {
            text[i] = arr1[start1 + i];
            text[i + k] = arr1[start1 + i];
        }
        
        return kmpContains(text, pattern);
    }
    
    private boolean kmpContains(int[] text, int[] pattern) {
        int m = pattern.length;
        int n = text.length;
        if (m == 0) return true;
        
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        i = 0;
        int j = 0;
        while (i < n) {
            if (pattern[j] == text[i]) {
                i++;
                j++;
            }
            if (j == m) {
                return true;
            } else if (i < n && pattern[j] != text[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
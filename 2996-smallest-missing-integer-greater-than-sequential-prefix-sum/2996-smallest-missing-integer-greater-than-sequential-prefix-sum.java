import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        
        // Step 1: Calculate sum of longest sequential prefix starting at index 0
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break; // Break as soon as sequence stops
            }
        }
        
        //Step 2: Store elements in a set for O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // Find smallest missing integer >= sum
        while (set.contains(sum)) {
            sum++;
        }
        
        return sum;
    
    }
}
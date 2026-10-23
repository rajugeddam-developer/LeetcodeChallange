class Solution {
    public int sortPermutation(int[] nums) {
        int k = -1;
        boolean sorted = true;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                sorted = false;
                if (k == -1) {
                    k = nums[i];
                } else {
                    k &= nums[i];
                }
            }
        }
        
        // If the array is already sorted, return 0
        if (sorted) {
            return 0;
        }
        
        return k;
    }
}
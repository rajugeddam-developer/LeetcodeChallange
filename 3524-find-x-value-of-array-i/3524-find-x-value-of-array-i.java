class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            long[] next = new long[k];

            // Start a new subarray with only num
            int remainder = num % k;
            next[remainder]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {

                    int newRemainder = (r * remainder) % k;

                    next[newRemainder] += dp[r];
                }
            }

            // dp becomes the subarrays ending at current index
            dp = next;

            // Add them to global answer
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}
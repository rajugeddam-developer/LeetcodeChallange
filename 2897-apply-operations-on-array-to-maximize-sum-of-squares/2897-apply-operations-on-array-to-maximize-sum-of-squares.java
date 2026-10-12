class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        
        long ans = 0;
        long MOD = 1_000_000_007;
        
        for (int step = 0; step < k; step++) {
            long current = 0;
            for (int i = 0; i < 32; i++) {
                if (bitCount[i] > 0) {
                    current |= (1L << i);
                    bitCount[i]--;
                }
            }
            ans = (ans + current * current) % MOD;
        }
        
        return (int) ans;
    }
}
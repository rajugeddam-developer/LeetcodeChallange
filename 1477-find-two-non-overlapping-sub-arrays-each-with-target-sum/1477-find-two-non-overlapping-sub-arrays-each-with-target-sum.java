class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        
        int currentSum = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;
        int currentMinLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            // Shrink window if sum exceeds target
            while (currentSum > target) {
                currentSum -= arr[left];
                left++;
            }

            // Found a valid subarray with sum == target
            if (currentSum == target) {
                int len = right - left + 1;

                // Check if a valid non-overlapping subarray exists before 'left'
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minLen[left - 1]);
                }

                currentMinLen = Math.min(currentMinLen, len);
            }

            // Store the best subarray length found so far up to index 'right'
            minLen[right] = currentMinLen;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
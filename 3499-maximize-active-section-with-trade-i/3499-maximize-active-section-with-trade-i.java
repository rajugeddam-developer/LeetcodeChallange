class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        
        // List to store the lengths of contiguous '0' blocks in order
        java.util.List<Integer> zeroBlocks = new java.util.ArrayList<>();
        
        int i = 0;
        int n = s.length();
        
        while (i < n) {
            if (s.charAt(i) == '1') {
                totalOnes++;
                i++;
            } else {
                int count = 0;
                while (i < n && s.charAt(i) == '0') {
                    count++;
                    i++;
                }
                zeroBlocks.add(count);
            }
        }
        
        // Find the maximum sum of two adjacent '0' blocks
        int maxZeroSum = 0;
        for (int j = 0; j < zeroBlocks.size() - 1; j++) {
            maxZeroSum = Math.max(maxZeroSum, zeroBlocks.get(j) + zeroBlocks.get(j + 1));
        }
        
        return totalOnes + maxZeroSum;
    }
}
import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map row number -> bitmask representing seats 2 to 9
        Map<Integer, Integer> rowMasks = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // Only care about seats 2 to 9
            if (col >= 2 && col <= 9) {
                int bitPosition = col - 2; // seat 2 -> bit 0, seat 9 -> bit 7
                rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << bitPosition));
            }
        }

        // Default maximum possible groups across all n rows
        int maxGroups = n * 2;

        // Bitmasks for each 4-seat block (1 means occupied)
        int leftBlock = 0b00001111;   // Seats 2, 3, 4, 5 -> bits 0, 1, 2, 3
        int middleBlock = 0b00111100; // Seats 4, 5, 6, 7 -> bits 2, 3, 4, 5
        int rightBlock = 0b11110000;  // Seats 6, 7, 8, 9 -> bits 4, 5, 6, 7

        for (int mask : rowMasks.values()) {
            boolean canLeft = (mask & leftBlock) == 0;
            boolean canRight = (mask & rightBlock) == 0;
            boolean canMiddle = (mask & middleBlock) == 0;

            if (canLeft && canRight) {
                // Both 2 groups fit, no reduction needed
                continue;
            } else if (canLeft || canRight || canMiddle) {
                // Only 1 group fits
                maxGroups -= 1;
            } else {
                // 0 groups fit
                maxGroups -= 2;
            }
        }

        return maxGroups;
    }
}
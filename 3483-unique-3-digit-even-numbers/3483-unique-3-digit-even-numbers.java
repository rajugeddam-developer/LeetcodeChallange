class Solution {
    public int totalNumbers(int[] digits) {
        // Count frequencies of available digits
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        int total = 0;

        // Iterate over all valid 3-digit even numbers
        for (int num = 100; num < 1000; num += 2) {
            int d1 = num / 100;       // Hundreds digit
            int d2 = (num / 10) % 10; // Tens digit
            int d3 = num % 10;        // Units digit

            // Count required frequency for each digit in the current number
            int[] currentCount = new int[10];
            currentCount[d1]++;
            currentCount[d2]++;
            currentCount[d3]++;

            // Check if available digits are sufficient
            if (currentCount[d1] <= count[d1] &&
                currentCount[d2] <= count[d2] &&
                currentCount[d3] <= count[d3]) {
                total++;
            }
        }

        return total;
    }
}
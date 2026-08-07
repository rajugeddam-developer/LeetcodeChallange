import java.util.Arrays;

class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Count required prime factors of t
        long temp = t;
        int c2 = 0, c3 = 0, c5 = 0, c7 = 0;
        while (temp % 2 == 0) { temp /= 2; c2++; }
        while (temp % 3 == 0) { temp /= 3; c3++; }
        while (temp % 5 == 0) { temp /= 5; c5++; }
        while (temp % 7 == 0) { temp /= 7; c7++; }
        
        // If t has prime factors > 7, it's impossible
        if (temp > 1) return "-1";

        int n = num.length();
        
        // Precalculate prefix factors and zero position in num
        int[] pref2 = new int[n + 1];
        int[] pref3 = new int[n + 1];
        int[] pref5 = new int[n + 1];
        int[] pref7 = new int[n + 1];
        int firstZero = n;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            pref2[i + 1] = pref2[i];
            pref3[i + 1] = pref3[i];
            pref5[i + 1] = pref5[i];
            pref7[i + 1] = pref7[i];

            if (ch == '0') {
                if (firstZero == n) firstZero = i;
            } else {
                int d = ch - '0';
                while (d % 2 == 0) { pref2[i + 1]++; d /= 2; }
                while (d % 3 == 0) { pref3[i + 1]++; d /= 3; }
                if (d == 5) pref5[i + 1]++;
                if (d == 7) pref7[i + 1]++;
            }
        }

        // Check if num itself is valid (has no zeros and satisfies t)
        if (firstZero == n) {
            if (pref2[n] >= c2 && pref3[n] >= c3 && pref5[n] >= c5 && pref7[n] >= c7) {
                return num;
            }
        }

        // Step 2: Try prefix matching from right to left
        for (int i = Math.min(n - 1, firstZero); i >= 0; i--) {
            int curDigit = num.charAt(i) - '0';
            
            for (int d = curDigit + 1; d <= 9; d++) {
                // Factors gained by placing digit 'd' at position i
                int d2 = 0, d3 = 0, d5 = 0, d7 = 0;
                int tempD = d;
                while (tempD % 2 == 0) { d2++; tempD /= 2; }
                while (tempD % 3 == 0) { d3++; tempD /= 3; }
                if (tempD == 5) d5++;
                if (tempD == 7) d7++;

                int rem2 = Math.max(0, c2 - pref2[i] - d2);
                int rem3 = Math.max(0, c3 - pref3[i] - d3);
                int rem5 = Math.max(0, c5 - pref5[i] - d5);
                int rem7 = Math.max(0, c7 - pref7[i] - d7);

                String suffix = getMinimalSuffix(rem2, rem3, rem5, rem7, n - 1 - i);
                if (suffix != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(d);
                    sb.append(suffix);
                    return sb.toString();
                }
            }
        }

        // Step 3: If no match within n digits, increase length
        for (int len = n + 1; ; len++) {
            String suffix = getMinimalSuffix(c2, c3, c5, c7, len);
            if (suffix != null) {
                return suffix;
            }
        }
    }

    private String getMinimalSuffix(int r2, int r3, int r5, int r7, int maxLen) {
        // Optimal greedy factor combination into single digits (9, 8, 7, 6, 5, 4, 3, 2)
        int n9 = r3 / 2; r3 %= 2;
        int n8 = r2 / 3; r2 %= 3;
        int n7 = r7;
        int n6 = 0;
        if (r2 > 0 && r3 > 0) { n6 = 1; r2--; r3--; }
        int n5 = r5;
        int n4 = r2 / 2; r2 %= 2;
        int n3 = r3;
        int n2 = r2;

        int totalDigits = n9 + n8 + n7 + n6 + n5 + n4 + n3 + n2;
        if (totalDigits > maxLen) return null;

        int ones = maxLen - totalDigits;
        StringBuilder sb = new StringBuilder();
        sb.append("1".repeat(ones));
        sb.append("2".repeat(n2));
        sb.append("3".repeat(n3));
        sb.append("4".repeat(n4));
        sb.append("5".repeat(n5));
        sb.append("6".repeat(n6));
        sb.append("7".repeat(n7));
        sb.append("8".repeat(n8));
        sb.append("9".repeat(n9));

        return sb.toString();
    }
}
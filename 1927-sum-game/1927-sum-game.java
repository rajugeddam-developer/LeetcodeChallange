class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumDiff = 0;   // sum(left) - sum(right)
        int qDiff = 0;     // count('?' right) - count('?' left)

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                qDiff--;
            } else {
                sumDiff += num.charAt(i) - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                qDiff++;
            } else {
                sumDiff -= num.charAt(i) - '0';
            }
        }

        // If total '?' count is odd, Alice always wins
        if ((qDiff & 1) != 0) {
            return true;
        }

        // Bob wins if the sum difference perfectly matches 9 * (qDiff / 2)
        return 2 * sumDiff != 9 * qDiff;
    }
}
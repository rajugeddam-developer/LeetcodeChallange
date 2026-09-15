class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int lastEnd = -1; // End index of the last selected palindrome

        // Expand around each possible center
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2;
            int right = left + (i % 2);

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;

                // Stop expanding if we exceed k + 1 because a smaller valid sub-palindrome exists
                if (len > k + 1) {
                    break;
                }

                // If valid palindrome length >= k and starts after the last chosen palindrome
                if (len >= k) {
                    if (left > lastEnd) {
                        count++;
                        lastEnd = right;
                    }
                    break; // Pick the earliest ending palindrome for this center
                }

                left--;
                right++;
            }
        }

        return count;
    }
}
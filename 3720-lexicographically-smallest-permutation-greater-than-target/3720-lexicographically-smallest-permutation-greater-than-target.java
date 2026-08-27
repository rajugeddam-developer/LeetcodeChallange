class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Try to match prefix of length i (from n-1 down to 0)
        for (int i = n - 1; i >= 0; i--) {
            // Count frequency needed for target[0...i-1]
            int[] prefixFreq = new int[26];
            boolean possible = true;
            for (int k = 0; k < i; k++) {
                int idx = target.charAt(k) - 'a';
                prefixFreq[idx]++;
                if (prefixFreq[idx] > freq[idx]) {
                    possible = false;
                    break;
                }
            }
            if (!possible) continue;

            // Remaining character counts after matching target[0...i-1]
            int[] rem = new int[26];
            for (int k = 0; k < 26; k++) {
                rem[k] = freq[k] - prefixFreq[k];
            }

            // Find the smallest character strictly greater than target[i]
            int targetCharIdx = target.charAt(i) - 'a';
            int pickChar = -1;
            for (int c = targetCharIdx + 1; c < 26; c++) {
                if (rem[c] > 0) {
                    pickChar = c;
                    break;
                }
            }

            // If a valid character is found, build the answer
            if (pickChar != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.substring(0, i));
                sb.append((char) ('a' + pickChar));
                rem[pickChar]--;

                for (int c = 0; c < 26; c++) {
                    while (rem[c] > 0) {
                        sb.append((char) ('a' + c));
                        rem[c]--;
                    }
                }
                return sb.toString();
            }
        }

        return "";
    }
}
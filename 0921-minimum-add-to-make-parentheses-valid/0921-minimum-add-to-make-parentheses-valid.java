class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0; // Tracks unmatched '('
        int ans = 0;  // Tracks missing '(' for unmatched ')'
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--; // Match with an existing '('
                } else {
                    ans++;  // Need an extra '(' for this ')'
                }
            }
        }
        
        return ans + open;
    }
}
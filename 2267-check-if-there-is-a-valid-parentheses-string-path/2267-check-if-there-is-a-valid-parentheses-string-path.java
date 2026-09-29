class Solution {
    private Boolean[][][] memo;
    private char[][] grid;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        // Optimization: Path length must be even, start cannot be ')' and end cannot be '('
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        
        // Fix: Max balance can reach up to (m + n - 1)
        memo = new Boolean[m][n][m + n];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int r, int c, int balance) {
        // Update balance based on the current cell
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }
        
        // If balance drops below 0, this path is invalid
        if (balance < 0) {
            return false;
        }
        
        // Reached the bottom-right corner
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }
        
        // Check memoization table
        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }
        
        boolean res = false;
        
        // Move down
        if (r + 1 < m) {
            res = res || dfs(r + 1, c, balance);
        }
        // Move right
        if (!res && c + 1 < n) {
            res = res || dfs(r, c + 1, balance);
        }
        
        return memo[r][c][balance] = res;
    }
}
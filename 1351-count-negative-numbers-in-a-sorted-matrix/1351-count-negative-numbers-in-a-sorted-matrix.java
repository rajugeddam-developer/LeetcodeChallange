class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        for(int i = 0; i < rows; i++) {
            int cols = grid[i].length;
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

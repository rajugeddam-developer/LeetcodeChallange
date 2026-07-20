import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        
        // Optimize k to handle cases where k >= total elements
        k = k % total;
        
        // Initialize the outer result list with empty lists for each row
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                result.get(i).add(0); // Fill with placeholder values
            }
        }
        
        // Directly place each element into its final shifted position
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int old1D = i * n + j;
                int new1D = (old1D + k) % total;
                
                int newRow = new1D / n;
                int newCol = new1D % n;
                
                result.get(newRow).set(newCol, grid[i][j]);
            }
        }
        
        return result;
    }
}
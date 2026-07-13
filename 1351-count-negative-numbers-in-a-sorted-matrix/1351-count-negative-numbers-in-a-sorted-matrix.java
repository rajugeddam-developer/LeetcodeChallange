// class Solution {
//     public int countNegatives(int[][] grid) {
//         int count = 0;
//         for(int i = 0; i < grid.length; i++) {
//             for(int j = 0; j <grid[i].length; j++) {
//                 if(grid[i][j] < 0) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            int left = 0, right = row.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (row[mid] < 0) {
                    right = mid - 1; // look left for earlier negatives
                } else {
                    left = mid + 1;  // look right for negatives
                }
            }
            // left now points to the first negative index
            count += row.length - left;
        }
        return count;
    }
}


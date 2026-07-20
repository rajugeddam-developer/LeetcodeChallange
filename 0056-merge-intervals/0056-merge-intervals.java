// class Solution {
//      public int[][] merge(int[][] intervals) {
//         int n = intervals.length;
//         if (n == 0) return new int[0][0];

//         // Sort the intervals based on the first element
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

//         List<int[]> ans = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             // If answer is empty OR the current interval's start is greater than the 
//             // last merged interval's end, it is a new interval.
//             if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]) {
//                 ans.add(new int[]{intervals[i][0], intervals[i][1]});
//             } else {
//                 // If it overlaps, update the end of the last merged interval to the max end
//                 ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
//             }
//         }

//         return ans.toArray(new int[ans.size()-1][]);
//     }
// }

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0)
            return new int[0][0];

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {

            // No overlap
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            }
            // Overlap
            else {
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }

        return ans.toArray(new int[0][]);
    }
}

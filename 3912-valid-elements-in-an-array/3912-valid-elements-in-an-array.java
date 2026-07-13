import java.util.*;

class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

    
        if (n == 1) {
            list.add(nums[0]);
            return list;
        }

       
        list.add(nums[0]);

       
        for (int i = 1; i < n - 1; i++) {
            boolean greaterLeft = true;
            boolean greaterRight = true;

          
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    greaterLeft = false;
                    break;
                }
            }

          
            for (int j = i + 1; j < n; j++) {
                if (nums[i] <= nums[j]) {
                    greaterRight = false;
                    break;
                }
            }

            if (greaterLeft || greaterRight) {
                list.add(nums[i]);
            }
        }

        list.add(nums[n - 1]);

        return list;
    }
}

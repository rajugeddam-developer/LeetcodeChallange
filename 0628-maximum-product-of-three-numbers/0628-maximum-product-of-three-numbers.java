class Solution {
    public int maximumProduct(int[] nums) {
       int n=nums.length;
       int max1=Integer.MIN_VALUE;
       int max2=Integer.MIN_VALUE;
       int max3=Integer.MIN_VALUE;
       int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
              if(nums[i]>max1){
                max3=max2;
                max2=max1;
                max1=nums[i];
              }else if(nums[i]>max2){
                max3=max2;
                max2=nums[i];
              }else if(nums[i] >max3){
                max3=nums[i];
              }
      // Update 2 minimum values
            if (nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }

        // Compare product of 3 largest vs product of 2 smallest + 1 largest
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}


// import java.util.Arrays;

// class Solution {
//     public int maximumProduct(int[] nums) {
//         Arrays.sort(nums);
//         int n = nums.length;
        
//         int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
//         int option2 = nums[0] * nums[1] * nums[n - 1];
        
//         return Math.max(option1, option2);
//     }
// }
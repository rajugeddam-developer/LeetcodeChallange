// class Solution {
//     public int numIdenticalPairs(int[] nums) {
//         int n=nums.length;
//         int count=0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(nums[i]==nums[j]){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101]; // since nums[i] is between 1 and 100
        int count = 0;

        for (int num : nums) {
            count += freq[num];  // each previous occurrence of num forms a pair
            freq[num]++;         // update frequency
        }

        return count;
    }
}

// class Solution {
//     public int maxProduct(int[] nums) {
//         int n=nums.length;
//         if(nums.length==2){
//             return (nums[0]-1)*(nums[1]-1);
//         }
//         int max=0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 int product=((nums[i]-1)*(nums[j]-1));
//               if(product>max){
//                 max=product;
//               }
//             }
//         }
//         return max;
//     }
// }
class Solution{
       public int maxProduct(int[] nums){
        int max1=0;
        int max2=0;
        for(int num:nums){
            if(num>max1){
                max2=max1;
                max1=num;
            }else if(num>max2){
                max2=num;
            }
        }
        return (max1-1)*(max2-1);
       }
}
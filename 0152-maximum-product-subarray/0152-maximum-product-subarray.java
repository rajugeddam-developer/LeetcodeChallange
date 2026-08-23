class Solution {
    public int maxProduct(int[] nums) {
        // int n=nums.length;
        // int max=Integer.MIN_VALUE;

        // int left=1;
        // int right=1;

        // for(int i=0;i<n;i++){
        //     if(left==0){
        //         left=1;
        //     }
        //     if(right==0){
        //         right=1;
        //     }

        //     left*=nums[i];
        //     right*=nums[n-i-1];

        //     max=Math.max(max,Math.max(left,right));
        // }
        // return max;
 

        // Dynamic programming
        int n=nums.length;

        int maxProduct=nums[0];
        int minProduct=nums[0];

        int ans=nums[0];

        for(int i=1;i<n;i++){
            int num=nums[i];

            int oldMax=maxProduct;
            int oldMin=minProduct;

            maxProduct=Math.max(num,Math.max(num*oldMax,num*oldMin));

            minProduct=Math.min(num,Math.min(num*oldMax,num*oldMin));

            ans=Math.max(ans,maxProduct);
        }
   return ans;

    }
}
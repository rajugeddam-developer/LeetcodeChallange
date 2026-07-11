class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=-1;
//step-1: find the break point
 // iterate the through the backward
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
//step-2 :if there is no break point just  reverse the array and return the ;
        if(index==-1){
            reverse(nums,0,n-1);
            return ;
        }
//step-3:find the slightly grater element and swap with it
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[index]){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                break;
            }
        }
//step-4: Reverse the right side of the array(After break point)
         reverse(nums,index+1,n-1);


 }
 //step-5:helper method
 private static void reverse(int[] nums,int start, int end){
    while(start<end){
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
        start++;
        end--;
    
    }
   }
}
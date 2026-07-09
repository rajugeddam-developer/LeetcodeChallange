class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int left=0;
        int right=n-1;
        int pos=n-1;
        while(left<=right){
            int leftSqr=nums[left]*nums[left];
            int rightSqr=nums[right]*nums[right];
            if(leftSqr>rightSqr){
                arr[pos--]=leftSqr;
                left++;
            }else{
                arr[pos--]=rightSqr;
                right--;
            }
        }
        return arr;
    }
}
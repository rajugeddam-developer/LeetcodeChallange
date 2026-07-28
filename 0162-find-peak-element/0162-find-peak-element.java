class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;//if the array has single element
        if(nums[0]>nums[1]) return 0;// if the array has two elements
        if(nums[n-1]>nums[n-2]) return n-1;// check the last two elements
        //Trimmmed Search Spaces
        int low=1;
        int high=n-2;
        while(low<=high){
            int mid=low+(high-low)/2; 
            //compare the mid element with next element and previous element 
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            //elemenation left and rightt hald
            if(nums[mid]>nums[mid-1]){
                low=mid+1;//eliminate the left half
            }else{
                high=mid-1;//eleminate the right half
            }
        }
        return -1;
    }
}
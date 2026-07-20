class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=findFirst(nums,target);
        ans[1]=findLast(nums,target);
        return ans;
    }

    private static int findFirst(int[] nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                index=mid;
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return index;

    }

    private static int findLast(int[] nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                index=mid;
                low=mid+1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return index;
    }
}
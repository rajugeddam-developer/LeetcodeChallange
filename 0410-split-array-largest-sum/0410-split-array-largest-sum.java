class Solution {
     public static int countPairs(int[] boards,int n){
        int count=1;
        int currentCount=0;
        for(int board:boards){
            if(currentCount+board<=n){
                currentCount+=board;
            }else{
                count++;
                currentCount=board;
            }
        }
        return count;
     }

    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int num:nums){
            low=Math.max(low,num);
            high+=num;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(countPairs(nums,mid)<=k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
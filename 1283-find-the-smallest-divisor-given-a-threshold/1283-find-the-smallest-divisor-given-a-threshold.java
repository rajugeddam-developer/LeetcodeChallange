class Solution {
    public  static int findByDivisor(int[] arr, int div){
        int sum=0;
        for(int num:arr){
            sum+=Math.ceil((double)num/div);
        }
        return sum;
    }
    
    public static int findMax(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int num:arr){
            max=Math.max(max,num);
        }
        return max;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n =nums.length;
        if(n>threshold){
            return -1;
        }
        int low=1;
        int high=findMax(nums);
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(findByDivisor(nums,mid)<=threshold){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
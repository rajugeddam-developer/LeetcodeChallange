class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        for(int i=0;i<n;i++){
            int need=target-numbers[i];

            int low=i+1;
            int high=n-1;

            while(low<=high){
                int mid=low+(high-low)/2;
                if(numbers[mid]==need){
                    return new int[]{i+1,mid+1};
                }else if(need < numbers[mid]){
                    high=mid-1;

                }else{
                    low=mid+1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}
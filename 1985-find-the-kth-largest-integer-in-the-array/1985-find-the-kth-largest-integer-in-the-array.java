class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (x,y)->{
            if(x.length()==y.length()){
                return x.compareTo(y);
            }
            return x.length()-y.length();
        });
        return nums[nums.length-k];
    }
}
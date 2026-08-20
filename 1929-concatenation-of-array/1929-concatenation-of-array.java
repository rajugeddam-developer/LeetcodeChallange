class Solution {
    public int[] getConcatenation(int[] nums) {
        int id=0;
        int arr[]=new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            arr[id++]=nums[i];
            arr[i + nums.length] = nums[i];
        }
        
        return arr;
    }
}
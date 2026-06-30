class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n=nums.length;
       HashMap<Integer, Integer> map=new HashMap<>();
       for(int i=0;i<n;i++)
       {
        int currentSum=nums[i];
        int moreneeded=target-currentSum;
        if(map.containsKey(moreneeded)){
            return new int[]{map.get(moreneeded),i};
        }
        map.put(currentSum,i);
       }
       return new int[]{-1,-1};
    }
}
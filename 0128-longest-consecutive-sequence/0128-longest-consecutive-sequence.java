class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int longest=1;
      final  Set<Integer> set =new HashSet<>(nums.length);
        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int count=1;
                int current=num;
                while(set.contains(current+1)){
                    current+=1;
                    count=count+1;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}
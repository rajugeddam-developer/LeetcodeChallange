class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        // int[] bin=new int[nums.length];
        // for(int i=0;i<bin.length;i++){
        //     if(nums[i]%2==0){
        //         bin[i]=0;
        //     }else{
        //         bin[i]=1;
        //     }
        // }
        int count=0;
        map.put(0,1);
        int sum=0;
        for(int num:nums){
            if(num%2!=0){
                sum++;
            }
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
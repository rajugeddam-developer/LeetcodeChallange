class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(0,1);// Initially map has containd prefix sum 0 with frequency 1
        int sum=0;
        int count=0;

        for(int num:nums){

            sum+=num;
            //check if the map contains the prefix sum
            //if it does exist add the frequency to the count;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            //If not exist ads the sum to the map
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
    }
}
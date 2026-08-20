class Solution {
    public boolean containsDuplicate(int[] nums) {
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int i:nums){
        //     map.put(i,map.getOrDefault(i,0)+1);
        // }

        // for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        //     if(entry.getValue()>1){
        //         return true;
        //     }
        // }
        // return false;


        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            if(map.containsKey(num)){
                return true;
            }
            map.put(num,1);
        }
       return false;
    }
}
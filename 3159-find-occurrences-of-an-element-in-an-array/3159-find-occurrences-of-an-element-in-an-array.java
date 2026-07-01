class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                list.add(i);
            }
        }
        int[] pos=new int[queries.length];
        for(int i=0;i<queries.length;i++){
             int q=queries[i];
             if(q>list.size()){
                pos[i]=-1;
             }else{
                pos[i]=list.get(q-1);
             }
        }
        return pos;
        
    }
}
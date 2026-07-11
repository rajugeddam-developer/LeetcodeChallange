class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       HashSet<Integer> set1=new HashSet<>();
       HashSet<Integer> set2=new HashSet<>();
       for(int i:nums1){
        set1.add(i);
       }
       for(int num:nums2){
        if(set1.contains(num)){
     set2.add(num);
        }
       }
       int[] ans=new int[set2.size()];
       int id=0;
       for(int num:set2){
           ans[id++]=num;
       }
      
return ans;
    }
}
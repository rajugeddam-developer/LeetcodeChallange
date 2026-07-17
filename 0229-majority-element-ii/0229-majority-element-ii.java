class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> list=new  ArrayList<>();
        int c1=0,c2=0;
        int e1=0,e2=0;
        //Find the potiential elements
        for(int i=0;i<n;i++){
            if(c1==0 &&e2!=nums[i]){
            e1=nums[i];
            c1=1;
            }else  if(c2==0 && e1!=nums[i]){
                e2=nums[i];
                c2=1;
            }else if(nums[i]==e1){
                c1++;
            }else if(nums[i]==e2){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
         c1=0;
         c2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==e1) c1++;
            if(nums[i]==e2) c2++;
        }
        int need=n/3;
        if(c1>need && e1!=e2) list.add(e1);
        if(c2>need) list.add(e2);
        return list;
}

}
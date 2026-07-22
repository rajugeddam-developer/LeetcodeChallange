class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int prefix=1;
        int suffix=1;
        for(int i=0;i<n;i++){
            if(prefix==0){
                prefix=1;
            }if(suffix==0){
                suffix=1;
            }
            //multiply element from front
            prefix*=nums[i];
            //multiply elelemts form back
            suffix*=nums[n-i-1];
            //keep maiintain the maximum
            max=Math.max(max,Math.max(prefix,suffix));
        }
        return max;
    }
}
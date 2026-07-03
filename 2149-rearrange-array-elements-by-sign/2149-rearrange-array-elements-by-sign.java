class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        //variety 1-> optimal solution ->Equal number  of elements and negative elements
        //this apprach beats the reuntime by 100%
        int[] ans=new int[n];
        int posIndex=0;
        int negIndex=1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans[posIndex]=nums[i];
                posIndex+=2;
            }else{
                ans[negIndex]=nums[i];
                negIndex+=2;
            }
        }
        return ans;

        //variety-2
    //     ArrayList<Integer> pos=new ArrayList<>();
    //       ArrayList<Integer> neg=new ArrayList<>();
    //       for(int i=0;i<n;i++){
    //         if(nums[i]>0){
    //             pos.add(nums[i]);
    //         }else{
    //             neg.add(nums[i]);
    //         }
    //       }
    //       //Handle the unequal pairings
    //       if(pos.size()>neg.size()){
    //         //if positives  are more than negatives
    //         for(int i=0;i<neg.size();i++){
    //             nums[2*i]=pos.get(i);
    //             nums[2*i+1]=neg.get(i);
    //         }
    //         //add left over positive elements
    //         int index=neg.size()*2;
    //         for(int i=neg.size();i>pos.size();i++){
    //             nums[index]=pos.get(i);
    //             index++;
    //         }
    //         }else{
    //         //if negatives  are more than positives
    //         for(int i=0;i<pos.size();i++){
    //             nums[2*i]=pos.get(i);
    //             nums[2*i+1]=neg.get(i);
    //         }
    //         //add left over positive elements
    //         int index=pos.size()*2;
    //         for(int i=pos.size();i>neg.size();i++){
    //             nums[index]=neg.get(i);
    //             index++;
    //         }
    //         }
          
    // return nums;
    //This approach is beats the 87%
    }
}
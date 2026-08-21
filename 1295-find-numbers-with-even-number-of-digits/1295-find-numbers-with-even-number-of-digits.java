class Solution {
    public int findNumbers(int[] nums) {
    int count=0;
    //Method-1
    // for(int num:nums){
    //     String str=String.valueOf(num);
    //     if(str.length()%2==0){
    //         count++;
    //     }
    // }

    //Methos-2;
    for(int num:nums){
        if((int)Math.log10(num)%2!=0){
            count++;
        }
    }
    return count;
    }
}
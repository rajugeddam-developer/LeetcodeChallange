class Solution {
    //Heleper method to find the total hours for k
    public static long CalculateTotalHours(int[] piles,int k){
        long totalHours=0;
        for(int pile:piles){
            totalHours+=Math.ceil((double)pile/k);
        }
        return totalHours;
    }

    public static int findMax(int[] piles){
        int max=Integer.MIN_VALUE;
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        return max;
    }



    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=findMax(piles);
        int ans=high;
        while(low<=high){
               int mid=low+(high-low)/2;
               long totalHours=CalculateTotalHours(piles,mid);
               if(totalHours<=h){
                  ans=mid;
                   high=mid-1;
               }else{
                  low=mid+1;
                 }
        }
        return ans;
    }
}
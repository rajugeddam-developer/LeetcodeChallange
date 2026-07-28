class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        //method1
        // long low=1;
        // long high=x;
        // long ans=1;
        // while(low<=high){
        //     long mid=low+(high-low)/2;
        //     if(mid*mid<=x){
        //         ans=mid;
        //         low=mid+1;
        //     }else{
        //         high=mid-1;
        //     }
        // }
        // return (int)ans;

        //method2;
        return (int)Math.sqrt(x);
    }
}
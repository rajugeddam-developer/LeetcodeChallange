class Solution {
    public boolean checkDivisibility(int n) {
        return divisibility(n);
    }
   

    public static boolean divisibility(int num){
        int sum=0;
        int product=1;
        int original=num;
        while(num!=0){
        int rem=num%10;
        sum+=rem;
        product*=rem;
        num/=10;
        }
        int result=sum+product;
        return original%result==0;
    }
}
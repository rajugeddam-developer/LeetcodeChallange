class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int num= 'z'-s.charAt(i)+1;
            int j=i+1;
            sum+=num*j;
        }
        return sum;
    }
}
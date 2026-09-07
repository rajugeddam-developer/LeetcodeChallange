class Solution {
    public int distinctSubseqII(String s) {
        int  MOD=1000000007;

        long[]  sub=new long[26];

        for(char ch:s.toCharArray()){
            int id=ch-'a';
            long currentSum=0;
            for(int i=0;i<26;i++){
               currentSum=(currentSum+sub[i])%MOD;
            }
            sub[id]=(currentSum+1)%MOD;
        }

        long total=0;
        for(long num:sub){
            total=(total+num)%MOD;
        }
        return (int)total;
    }
}
class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==1){
            return 1;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int length=0;
        boolean hasOdd=false;
        for(int num:map.values()){
            if(num%2==0){
                length+=num;
            }else{
                length+=num-1;
                hasOdd=true;
            }

            
        }
        if(hasOdd){
                length++;
            }
        return length;
        


    }
}
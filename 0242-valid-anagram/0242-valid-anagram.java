class Solution {
    public boolean isAnagram(String s, String t) {
    char[] ch1=t.toCharArray();
    char[] ch2=s.toCharArray();
    Arrays.sort(ch1);
    Arrays.sort(ch2);
    String sort=new String(ch1);
    String sort2=new String(ch2);
        if(sort.equals(sort2)){
            return true;
        }else{
            return false;
        }
    }
}
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        //step-1: clone the array
        int[] ans=arr.clone();
        Arrays.sort(ans);
        HashMap<Integer,Integer> map=new HashMap<>();
        int rank=1;
        for(int i:ans){
            if(!map.containsKey(i)){
                map.put(i,rank);
                rank++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}
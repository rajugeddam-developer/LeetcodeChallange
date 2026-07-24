class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0,r=n-1;
        int Area=0;
        while(l<r){
            int h=Math.min(height[l],height[r]);
            int width=r-l;
            Area=Math.max(Area,h*width);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return Area;

    }
}
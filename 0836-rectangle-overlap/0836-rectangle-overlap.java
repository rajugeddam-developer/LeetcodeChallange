class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ix1 = Math.max(rec1[0], rec2[0]);
        int iy1 = Math.max(rec1[1], rec2[1]);
        int ix2 = Math.min(rec1[2], rec2[2]);
        int iy2 = Math.min(rec1[3], rec2[3]);

        int width  = ix2 - ix1;
        int height = iy2 - iy1;

        return width > 0 && height > 0;
    }
}
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the point on the rectangle closest to the circle center
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        int nearestY = Math.max(y1, Math.min(yCenter, y2));
        
        // Calculate the distance vector components from the closest point to the center
        int dx = xCenter - nearestX;
        int dy = yCenter - nearestY;
        
        // Compare squared distance with squared radius to avoid floating-point operations
        return (dx * dx + dy * dy) <= (radius * radius);
    }
}
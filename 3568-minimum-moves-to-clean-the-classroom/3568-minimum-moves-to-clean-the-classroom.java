import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();
        
        // Locate Start position and index all Litter positions
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litters.add(new int[]{r, c});
                }
            }
        }
        
        int totalLitter = litters.size();
        int targetMask = (1 << totalLitter) - 1;
        
        // If there's no litter, 0 moves needed
        if (totalLitter == 0) return 0;
        
        // Map litter coordinates to bit index
        int[][] litterIdx = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(litterIdx[i], -1);
        for (int i = 0; i < totalLitter; i++) {
            litterIdx[litters.get(i)[0]][litters.get(i)[1]] = i;
        }
        
        // visited[r][c][mask] stores maximum energy remaining for state (r, c, mask)
        int[][][] visited = new int[m][n][1 << totalLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }
        
        // Queue for BFS storing {r, c, mask, current_energy}
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize start position state
        int initialMask = 0;
        visited[startR][startC][initialMask] = energy;
        queue.offer(new int[]{startR, startC, initialMask, energy});
        
        int moves = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int e = curr[3];
                
                if (mask == targetMask) {
                    return moves;
                }
                
                // If out of energy and not on 'R', cannot make further moves
                if (e == 0) continue;
                
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                        int nextEnergy = e - 1;
                        int nextMask = mask;
                        char nextChar = classroom[nr].charAt(nc);
                        
                        // Pick up litter if present
                        if (nextChar == 'L') {
                            int idx = litterIdx[nr][nc];
                            if (idx != -1) {
                                nextMask |= (1 << idx);
                            }
                        }
                        
                        // Reset energy capacity if stepping on 'R'
                        if (nextChar == 'R') {
                            nextEnergy = energy;
                        }
                        
                        // Only proceed if this state provides strictly more energy
                        if (nextEnergy > visited[nr][nc][nextMask]) {
                            visited[nr][nc][nextMask] = nextEnergy;
                            queue.offer(new int[]{nr, nc, nextMask, nextEnergy});
                        }
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}
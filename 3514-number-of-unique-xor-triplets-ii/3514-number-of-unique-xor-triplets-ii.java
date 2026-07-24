class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] one = new boolean[MAX];
        boolean[] two = new boolean[MAX];
        boolean[] three = new boolean[MAX];

        // XOR using one element
        for (int num : nums) {
            one[num] = true;
        }

        // XOR using two elements
        for (int x = 0; x < MAX; x++) {
            if (!one[x]) continue;

            for (int num : nums) {
                two[x ^ num] = true;
            }
        }

        // XOR using three elements
        for (int x = 0; x < MAX; x++) {
            if (!two[x]) continue;

            for (int num : nums) {
                three[x ^ num] = true;
            }
        }

        int ans = 0;
        for (boolean b : three) {
            if (b) ans++;
        }

        return ans;
    }
}
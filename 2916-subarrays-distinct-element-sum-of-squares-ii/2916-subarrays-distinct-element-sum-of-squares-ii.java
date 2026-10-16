import java.util.Arrays;

class Solution {
    private static final int MOD = 1000000007;

    static class SegmentTree {
        long[] sum;
        long[] sumSq;
        long[] lazy;

        SegmentTree(int n) {
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void push(int node, int l, int r) {
            if (lazy[node] != 0) {
                int mid = (l + r) / 2;
                apply(2 * node, l, mid, lazy[node]);
                apply(2 * node + 1, mid + 1, r, lazy[node]);
                lazy[node] = 0;
            }
        }

        void apply(int node, int l, int r, long val) {
            long len = (r - l + 1);
            long term1 = (2 * val % MOD * sum[node]) % MOD;
            long term2 = (val * val % MOD) * (len % MOD) % MOD;
            sumSq[node] = (sumSq[node] + term1 + term2) % MOD;
            
            long term3 = (val * (len % MOD)) % MOD;
            sum[node] = (sum[node] + term3) % MOD;

            lazy[node] = (lazy[node] + val) % MOD;
        }

        void update(int node, int l, int r, int ql, int qr, long val) {
            if (ql > r || qr < l) return;
            if (ql <= l && r <= qr) {
                apply(node, l, r, val);
                return;
            }
            push(node, l, r);
            int mid = (l + r) / 2;
            update(2 * node, l, mid, ql, qr, val);
            update(2 * node + 1, mid + 1, r, ql, qr, val);
            sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
            sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);
        int[] lastPos = new int[100005];
        Arrays.fill(lastPos, -1);
        
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            int last = lastPos[nums[i]];
            st.update(1, 0, n - 1, last + 1, i, 1);
            lastPos[nums[i]] = i;
            totalSum = (totalSum + st.sumSq[1]) % MOD;
        }

        return (int) totalSum;
    }
}
class Solution {
    static class Node {
        int prod;
        int[] cnt; // cnt[rem] = number of prefixes in this segment with remainder rem

        Node(int k) {
            this.prod = 1;
            this.cnt = new int[k];
        }
    }

    private int k;
    private Node[] tree;

    private Node merge(Node left, Node right) {
        Node parent = new Node(k);
        parent.prod = (left.prod * right.prod) % k;

        // Copy prefixes that lie entirely in the left child
        for (int r = 0; r < k; r++) {
            parent.cnt[r] = left.cnt[r];
        }

        // Add prefixes that span into the right child
        for (int r = 0; r < k; r++) {
            if (right.cnt[r] > 0) {
                int combinedRem = (left.prod * r) % k;
                parent.cnt[combinedRem] += right.cnt[r];
            }
        }

        return parent;
    }

    private void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            tree[node] = new Node(k);
            int rem = nums[start] % k;
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, nums);
        build(2 * node + 1, mid + 1, end, nums);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int rem = val % k;
            tree[node].prod = rem;
            java.util.Arrays.fill(tree[node].cnt, 0);
            tree[node].cnt[rem] = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        if (start <= idx && idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node queryTree(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return null;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        Node leftResult = queryTree(2 * node, start, mid, l, r);
        Node rightResult = queryTree(2 * node + 1, mid + 1, end, l, r);

        if (leftResult == null) return rightResult;
        if (rightResult == null) return leftResult;

        return merge(leftResult, rightResult);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        int n = nums.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update array element
            update(1, 0, n - 1, idx, val);

            // Query remainder count for range [start, n - 1]
            Node res = queryTree(1, 0, n - 1, start, n - 1);
            ans[i] = res.cnt[x];
        }

        return ans;
    }
}
import java.util.*;

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int[] parent = new int[n];
        int[] depth = new int[n];
        int[] sz = new int[n];
        int[] heavy = new int[n];
        Arrays.fill(heavy, -1);

        int[] order = new int[n];
        int orderSize = 0;
        boolean[] vis = new boolean[n];
        int[] stack = new int[n];
        int top = -1;

        stack[++top] = 0;
        parent[0] = -1;
        depth[0] = 0;
        vis[0] = true;

        while (top >= 0) {
            int u = stack[top--];
            order[orderSize++] = u;

            for (int i = adj[u].size() - 1; i >= 0; i--) {
                int v = adj[u].get(i);
                if (!vis[v]) {
                    vis[v] = true;
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    stack[++top] = v;
                }
            }
        }

        Arrays.fill(sz, 1);
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            int maxSz = 0;
            int p = parent[u];
            for (int v : adj[u]) {
                if (v != p) {
                    sz[u] += sz[v];
                    if (sz[v] > maxSz) {
                        maxSz = sz[v];
                        heavy[u] = v;
                    }
                }
            }
        }

        int[] head = new int[n];
        int[] pos = new int[n];
        int[] invPos = new int[n];
        int curPos = 0;

        int[] stNode = new int[n];
        int[] stHead = new int[n];
        int stTop = -1;

        stNode[++stTop] = 0;
        stHead[stTop] = 0;

        while (stTop >= 0) {
            int u = stNode[stTop];
            int h = stHead[stTop];
            stTop--;

            head[u] = h;
            pos[u] = curPos;
            invPos[curPos++] = u;

            int hChild = heavy[u];
            for (int i = adj[u].size() - 1; i >= 0; i--) {
                int v = adj[u].get(i);
                if (v != parent[u] && v != hChild) {
                    stNode[++stTop] = v;
                    stHead[stTop] = v;
                }
            }
            if (hChild != -1) {
                stNode[++stTop] = hChild;
                stHead[stTop] = h;
            }
        }

        int[] tree = new int[4 * n];
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            mask[i] = 1 << (s.charAt(i) - 'a');
            updateTree(tree, 1, 0, n - 1, pos[i], mask[i]);
        }

        List<Boolean> result = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                int cMask = 1 << (parts[2].charAt(0) - 'a');
                mask[u] = cMask;
                updateTree(tree, 1, 0, n - 1, pos[u], cMask);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int pathMask = queryPath(u, v, n, head, parent, depth, pos, tree);
                result.add((pathMask & (pathMask - 1)) == 0);
            }
        }
        return result;
    }

    private void updateTree(int[] tree, int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (start <= idx && idx <= mid) {
            updateTree(tree, 2 * node, start, mid, idx, val);
        } else {
            updateTree(tree, 2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private int queryTree(int[] tree, int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return queryTree(tree, 2 * node, start, mid, l, r) ^ queryTree(tree, 2 * node + 1, mid + 1, end, l, r);
    }

    private int queryPath(int u, int v, int n, int[] head, int[] parent, int[] depth, int[] pos, int[] tree) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u; u = v; v = temp;
            }
            res ^= queryTree(tree, 1, 0, n - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp;
        }
        res ^= queryTree(tree, 1, 0, n - 1, pos[u], pos[v]);
        return res;
    }
}
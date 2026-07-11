import java.util.*;

class Solution {

    private List<List<Integer>> graph;
    private boolean[] visited;

    private int vertexCount;
    private int degreeSum;

    public int countCompleteComponents(int n, int[][] edges) {

        // Step 1: Create Graph
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Build Adjacency List
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 3: Visited Array
        visited = new boolean[n];

        int completeComponents = 0;

        // Step 4: Traverse every node
        for (int node = 0; node < n; node++) {

            if (!visited[node]) {

                vertexCount = 0;
                degreeSum = 0;

                dfs(node);

                // Check if component is complete
                if (degreeSum == vertexCount * (vertexCount - 1)) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private void dfs(int node) {

        visited[node] = true;

        vertexCount++;

        degreeSum += graph.get(node).size();

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
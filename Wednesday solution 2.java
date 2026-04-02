class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // time : O(n + e), n = no of nodes and edges
        // space : O(n + e) , n = no of nodes and edges - ArrayList, Array, Stack - data structures

        // edges - [[0,1],[1,2], [2,0]]
        // graph - {0 : [1,2], 1: [0,2], 2: [0,1]}

        // Build graph
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            
            graph.get(src).add(dst);
            graph.get(dst).add(src); 
        }

        // visited set - to keep track of visited node
        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(List<List<Integer>> graph, int curr, int destination, boolean[] visited) {
        // Breaking Point
        if (curr == destination) return true;

        visited[curr] = true;

        for (int neighbor : graph.get(curr)) {
            if (visited[neighbor] == false) {
                if (dfs(graph, neighbor, destination, visited) == true) {
                    return true;
                }
            }
        }

        // Breaking Point
        return false;
    }
}
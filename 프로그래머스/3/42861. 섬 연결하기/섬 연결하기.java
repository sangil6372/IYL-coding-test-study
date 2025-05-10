import java.util.*;

class Solution {

    private int[] parent;

    public int solution(int n, int[][] costs) {
        int totalCost = 0;

        // 1. 부모 노드 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 2. 비용을 기준으로 간선 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        int edgesSelected = 0;

        // 3. 간선 선택 (Kruskal 알고리즘)
        for (int[] cost : costs) {
            int node1 = cost[0];
            int node2 = cost[1];
            int bridgeCost = cost[2];

            // 두 노드가 같은 집합에 속하지 않는 경우에만 간선 선택
            if (find(node1) != find(node2)) {
                union(node1, node2);
                totalCost += bridgeCost;
                edgesSelected++;

                // MST 완성 (n-1개의 간선을 선택하면 종료)
                if (edgesSelected == n - 1) {
                    break;
                }
            }
        }

        return totalCost;
    }

    // Find 연산 (경로 압축 최적화)
    private int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    // Union 연산
    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            parent[root2] = root1;
        }
    }
}

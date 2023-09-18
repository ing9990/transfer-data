package 프로그래머스.l3.네트워크;

public class Main {
    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int ans = new Solution().solution(3, computers);
        System.out.println(ans);
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        int[] visited = new int[n + 1];
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == 0) {
                visited = dfs(computers, i, visited);
                visited[n]++;
            }
        }
        return visited[n];
    }

    private int[] dfs(int[][] computers, int i, int[] visited) {
        visited[i] = 1;

        for (int j = 0; j < computers[i].length; j++)
            if (i != j && visited[j] == 0 && computers[i][j] == 1)
                dfs(computers, j, visited);

        return visited;
    }
}

package 프로그래머스.l2.프랜즈블록;

public class Main {
    public static void main(String[] args) {


    }
}

class Solution {
    static char[][] map;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        map = new char[m][n];

        for (int i = 0; i < m; i++) {
            String b = board[i];
            for (int j = 0; j < n; j++) {
                map[i][j] = b.charAt(j);
            }
        }


        for (int i = 1; i <= m; i++) {
            String b = board[i];
            for (int j = 1; j <= n; j++) {
                char now = b.charAt(j);
            }
        }


        return answer;
    }
}

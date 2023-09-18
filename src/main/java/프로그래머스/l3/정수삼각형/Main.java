package 프로그래머스.l3.정수삼각형;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}};
        int ans = new Solution().solution(arr);

        System.out.println(ans);
    }
}



class Solution {
    public int solution(int[][] triangle) {
        int heigth = triangle.length;
        int answer = 0;
        int[][] dp = new int[heigth][heigth];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < heigth; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        for (int i = 0; i < heigth; i++)
            answer = Math.max(dp[heigth - 1][i], answer);

        return answer;
    }
}
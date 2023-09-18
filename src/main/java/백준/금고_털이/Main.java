package 백준.금고_털이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] initialState = new int[N]; // 초기 상태


        for (int i = 0; i < N; i++) {
            initialState[i] = Integer.parseInt(s2[i]);
        }


        System.out.println(Arrays.toString(initialState));

        int[] visited = new int[M]; // 방문 여부 및 최소 시간 기록
        Queue<int[]> queue = new ArrayDeque<>();

        // 초기 상태를 큐에 추가
        queue.add(initialState);
        visited[calculateHash(initialState)] = 0;

        while (!queue.isEmpty()) {
            int[] currentState = queue.poll();

            // 모든 회전판을 돌린 경우
            boolean allEqual = true;
            for (int i = 0; i < N - 1; i++) {
                if (currentState[i] != currentState[i + 1]) {
                    allEqual = false;
                    break;
                }
            }

            if (allEqual) {
                System.out.println(visited[calculateHash(currentState)]);
                return;
            }

            // 한 회전판을 한 번에 여러 칸 돌린 경우를 모두 계산
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= M; j++) {
                    int[] nextState = currentState.clone();
                    nextState[i] = (nextState[i] + j) % M;

                    int hash = calculateHash(nextState);

                    if (visited[hash] == 0) {
                        visited[hash] = visited[calculateHash(currentState)] + 1;
                        queue.add(nextState);
                    }
                }
            }
        }

        // 금고를 열 수 없는 경우
        System.out.println(-1);
    }

    // 회전판 상태를 해시 값으로 변환하는 함수
    private static int calculateHash(int[] state) {
        int hash = 0;
        int multiplier = 1;

        for (int i = 0; i < state.length; i++) {
            hash = (hash + state[i] * multiplier) % 10007;
            multiplier = (multiplier * 10007) % 10007;
        }

        return hash;
    }
}

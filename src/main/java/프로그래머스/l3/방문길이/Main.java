package 프로그래머스.l3.방문길이;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int answer = new Solution().solution("ULURRDLLU");
        System.out.println("answer: " + answer);
    }
}

class Solution {
    static Map<String, Integer> visited = new HashMap<>();
    static int[] pos = {0, 0};

    public int go(char c) {
        System.out.println(visited);

        String bf = pos[0] + "" + pos[1];

        if (c == 'L') {
            pos[0] -= 1;
        } else if (c == 'R') {
            pos[0] += 1;
        } else if (c == 'D') {
            pos[1] -= 1;
        } else if (c == 'U') {
            pos[1] += 1;
        }

        String af = pos[0] + "" + pos[1];

        if (visited.containsKey(bf + af) || visited.containsKey(af + bf)) {
            return 0;
        }

        visited.put(bf + af, 0);
        visited.put(af + bf, 0);

        return 1;
    }

    public int solution(String dirs) {
        int answer = 0;

        for (char c : dirs.toCharArray()) {
            if (c == 'L') {
                if (pos[0] - 1 == -6) continue;
            } else if (c == 'R') {
                if (pos[0] + 1 == 6) continue;
            } else if (c == 'D') {
                if (pos[1] - 1 == -6) continue;
            } else if (c == 'U') {
                if (pos[1] + 1 == 6) continue;
            }
            answer += go(c);
        }
        return answer;
    }
}

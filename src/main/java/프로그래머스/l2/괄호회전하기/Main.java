package 프로그래머스.l2.괄호회전하기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int first = new Solution().solution("}]()[{");
        //  int two = new Solution().solution("}]()[{");

        System.out.println(first);
    }
}

class Solution {
    List<Character> list = new ArrayList<>();

    Map<Character, Character> map = new HashMap<>(Map.of('(', ')', '{', '}', '[', ']'));

    public int solution(String s) {
        int answer = 0;
        int n = s.length();


        for (int i = 0; i < n; i++) {
            list.add(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            System.out.print(i + "번쨰 회전: " + list);
            if (check(list)) {
                System.out.println("   통과");
                answer++;
            } else {
                System.out.println("   불통");
            }
            char tmp = list.get(0);
            list.add(tmp);
            list.remove(0);
        }

        return answer;
    }

    public boolean check(List<Character> list) {

        Stack<Character> stack = new Stack<>();

        for (char i : list) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            if (map.containsKey(i)) {
                // 열기
                stack.push(i);
            } else {
                // i: 닫기
                // c: 열기
                char c = stack.pop();
                if (!map.containsKey(c) || map.get(c) != i) {
                    stack.push(c);
                    stack.push(i);
                }
            }
        }
        return stack.isEmpty();
    }
}

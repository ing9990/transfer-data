package 프로그래머스.l2.소수_찾기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int i = new Solution().solution("1001");

        System.out.println(i);
    }
}

class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();

        permutation("", numbers, set);

        int count = 0;
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) count++;
            if (a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();

        if (!prefix.isEmpty()) set.add(Integer.valueOf(prefix));

        // 1001
        for (int i = 0; i < n; i++) {
            System.out.println("=> " + prefix + str.charAt(i) + " " + str.substring(0, i) + str.substring(i + 1, n) + " " + set);

            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }

    }
}
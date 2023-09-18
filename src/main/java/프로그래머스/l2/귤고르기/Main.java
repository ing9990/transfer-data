package 프로그래머스.l2.귤고르기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5};
        int k = 1;

        System.out.println(new Solution().solution(k, arr));
    }
}


class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        List<Map.Entry<Integer, Integer>> list = frequencySort(tangerine);
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> now = list.get(i);

            if (k > sum + now.getValue()) {
                sum += now.getValue();
                answer++;
            }
        }

        return answer;
    }

    public static List<Map.Entry<Integer, Integer>> frequencySort(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i : arr) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        System.out.println(sortedEntries);


        return sortedEntries;
    }
}

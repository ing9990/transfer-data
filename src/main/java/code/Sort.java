package code;

import java.util.*;

public class Sort {
    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 2, 4, 2, 2, 4, 4, 4, 1, 4, 4, 4, 3, 10};

        System.out.println(frequencySort(arr));
    }

    // 빈도 수로 정렬
    public static List<Map.Entry<Integer, Integer>> frequencySort(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i : arr) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        return sortedEntries;
    }

    // int[] 정렬
    public static List<Integer> intArrSort(int[] arr) {
        Arrays.sort(arr);

        Integer[] integerList = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        return Arrays.asList(integerList);
    }

    // int[] 역정렬
    public List<Integer> reverseIntArr(int[] arr) {
        Integer[] intArrReverse = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(intArrReverse, Collections.reverseOrder());

        return Arrays.asList(intArrReverse);
    }

    // 조합 구현 (백트래킹)
    static void comb1(int[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            Arrays.toString(arr);
            Arrays.toString(visited);

            return;
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}

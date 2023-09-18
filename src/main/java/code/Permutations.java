package code;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int N = 5; // N개의 요소로 순열 생성

        List<List<Integer>> permutations = permuteN(nums, N);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<List<Integer>> permuteN(int[] nums, int N) {
        List<List<Integer>> result = new ArrayList<>();
        permuteNHelper(nums, N, 0, new ArrayList<>(), result);
        return result;
    }

    private static void permuteNHelper(int[] nums, int N, int start, List<Integer> current, List<List<Integer>> result) {
        if (N == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            permuteNHelper(nums, N - 1, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
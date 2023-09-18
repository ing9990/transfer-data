package code;


import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> combinations = combine(nums, 1);

        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> combine(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineHelper(nums, k, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combineHelper(int[] nums, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            combineHelper(nums, k - 1, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
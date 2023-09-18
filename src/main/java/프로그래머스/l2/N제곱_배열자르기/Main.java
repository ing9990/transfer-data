package 프로그래머스.l2.N제곱_배열자르기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = new Solution().solution2(3, 2, 5);


        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    static int[][] map;

    public void init(int n) {
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = Math.max(i, j) + 1;
            }
        }
    }



    // 메모리 초과요..
    public int[] solution2(int n, long left, long right) {
        init(n);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list.add(map[i][j]);
            }
        }

        Integer[] arr = list.toArray(Integer[]::new);

        int[] intArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArray[i] = arr[i].intValue();
        }

        return Arrays.copyOfRange(intArray, (int) left, (int) right + 1);
    }
}
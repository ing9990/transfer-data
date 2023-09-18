package 백준.보물_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 5
         * 1 1 1 6 0
         * 2 7 8 3 1
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());

        String[] sarr1 = br.readLine().split(" ");
        String[] sarr2 = br.readLine().split(" ");

        int[] arr = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sarr1[i]);
            arr2[i] = Integer.parseInt(sarr2[i]);
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 2; i < n; i++) {
        }
    }
}

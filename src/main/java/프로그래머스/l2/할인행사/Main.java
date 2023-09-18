package 프로그래머스.l2.할인행사;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int ans = new Solution().solution(want, number, discount);
        System.out.println(ans);
    }
}

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        List<String> wantList = new ArrayList<>();

        for (int i = 0; i < want.length; i++) {
            for (int j = 0; j < number[i]; j++) {
                wantList.add(want[i]);
            }
        }


        for (int i = 0; i < discount.length - wantList.size() + 1; i++) {
            List<String> copy = new ArrayList<>(List.copyOf(wantList));

            for (int j = i; j < i + wantList.size(); j++) {
                copy.remove(discount[j]);
                if (copy.isEmpty()) {
                    answer++;
                }
            }
        }

        return answer;
    }
}

package 백준.동전0;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while (n > 0) {
            int coin = coins.get(coins.size() - 1);

            for (int i = 0; i < coins.size(); i++) {
                if (n < coins.get(i)) {
                    coin = coins.get(i - 1);
                    break;
                }
            }
            answer += n / coin;
            n = n % coin;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}

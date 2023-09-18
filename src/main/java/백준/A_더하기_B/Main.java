package 백준.A_더하기_B;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = br.readLine().split(" ");
        int answer = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}

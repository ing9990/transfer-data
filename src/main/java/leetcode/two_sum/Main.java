package leetcode.two_sum;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });

        System.out.println("main => start");
        thread.start();
        System.out.println("main => end");
    }
}

package SoraeCodingMasters.BOJ2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 백준 2164번
 * 카드 2
 * 2024-02-08
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N;
    static Deque<Integer> dq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            dq.offerLast(i);
        }

        while(dq.size() > 1) {
            dq.pollFirst();
            int second = dq.pollFirst();
            dq.offerLast(second);
        }

        System.out.println(dq.pollFirst());
    }

}

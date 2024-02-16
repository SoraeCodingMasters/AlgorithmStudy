package SoraeCodingMasters.BOJ1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/***
 * 백준 1927번
 * 최소 힙
 * 2024-02-16
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 1 <= N <= 100,000
    static Queue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a, b) -> b - a);

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0 && pq.isEmpty()) {
                sb.append(0).append("\n");
            } else if (input == 0) {
                sb.append(pq.poll()).append("\n");
            } else {
                pq.add(input);
            }
        }

        System.out.println(sb);
    }

}

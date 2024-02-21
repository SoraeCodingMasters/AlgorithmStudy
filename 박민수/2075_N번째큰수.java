package SoraeCodingMasters.BOJ2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 백준 2075번
 * N번째 큰 수
 * 2024-02-19
 * 시간 제한 : 1초
 * 메모리 제한 : 12MB
 */

public class Main {
    static int N; // 1 <= N <= 1,500
    static Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 최대 힙
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N; i++) {
            answer = pq.poll();
        }

        System.out.println(answer);
    }

}

package SoraeCodingMasters.B.BOJ13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 백준 13549번
 * 숨바꼭질 3
 * 2024-02-25
 * 시간 제한 : 2초
 * 메모리 제한 : 512MB
 */

public class Main {
    static final int MAX = 100_000;
    static int N, K; // 0 <= N, K <= 100,000
    static Deque<Integer> dq;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dq = new ArrayDeque<>();
        dq.offerLast(N);
        dist[N] = 0;

        while (!dq.isEmpty()) {
            int now = dq.pollFirst();

            if (now == K) {
                System.out.println(dist[now]);
                return;
            }

            // 이미 방문한 위치라면 패스
            int tel = 2 * now;
            if (tel <= MAX + 1 && dist[tel] > dist[now]) {
                dist[tel] = dist[now];
                dq.offerFirst(tel);
            }

            int l = now - 1;
            if (l >= 0 && dist[l] > dist[now] + 1) {
                dist[l] = dist[now] + 1;
                dq.offerLast(l);
            }

            int r = now + 1;
            if (r <= MAX && dist[r] > dist[now] + 1) {
                dist[r] = dist[now] + 1;
                dq.offerLast(r);
            }
        }

    }

}

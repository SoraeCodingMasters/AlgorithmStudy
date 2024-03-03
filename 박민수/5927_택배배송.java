package SoraeCodingMasters.A.BOJ5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/***
 * 백준 5972번
 *
 * 2024-03-02
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N, M; // 1 <= N, M <= 50,000
    static int s, e, w;
    static int[] dist;
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        graph = new List[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, w));
            graph[e].add(new Node(s, w));
        }

        dijkstra(1);

        System.out.println(dist[N]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node c = pq.poll();

            if (dist[c.e] < c.w) continue;

            for (Node n : graph[c.e]) {
                if (dist[n.e] > dist[c.e] + n.w) {
                    dist[n.e] = dist[c.e] + n.w;
                    pq.offer(new Node(n.e, dist[n.e]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int e;
        int w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}

package SoraeCodingMasters.A.BOJ1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * 백준 1238번
 * 파티
 * 2024-03-24
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N, M, X; // 1 <= N <= 1,000 / 1 <= M <= 10,000 / 1 <= X <= N
    static int s, e, v;
    static List<Node>[] graph;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, v));
        }

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist[i][X] + dist[X][i]);
        }

        System.out.println(ans);
    }
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start][start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();

            if (dist[start][n.e] < n.v) continue;

            for (int i = 0; i < graph[n.e].size(); i++) {
                Node next = graph[n.e].get(i);
                if (dist[start][n.e] + next.v < dist[start][next.e]) {
                    dist[start][next.e] = dist[start][n.e] + next.v;
                    pq.add(new Node(next.e, dist[start][next.e]));
                }
            }
        }
    }
    public static class Node implements Comparable<Node> {
        int e;
        int v;

        public Node(int e, int v) {
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.v - o.v;
        }
    }
}
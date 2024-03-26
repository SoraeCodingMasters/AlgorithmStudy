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

public class Main_Dijkstra {
    static int N, M, X; // 1 <= N <= 1,000 / 1 <= M <= 10,000 / 1 <= X <= N
    static int s, e, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node>[] originGraph = new List[N + 1];
        List<SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node>[] reverseGraph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            originGraph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            originGraph[s].add(new SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node(e, v));
            reverseGraph[e].add(new SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node(s, v));
        }

        int[] originDist = dijkstra(originGraph);
        int[] reverseDist = dijkstra(reverseGraph);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, originDist[i] + reverseDist[i]);
        }

        System.out.println(ans);
    }
    public static int[] dijkstra(List<SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node>[] graph) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node> pq = new PriorityQueue<>();
        dist[X] = 0;
        pq.add(new SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node(X, 0));

        while(!pq.isEmpty()) {
            SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node n = pq.poll();

            if (dist[n.e] < n.v) continue;

            for (SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node next : graph[n.e]) {
                if (dist[n.e] + next.v < dist[next.e]) {
                    dist[next.e] = dist[n.e] + next.v;
                    pq.add(new SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node(next.e, dist[next.e]));
                }
            }
        }
        return dist;
    }

    public static class Node implements Comparable<SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node> {
        int e;
        int v;

        public Node(int e, int v) {
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(SoraeCodingMasters.A.BOJ1238.Main_Dijkstra.Node o) {
            return this.v - o.v;
        }
    }
}
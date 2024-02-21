package SoraeCodingMasters.BOJ1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 백준 1260번
 * DFS와 BFS
 * 2024-02-21
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N, M, V; // 1 <= N <= 1,000 / 1 <= M <= 10,000
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        // 오름차순 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V);
        Arrays.fill(visited, false);
        sb.append("\n");
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i = 0; i < graph[start].size(); i++) {
            int next = graph[start].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");

            for(int i = 0; i < graph[current].size(); i++) {
                int next = graph[current].get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}

package SoraeCodingMasters.A.BOJ1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * 백준 1976번
 * 여행 가자
 * 2024-03-20
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 1 <= N <= 200
    static int M; // 1 <= M <= 1,000
    static List<Integer>[] graph;
    static boolean[] visited;
    static Set<Integer> s = new HashSet<>();
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j ++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            start = Integer.parseInt(st.nextToken());
            s.add(start);
        }

        dfs(start);

        if (s.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void dfs (int start) {
        visited[start] = true;
        s.remove(start);

        for (int i = 0; i < graph[start].size(); i++) {
            int n = graph[start].get(i);

            if (!visited[n]) {
                dfs(n);
            }
        }
    }
}
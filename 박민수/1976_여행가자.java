package SoraeCodingMasters.A.BOJ1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * 백준 1976번
 * 여행 가자 (Disjoint Set)
 * 2024-03-20
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 1 <= N <= 200
    static int M; // 1 <= M <= 1,000
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            rank[i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j ++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        boolean flag = false;
        int prev = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (find(prev) != find(cur)) {
                flag = true;
                break;
            }
            prev = cur;
        }

        if (flag) System.out.println("NO");
        else System.out.println("YES");

    }
    public static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) return;

        if (rank[a] < rank[b]) {
            parent[a] = b;
            rank[b] += rank[a];
        } else {
            parent[b] = a;
            rank[a] += rank[b];
        }
    }
}
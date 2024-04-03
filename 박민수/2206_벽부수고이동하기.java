package SoraeCodingMasters.A.BOJ2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * 백준 2206번
 * 벽 부수고 이동하기
 * 2024-03-26
 * 시간 제한 : 2초
 * 메모리 제한 : 192MB
 */

public class Main2 {
    static int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    static int N, M; // 1 <= N, M <= 1,000
    static int[][] map;
    static boolean[][][] visited;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; // 벽을 부시지 않았을 때와 부셨을 때 구분

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        System.out.println(bfs(0, 0));

    }

    public static int bfs(int x, int y) {
        Queue<Coord> q = new LinkedList<>();
        visited[x][y][0] = true;
        q.add(new Coord(x, y, 1, false));
        while(!q.isEmpty()) {
            Coord c = q.poll();

            if (c.x == N - 1 && c.y == M - 1) {
                ans = Math.min(ans, c.v);
                return ans;
            }

            int v = c.v + 1;
            for (int[] d : dir) {
                int nx = c.x + d[0];
                int ny = c.y + d[1];

                if (!check(nx, ny)) continue;

                if (map[nx][ny] == 0 && !c.d && !visited[nx][ny][0]) {
                    q.add(new Coord(nx, ny, v, false));
                    visited[nx][ny][0] = true;
                } else if (map[nx][ny] == 0 && c.d && !visited[nx][ny][1]) {
                    q.add(new Coord(nx, ny, v, true));
                    visited[nx][ny][1] = true;
                } else if (map[nx][ny] == 1 && !c.d) {
                    q.add(new Coord(nx, ny, v, true));
                    visited[nx][ny][1] = true;
                }

            }
        }

        return -1;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static class Coord {
        int x;
        int y;
        int v;
        boolean d;

        public Coord(int x, int y, int v, boolean d) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.d = d;
        }
    }
}
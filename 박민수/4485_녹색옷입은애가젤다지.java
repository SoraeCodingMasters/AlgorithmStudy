package SoraeCodingMasters.A.BOJ4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * 백준 4485번
 * 녹색 옷 입은 애가 젤다지?
 * 2024-03-12
 * 시간 제한 : 1초
 * 메모리 제한 : 256MB
 */

public class Main {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N; // 2 <= N <= 125
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int time = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            map = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            bfs(0, 0);
            sb.append("Problem ").append(time++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(x, y));
        dist[x][y] = map[x][y];

        while (!q.isEmpty()) {
            Location l = q.poll();

            for (int[] d : dir) {
                int nx = l.x + d[0];
                int ny = l.y + d[1];

                if (check(nx, ny) && dist[nx][ny] > dist[l.x][l.y] + map[nx][ny]) {
                    dist[nx][ny] = dist[l.x][l.y] + map[nx][ny];
                    q.add(new Location(nx, ny));
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
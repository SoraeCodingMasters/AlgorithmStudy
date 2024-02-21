package SoraeCodingMasters.BOJ14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/***
 * 백준 14940번
 * 쉬운 최단거리
 * 2024-02-21
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int n, m; // 1 <= n, m <= 1,000
    static int[][] map;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int sx, sy;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 2][m + 2];

        // init
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                int input = Integer.parseInt(st.nextToken());
                // 시작 지점
                if (input == 2) {
                    sx = i;
                    sy = j;
                } else if (input == 1) {
                    map[i][j] = -input;
                } else {
                    map[i][j] = input;
                }
            }
        }

        shortestPath();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void shortestPath() {
        Deque<Coord> q = new LinkedList<>();
        map[sx][sy] = count;
        q.add(new Coord(sx, sy, count + 1));

        while(!q.isEmpty()) {
            Coord c = q.poll();

            for (int i = 0; i < dir.length; i++) {
                int nextX = c.x + dir[i][0];
                int nextY = c.y + dir[i][1];

                if (map[nextX][nextY] == -1) {
                    map[nextX][nextY] = c.count;
                    q.add(new Coord(nextX, nextY, c.count + 1));
                }
            }
        }
    }

    public static class Coord {
        int x;
        int y;
        int count;

        public Coord(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}

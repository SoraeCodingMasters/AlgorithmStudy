package SoraeCodingMasters.A.BOJ4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 백준 4179번
 * 불!
 * 2024-03-17
 * 시간 제한 : 1초
 * 메모리 제한 : 256MB
 */

// 사람이 불 보다 빨리 도착할 수 있는가 ?

public class Main {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int R, C; // 1 <= R, C <= 1,000
    static char[][] map;
    static int[][] fm;
    static int[][] hm;
    static Queue<Location> f = new LinkedList<>();
    static Queue<Location> h = new LinkedList<>();
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fm = new int[R][C];
        hm = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j];

                if (map[i][j] == 'J') {
                    hm[i][j] = 1;
                    h.add(new Location(i, j, 1));
                }

                if (map[i][j] == 'F') {
                    fm[i][j] = 1;
                    f.add(new Location(i, j, 1));
                }
            }
        }

        // 불에 대한 bfs
        fbfs();
        fmprint();

        // 사람에 대한 bfs
        hbfs();
        hmprint();

        if (ans == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
        else System.out.println(ans);
    }

    public static void fbfs() {

        while(!f.isEmpty()) {
            Location l = f.poll();

            for (int[] d : dir) {
                int nx = l.x + d[0];
                int ny = l.y + d[1];

                // 조건식의 나열이 오래걸리는 연산인가 ?
                if (check(nx, ny) && (map[nx][ny] == '.' || map[nx][ny] == 'J') && fm[nx][ny] == 0) {
                    fm[nx][ny] = l.step + 1;
                    f.add(new Location(nx, ny, l.step + 1));
                }
            }

        }
    }

    public static void hbfs() {

        while(!h.isEmpty()) {
            Location l = h.poll();

            if (isGoal(l.x, l.y)) {
                ans = Math.min(ans, l.step);
                break;
            }

            for (int[] d : dir) {
                int nx = l.x + d[0];
                int ny = l.y + d[1];

                if (check(nx, ny) && map[nx][ny] == '.' && hm[nx][ny] == 0 && (fm[nx][ny] == 0 || fm[nx][ny] > l.step + 1)) {
                    hm[nx][ny] = l.step + 1;
                    h.add(new Location(nx, ny, l.step + 1));
                }
            }
        }
    }
    public static boolean isGoal(int x, int y) {return x == 0 || x == R - 1 || y == 0 || y == C - 1;}

    public static boolean check(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    public static class Location {
        int x;
        int y;
        int step;
        public Location(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public static void fmprint() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(fm[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void hmprint() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(hm[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
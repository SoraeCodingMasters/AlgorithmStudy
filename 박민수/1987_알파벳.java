package SoraeCodingMasters.A.BOJ1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 1987번
 * 알파벳
 * 2024-03-14
 * 시간 제한 : 2초
 * 메모리 제한 : 256MB
 */

public class Main {
    static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int R, C; // 1 <= R, C <= 20
    static char[][] map;
    static boolean[] alphabet;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        alphabet = new boolean[26];
        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i] = input;
            }
        }
        alphabet[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(ans);
    }

    public static void dfs(int x, int y, int step) {
        ans = Math.max(ans, step);

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (check(nx, ny)) {
                int index = map[nx][ny] - 'A';

                if (!alphabet[index]) {
                    alphabet[index] = true;
                    dfs(nx, ny, step + 1);
                    alphabet[index] = false;
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
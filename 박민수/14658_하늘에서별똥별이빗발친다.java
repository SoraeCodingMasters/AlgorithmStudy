package SoraeCodingMasters.B.BOJ14658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 백준 14685번
 * 하늘에서 별똥별이 빗발친다
 * 2024-03-25
 * 시간 제한 : 2초
 * 메모리 제한 : 256MB
 */

public class Main {
    static int N, M, L, K; // 1 <= N, M <= 500,000 / 1 <= L <= 100,000 / 1 <= K <= 100
    static int x, y;
    static int lx, ly, rx, ry;
    static Coord[] stars;
    static boolean[][] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new Coord[K];
        visited = new boolean[K][K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            stars[i] = new Coord(x, y);
        }

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                Coord a = stars[i];
                Coord b = stars[j];

                int temp = 0;
                int lx = Math.min(a.x, b.x);
                int ly = Math.min(a.y, b.y);

                for (int k = 0; k < K; k++) {
                    Coord c = stars[k];
                    if (lx <= c.x && c.x <= lx + L && ly <= c.y && c.y <= ly + L) temp++;
                }
                ans = Math.max(ans, temp);
            }
        }
        System.out.println(K - ans);
    }

    public static class Coord implements Comparable<Coord> {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coord o) {
            return this.x - o.x;
        }
    }
}
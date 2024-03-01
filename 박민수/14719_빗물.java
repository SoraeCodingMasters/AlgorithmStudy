package SoraeCodingMasters.B.BOJ14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 14719번
 * 빗물
 * 2024-03-01
 * 시간 제한 : 1초
 * 메모리 제한 : 256MB
 */

public class Main {
    static int H, W; // 1 <= H, W <= 500
    static int[] worlds;
    static int high = -1;
    static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        worlds = new int[W];

        st = new StringTokenizer(br.readLine());
        int highValue = Integer.MIN_VALUE;
        for (int i = 0; i < W; i++) {
            worlds[i] = Integer.parseInt(st.nextToken());

            if (worlds[i] > highValue) {
                highValue = worlds[i];
                high = i;
            }
        }

        int l = 0;
        int r = 0;
        while (r < high) {
            if (worlds[l] > worlds[r + 1]) {
                total += worlds[l] - worlds[r + 1];
                r++;
            } else {
                l = ++r;
            }
        }

        l = W - 1;
        r = W - 1;
        while (high < l) {
            if (worlds[r] > worlds[l - 1]) {
                total += worlds[r] - worlds[l - 1];
                l--;
            } else {
                r = --l;

            }
        }

        System.out.println(total);
    }
}

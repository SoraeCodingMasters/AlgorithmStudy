package SoraeCodingMasters.A.BOJ1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 1027번
 * 고층 건물
 * 2024-03-21
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 1 <= N <= 50
    static int[] buildings;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                boolean isIn = true;

                if (i == j) continue;

                if (i > j) {
                    for (int k = j + 1; k < i; k++) {
                        if (linear(j, i, k)) {
                            isIn = false;
                            break;
                        }
                    }
                } else {
                    for (int k = i + 1; k < j; k++) {
                        if (linear(i, j, k)) {
                            isIn = false;
                            break;
                        }
                    }
                }

                if (isIn) temp++;
            }
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }

    public static boolean linear(int x1, int x2, int tx) {
        int y1 = buildings[x1];
        int y2 = buildings[x2];
        int ty = buildings[tx];

        return ((double) (y2 - y1) / (x2 - x1)) * (tx - x1) + y1 <= ty;
    }
}
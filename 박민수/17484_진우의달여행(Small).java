package SoraeCodingMasters.BOJ17484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 백준 17484번
 * 진우의 달 여행(Small)
 * 2024-02-13
 * 시간 제한 : 1초
 * 메모리 제한 : 256MB
 */

public class Main {
    static final int MAX_VALUE = 1000;
    static int N, M; // 2 <= N, M <= 6
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // init dp
                if (i == 0) {
                    Arrays.fill(dp[i][j], map[i][j]);
                }
            }
        }


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][0] = MAX_VALUE;
                    dp[i][j][1] = map[i][j] + dp[i - 1][j][2];
                    dp[i][j][2] = map[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                } else if (j >= 1 && j < M - 1) {
                    dp[i][j][0] = map[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                    dp[i][j][1] = map[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                    dp[i][j][2] = map[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                } else {
                    dp[i][j][0] = map[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                    dp[i][j][1] = map[i][j] + dp[i - 1][j][0];
                    dp[i][j][2] = MAX_VALUE;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(answer, dp[N - 1][i][j]);
            }
        }

        System.out.println(answer);
    }

}

package SoraeCodingMasters.BOJ21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 21921번
 * 블로그
 * 2024-02-11
 * 시간 제한 : 1초
 * 메모리 제한 : 512MB
 */

public class Main {
    static int X, N; // 1 <= X <= N <= 250,000
    static int[] visitors;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visitors = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        for (int i = 0; i < X; i++) {
            dp[0] += visitors[i];
        }

        for(int i = 1; i <= N - X; i++) {
            dp[i] = dp[i - 1] + visitors[i + X - 1] - visitors[i - 1];
        }

        int count = 0;
        int maxVisitor = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (maxVisitor < dp[i]) {
                maxVisitor = dp[i];
                count = 1;
            } else if (maxVisitor == dp[i]) {
                count++;
            }
        }

        if (maxVisitor == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitor + "\n" + count);
        }
    }

}

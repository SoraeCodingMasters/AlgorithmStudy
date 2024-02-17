package SoraeCodingMasters.BOJ11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 11501번
 * 주식
 * 2024-02-17
 * 시간 제한 : 5초
 * 메모리 제한 : 256MB
 */

public class Main {
    static int T;
    static int N; // 2 <= N <= 1,000,000
    static int[] chart;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // O(T)
        while (T-- > 0) {
            // init
            N = Integer.parseInt(br.readLine());
            chart = new int[N];
            st = new StringTokenizer(br.readLine());
            // O(N)
            for(int i = 0; i < N; i++) {
                chart[i] = Integer.parseInt(st.nextToken());
            }

            // O(N^2)
            sb.append(calculateBenefit(0, N)).append("\n");
        }
        System.out.println(sb);
    }

    public static long calculateBenefit(int s, int e) {

        // 종료 조건 : 모든 배열을 탐색한 경우
        if (s >= e) {
            return 0;
        }
        // O(N)
        int index = findIndex(s, e);

        long benefit = 0;
        for (int i = s; i < index; i++) {
            benefit += (chart[index] - chart[i]);
        }
        // O(N)
        return benefit + calculateBenefit(index + 1, e);
    }

    public static int findIndex(int s, int e) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = s; i < e; i++) {
            if (maxValue < chart[i]) {
                maxValue = chart[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}

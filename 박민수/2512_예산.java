package SoraeCodingMasters.BOJ2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 2512번
 * 예산
 * 2024-02-09
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 3 <= N <= 10,000
    static int[] request;
    static int[] budget;
    static int M; // N <= M <= 100,000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        request = new int[N];
        int maxRequest = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            request[i] = Integer.parseInt(st.nextToken());
            maxRequest = Math.max(maxRequest, request[i]);
        }

        M = Integer.parseInt(br.readLine());

        int fix = binarySearch(1, maxRequest);

        System.out.println(fix);
    }

    public static int binarySearch(int left, int right) {
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (!calculateBudget(mid)) {
                // 예산 부족
                left = mid + 1;
                result = mid;
            } else {
                // 예산 초과
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean calculateBudget(int mid) {
        int total = 0;

        for (int i = 0; i < N; i++) {
            total += Math.min(mid, request[i]);
        }

        return total > M;
    }
}

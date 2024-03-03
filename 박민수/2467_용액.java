package SoraeCodingMasters.A.BOJ2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 2467번
 * 용액
 * 2024-03-03
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 2 <= N <= 100,000
    static int[] solutions;
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        solutions = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        int mix = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            int l = i + 1;
            int r = N - 1;
            while(l <= r) {
                int mid = (l + r) / 2;
                int sum = solutions[i] + solutions[mid];
                int abs = Math.abs(sum);

                if (mix > abs) {
                    a = solutions[i];
                    b = solutions[mid];
                    mix = abs;
                }

                if (sum > 0) {
                    r = mid - 1;
                } else if (sum < 0) {
                    l = mid + 1;
                } else break;
            }
        }

        System.out.println(a + " " + b);
    }

}

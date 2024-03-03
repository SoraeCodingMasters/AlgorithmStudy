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

        int l = 0;
        int r = N - 1;
        int mix = Integer.MAX_VALUE;
        while(l < r) {
            int sum = solutions[l] + solutions[r];
            int abs = Math.abs(sum);

            if (sum > 0) {
                if (mix >= abs) {
                    mix = abs;
                    a = solutions[l];
                    b = solutions[r];
                }
                r--;
            } else if (sum == 0) {
                a = solutions[l];
                b = solutions[r];
                break;
            } else {
                if (mix >= abs) {
                    mix = abs;
                    a = solutions[l];
                    b = solutions[r];
                }
                l++;
            }
        }

        System.out.println(a + " " + b);
    }

}

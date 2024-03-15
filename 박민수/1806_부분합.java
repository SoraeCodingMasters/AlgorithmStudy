package SoraeCodingMasters.A.BOJ1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/***
 * 백준 1806번
 * 부분합 (Two Pointer)
 * 2024-03-14
 * 시간 제한 : 0.5초 (java 11 -> 1초)
 * 메모리 제한 : 128MB
 */

public class TP {
    static int N, S; // 10 <= N <= 100,000 / 0 <= S <= 100,000,000
    static int[] arr;
    static int cur = 0;
    static int minLen = Integer.MAX_VALUE;

    // 5 5
    // 1 4 5 3 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;

        while(l <= r && r < N) {
            cur += arr[r++];

            if (cur >= S) {
                while(cur - arr[l] >= S) {
                    cur -= arr[l++];
                }

                minLen = Math.min(minLen, r - l);
            }

        }


        StringBuilder sb = new StringBuilder();
        if (minLen == Integer.MAX_VALUE) sb.append(0);
        else sb.append(minLen);

        System.out.println(sb);
    }
}

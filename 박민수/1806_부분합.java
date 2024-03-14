package SoraeCodingMasters.A.BOJ1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/***
 * 백준 1806번
 * 부분합
 * 2024-03-14
 * 시간 제한 : 0.5초 (java 11 -> 1초)
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N, S; // 10 <= N <= 100,000 / 0 <= S <= 100,000,000
    static Deque<Integer> dq;
    static int cur = 0;
    static int minLen = Integer.MAX_VALUE;

    // 5 5
    // 1 4 5 3 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int item = Integer.parseInt(st.nextToken());
            if (cur + item < S) {
                cur += item;
                dq.offerLast(item);
            } else {
                cur += item;
                dq.offerLast(item);

                while(!dq.isEmpty() && cur - dq.peekFirst() >= S) {
                    cur -= dq.pollFirst();
                }

                minLen = Math.min(minLen, dq.size());
            }
        }

        StringBuilder sb = new StringBuilder();
        if (minLen == Integer.MAX_VALUE) sb.append(0);
        else sb.append(minLen);

        System.out.println(sb);
    }
}
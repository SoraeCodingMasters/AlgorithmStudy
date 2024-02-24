package SoraeCodingMasters.BOJ2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/***
 * 백준 2531번
 * 회전 초밥
 * 2024-02-24
 * 시간 제한 : 1초
 * 메모리 제한 : 256MB
 */

public class Main {
    static int N; // 2 <= N <= 30,000
    static int d; // 2 <= d <= 3,000
    static int k; // 2 <= k <= 3,000
    static int c; // 1 <= c <= d
    static int[] sushi;
    static Set<Integer> sort;
    static int total = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int l = 0;

        while(l < N) {
            sort = new HashSet<>();
            for (int i = l; i < l + k; i++) {
                sort.add(sushi[(i % N)]);
            }
            sort.add(c);
            total = Math.max(total, sort.size());
            l++;
        }

        System.out.println(total);
    }

}

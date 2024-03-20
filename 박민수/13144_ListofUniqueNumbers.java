package SoraeCodingMasters.B.BOJ13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 13144번
 * List of Unique Numbers
 * 2024-03-19
 * 시간 제한 : 1초
 * 메모리 제한 : 32MB
 */

public class Main {
    static int N; // 1 <= N <= 100,000
    static int[] arr;
    static int[] visited;
    static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        while (l < N) {
            while (r < N && visited[arr[r]] == 0) {
                visited[arr[r++]]++;
            }

            ans += r - l;
            visited[arr[l++]]--;
        }

        System.out.println(ans);
    }
}
package SoraeCodingMasters.A.BOJ2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 백준 2668번
 * 숫자고르기
 * 2024-03-06
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 1 <= N <= 100
    static int[] numbers;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }
        System.out.println(ans);
        System.out.println(sb);
    }

    public static void dfs(int start, int index) {
        visited[index] = true;
        int next = numbers[index];

        if (visited[next]) {
            if (start == next) {
                sb.append(start).append("\n");
                ans++;
            }
        } else dfs(start, next);
    }
}

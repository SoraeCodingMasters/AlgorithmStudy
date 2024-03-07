package SoraeCodingMasters.A.BOJ1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/***
 * 백준 번
 *
 * 2024-03-
 * 시간 제한 : 초
 * 메모리 제한 : MB
 */

public class Main {
    static int n; // 1 <= n <= 50,000
    static int x, y; // 1 <= x <= 1,000,000 / 0 <= y <= 500,000
    static int[] skyline;
    static Deque<Integer> stack = new ArrayDeque<>();
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        skyline = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            skyline[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= n + 1; i++) {
            int y = skyline[i];
            if (stack.isEmpty() || stack.peekLast() < y) {
                stack.offerLast(y);
            } else {
                while (!stack.isEmpty() && stack.peekLast() >= y) {
                    if (stack.peekLast() > y) ans++;
                    stack.pollLast();
                }
                stack.offerLast(y);
            }
        }

        System.out.println(ans);
    }

}

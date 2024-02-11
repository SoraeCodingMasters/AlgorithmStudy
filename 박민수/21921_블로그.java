package SoraeCodingMasters.BOJ21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 21921번
 * 블로그
 * 2024-02-11
 * 시간 제한 : 1초
 * 메모리 제한 : 512MB
 */

public class Main {
    static int X, N; // 1 <= X <= N <= 250,000
    static int[] visitors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visitors = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        // 누적 합
        for (int i = 1; i <= N; i++) {
            visitors[i] = visitors[i - 1] + Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int maxVisitor = Integer.MIN_VALUE;
        for (int i = 0; i <= N - X; i++) {
            int distance = visitors[i + X] - visitors[i];
            if (maxVisitor < distance) {
                maxVisitor = distance;
                count = 1;
            } else if (maxVisitor == distance) {
                count++;
            }
        }

        if (maxVisitor == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitor + "\n" + count);
        }
    }

}

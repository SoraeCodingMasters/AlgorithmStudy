package SoraeCodingMasters.BOJ19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 19941번
 * 햄버거 분배
 * 2024-02-12
 * 시간 제한 : 0.5초
 * 메모리 제한 : 256MB
 */

public class Main {
    static int N; // 1 <= N <= 20,000
    static int K; // 1 <= K <= 10
    static char[] input;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if (input[i] == 'H') {
                // check left first right second
                for (int j = i - K; j <= i + K; j++) {
                    if ((j >= 0 && j < N) && input[j] == 'P') {
                        count++;
                        input[j] = 'X';
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}

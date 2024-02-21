package SoraeCodingMasters.BOJ1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 1138번
 * 한 줄로 서기
 * 2024-02-19
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 1 <= N <= 10
    static int[] line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int count = 0;
            int left = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                if (count == left && line[j] == 0) {
                    line[j] = i;
                    break;
                }
                if (line[j] == 0) count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int people : line) {
            sb.append(people).append(" ");
        }
        System.out.println(sb);
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(line[i]).append(" ");
        }
        System.out.println(sb);
    }
}

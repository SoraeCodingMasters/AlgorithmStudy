package SoraeCodingMasters.A.BOJ2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/***
 * 백준 2493번
 * 탑
 * 2024-02-29
 * 시간 제한 : 1.5초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 1 <= N <= 500,000
    static Deque<Top> s = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            while(!s.isEmpty() && s.peekLast().value <= input) {
                s.pollLast();
            }

            if (s.isEmpty()) sb.append(0).append(" ");
            else sb.append(s.peekLast().index).append(" ");

            s.addLast(new Top(input, i + 1));

        }

        System.out.println(sb);
    }

    public static class Top {
        int value;
        int index;

        public Top(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}

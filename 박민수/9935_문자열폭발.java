package SoraeCodingMasters.A.BOJ9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/***
 * 백준 9935번
 * 문자열 폭발
 * 2024-03-17
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static char[] origin;
    static char[] target;
    static char[] stack = new char[1_000_001];
    static int p = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        for (int i = 0; i < origin.length; i++) {
            stack[++p] = origin[i];

            if (p + 1 < target.length) {
                continue;
            }

            boolean isMatch = true;
            for (int j = target.length - 1; j >= 0; j--) {
                char c = stack[p--];
                if (target[j] != c) {
                    isMatch = false;
                }
            }

            if (!isMatch) {
                p += target.length;
            }
        }

        if (p == -1) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i <= p; i++) {
                sb.append(stack[i]);
            }

            System.out.println(sb);
        }
    }
}
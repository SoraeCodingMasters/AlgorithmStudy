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
    static Deque<Character> dq = new ArrayDeque<>();
    static Deque<Character> temp = new ArrayDeque<>();
    static char[] origin;
    static char[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        for (int i = 0; i < origin.length; i++) {
            dq.offerLast(origin[i]);

            if (dq.size() < target.length) {
                continue;
            }

            boolean isMatch = true;
            for (int j = target.length - 1; j >= 0; j--) {
                char c = dq.pollLast();
                if (target[j] != c) {
                    isMatch = false;
                }
                temp.offerLast(c);
            }

            if (!isMatch) {
                while(!temp.isEmpty()) {
                    dq.offerLast(temp.pollLast());
                }
            } else {
                temp.clear();
            }
        }

        if (dq.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!dq.isEmpty()) {
                sb.append(dq.pollFirst());
            }
            System.out.println(sb);
        }
    }
}
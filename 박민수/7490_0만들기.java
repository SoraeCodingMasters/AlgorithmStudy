package SoraeCodingMasters.A.BOJ7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 백준 7490번
 * 0 만들기
 * 2024-03-10
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int T; // 1 <= T <= 10
    static int N; // 3 <= N <= 9
    static Queue<Formula> q;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            q = new LinkedList<>();
            q.add(new Formula(1, String.valueOf(1), 1, 3));

            while(!q.isEmpty()) {
                Formula f = q.poll();

                if (f.step == N) {
                    if (f.value == 0) sb.append(f.formula).append("\n");
                    continue;
                }

                int next = f.step + 1;
                int value = f.value;

                // 이전 연산이 뺄셈인 경우
                if (f.mod == 1) {
                    value += f.step - (f.step * 10 + next);
                } else if (f.mod == 2) {
                    value += -f.step + (f.step * 10 + next);
                } else if (f.mod == 3) {
                    value = value * 10 + next;
                }
                q.add(new Formula(value, f.formula + " " + next, next, 3));
                q.add(new Formula(f.value + next, f.formula + "+" + next, next, 2));
                q.add(new Formula(f.value - next, f.formula + "-" + next, next, 1));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static class Formula {
        int value;
        String formula;
        int step;
        int mod;

        public Formula(int value, String formula, int step, int mod) {
            this.value = value;
            this.formula = formula;
            this.step = step;
            this.mod = mod;
        }
    }
}
package SoraeCodingMasters.A.BOJ7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    static int[] numbers;
    static char[] operator = {' ', '+', '-'};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            dfs(new int[N - 1], 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int[] op, int depth) {
        if (depth >= op.length) {
            if (calculate(op) == 0) {
                makeString(op);
            }
            return ;
        }

        for (int i = 0; i < operator.length; i++) {
            op[depth] = i;
            dfs(op, depth + 1);
        }
    }

    public static int calculate(int[] op) {
        int top = -1;
        numbers[++top] = 1;

        int step = 2;
        for (int o : op) {
            if (o == 1) {
                numbers[++top] = step;
            } else if (o == 2) {
                numbers[++top] = -step;
            } else {
                numbers[top] *= 10;
                numbers[top] += (numbers[top] >= 0) ? step : -step;
            }

            step++;
        }

        int sum = 0;
        for (int i = 0; i <= top; i++){
            sum += numbers[i];
        }

        return sum;
    }

    public static void makeString(int[] op) {
        int n = 1;
        sb.append(n);
        for (int i : op) {
            sb.append(operator[i]).append(++n);
        }

        sb.append("\n");
    }
}
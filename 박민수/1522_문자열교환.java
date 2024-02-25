package SoraeCodingMasters.BOJ1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 백준 1522번
 * 문자열 교환
 * 2024-02-24
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static char[] input;
    static int a, b;
    static int len;
    static int total = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        len = input.length;

        for (int i = 0; i < len; i++) {
            if (input[i] == 'a') a++;
            else b++;
        }

        int la, ra, lb, rb;
        int l = 0;
        while(l < len) {
            la = ra = lb = rb = 0;
            // a를 왼쪽으로 몰기
            for (int i = l; i < l + len; i++) {
                if (input[i % len] == 'a') la++;
                else break;
            }
            la = a - la;
            total = Math.min(total, la);

            // a를 오른쪽으로 몰기
            for (int i = l + len - 1; i >= l; i--) {
                if (input[i % len] == 'a') ra++;
                else break;
            }
            ra = a - ra;
            total = Math.min(total, la);

            // b를 왼쪽으로 몰기
            for (int i = l; i < l + len; i++) {
                if (input[i % len] == 'b') lb++;
                else break;
            }
            lb = b - lb;
            total = Math.min(total, lb);

            // a를 오른쪽으로 몰기
            for (int i = l + len - 1; i >= l; i--) {
                if (input[i % len] == 'b') rb++;
                else break;
            }
            rb = b - rb;
            total = Math.min(total, rb);

            l++;
        }

        System.out.println(total);
    }

}

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
    static int a;
    static int len;
    static int total = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        len = input.length;

        // a의 개수 세기
        for (int i = 0; i < len; i++) {
            if (input[i] == 'a') a++;
        }

        int l = 0;
        while(l < len) {
            int b = 0;
            // a 범위 내에서 교환할 b 개수 찾기
            for (int i = l; i < l + a; i++) {
                if (input[i % len] == 'b') b++;
            }
            total = Math.min(total, b);
            l++;
        }

        System.out.println(total);
    }

}

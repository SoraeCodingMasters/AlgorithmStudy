package SoraeCodingMasters.BOJ20310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 백준 20310번
 * 타노스
 * 2024-02-15
 * 시간 제한 : 1초
 * 메모리 제한 : 1024MB
 */

public class Main {
    static char[] S;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = new int[2];
        S = br.readLine().toCharArray();

        // 제거하기 위한 숫자 카운팅
        for (char c : S) {
            count[c - '0']++;
        }

        // 뒤에서 부터 0 제거
        int zeroCount = count[0] / 2;
        for (int i = S.length - 1; i >= 0; i--) {
            if (S[i] == '0' && zeroCount > 0) {
                zeroCount--;
                S[i] = 'X';
            }
        }
        // 엪에서 부터 1 제거
        int oneCount = count[1] / 2;
        for (int i = 0; i < S.length; i++) {
            if (S[i] == '1' && oneCount > 0) {
                oneCount--;
                S[i] = 'X';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length; i++) {
            if (S[i] != 'X') {
                sb.append(S[i]);
            }
        }
        System.out.println(sb);
    }

}

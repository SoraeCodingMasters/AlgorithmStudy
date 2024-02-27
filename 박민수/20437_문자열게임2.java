package SoraeCodingMasters.C.BOJ20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 백준 20437번
 * 문자열 게임 2
 * 2024-02-27
 * 시간 제한 : 1초
 * 메모리 제한 : 1024MB
 */

public class Main {
    static int T; // 1 <= T <= 100
    static String W;
    static int K; // 1 <= K <= |W| <= 10,000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());

            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;

            if(K == 1) {
                sb.append("1 1").append("\n");
                continue;
            }

            // a - z 순회
            for(int i = 0; i < 26; i++) {
                int l = 0;
                int r = 0;
                int count = 0;

                // i 번째 알파벳 찾기
                for (int j = 0; j < W.length(); j++) {
                    l = r = j;
                    if (W.charAt(j) - 'a' == i) {
                        count++;
                        break;
                    }
                }

                Queue<Integer> index = new LinkedList<>();
                // 3, 4번 값 구하기
                while (++r < W.length()) {
                    if (W.charAt(r) - 'a' == i) {
                        index.add(r);
                        count++;
                    }
                    if (K == count) {
                        maxValue = Math.max(maxValue, r - l + 1);
                        minValue = Math.min(minValue, r - l + 1);

                        l = index.poll();
                        count--;
                    }
                }
            }
            if (minValue == Integer.MAX_VALUE || maxValue == Integer.MIN_VALUE) sb.append(-1).append("\n");
            else sb.append(minValue).append(" ").append(maxValue).append("\n");
        }
        System.out.print(sb);
    }

}

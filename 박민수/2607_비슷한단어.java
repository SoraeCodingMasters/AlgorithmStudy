package SoraeCodingMasters.BOJ2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * 백준 2607번
 * 비슷한 단어
 * 2024-02-14
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 2 <= N <= 100
    static int[] alphabet = new int[26];
    static String origin;
    static int miss;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // init
        origin = br.readLine();

        for (int i = 1; i < N; i++) {
            init();
            String input = br.readLine();

            // 길이가 긴 문자를 기준으로 틀린 개수 세기
            miss = Math.max(origin.length(), input.length());

            for(char c : input.toCharArray()) {
                if (alphabet[c - 'A'] > 0) {
                    miss--;
                    alphabet[c - 'A']--;
                }
            }

            if (miss == 1 || miss == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void init() {
        Arrays.fill(alphabet, 0);

        for (char c : origin.toCharArray()) {
            alphabet[c - 'A'] += 1;
        }
    }

}

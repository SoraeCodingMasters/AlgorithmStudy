package SoraeCodingMasters.BOJ1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 백준 1515번
 * 수 이어 쓰기
 * 2024-02-11
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static String target;
    static int pointer = 0;
    static int N = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();

        while (pointer < target.length()) {
            String s = String.valueOf(N++);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == target.charAt(pointer)) pointer++;
            }

            if (pointer >= target.length()) break;
        }

        System.out.println(N - 1);
    }
}

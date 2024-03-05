package SoraeCodingMasters.A.BOJ2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import javax.sound.midi.Soundbank;

/***
 * 백준 2138번
 * 전구와 스위치
 * 2024-03-04
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 2 <= N <= 100,000
    static char[] targetLight;
    static String init;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        init = br.readLine();
        targetLight = br.readLine().toCharArray();

        // 1번을 누르지 않았을 때
        go(init.toCharArray(), 0);

        // 1번을 눌렀을 때
        char[] light = init.toCharArray();
        light[0] = light[0] == '1' ? '0' : '1';
        light[1] = light[1] == '1' ? '0' : '1';
        go(light, 1);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static void go(char[] light, int count) {

        for (int i = 1; i < N; i++) {
            if (light[i - 1] != targetLight[i - 1]) {
                push(light, i);
                count++;
            }
        }

        if (!check(light)) {
            count = Integer.MAX_VALUE;
        }

        ans = Math.min(ans, count);
    }

    public static void push(char[] light, int index) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (0 <= i && i < N) {
                light[i] = light[i] == '0' ? '1' : '0';
            }
        }
    }

    public static boolean check(char[] light) {

        for (int i = 0 ; i < N; i++) {
            if (light[i] != targetLight[i]) {
                return false;
            }
        }

        return true;
    }
}

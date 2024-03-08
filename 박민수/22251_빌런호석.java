package SoraeCodingMasters.C.BOJ22251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 22251번
 * 빌런 호석
 * 2024-03-08
 * 시간 제한 : 1초
 * 메모리 제한 : 512MB
 */

public class Main {
    static int N, K, P, X;
    static int ans = 0;
    static int[] tf;
    static int[] cf;
    static int[] led = {123, 72, 61, 109, 78, 103, 119, 73, 127, 111};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        tf = createFloor(X);

        for (int i = 1; i <= N; i++) {
            int count = 0;
            cf = createFloor(i);
            for (int j = 0; j < K; j++) {
                count += compareDigit(tf[j], cf[j]);
            }

            if (1 <= count && count <= P) ans++;
        }

        System.out.println(ans);
    }

    public static int[] createFloor(int n) {
        int[] temp = new int[K];
        for(int i = K - 1; i >= 0; i--) {
            temp[i] = n % 10;
            n /= 10;
        }

        return temp;
    }

    public static int compareDigit(int t, int c) {
        int diff = 0;

        int xor = led[t] ^ led[c];

        while (xor > 0) {
            if (xor % 2 == 1) diff++;

            xor /= 2;
        }

        return diff;
    }
}
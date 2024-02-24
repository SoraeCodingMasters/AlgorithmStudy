package SoraeCodingMasters.BOJ17615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 백준 17615번
 * 볼 모으기
 * 2024-02-23
 * 시간 제한 : 1초
 * 메모리 제한 : 512MB
 */

public class Main {
    static int N; // 1 <= N <= 500,000
    static char[] balls;
    static int blue, red; // 연속된 공의 개수
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        balls = br.readLine().toCharArray();

        // 각 공의 수 세기
        for (int i = 0; i < N; i++) {
            if (balls[i] == 'B') blue++;
            else red++;
        }

        // 빨간 공을 왼쪽으로 몰기 -> 왼쪽에 있는 빨간 공 세야됨
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i] != 'B') count++;
            else break;
        }
        answer = Math.min(answer, red - count);

        // 빨간 공을 오른쪽으로 몰기 -> 오른쪽에 있는 빨간 공 세야됨
        count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls[i] != 'B') count++;
            else break;
        }
        answer = Math.min(answer, red - count);

        // 파란 공을 왼쪽으로 몰기 -> 왼쪽에 파란 빨간 공 세야됨
        count = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i] != 'R') count++;
            else break;
        }
        answer = Math.min(answer, blue - count);

        // 파란 공을 오른쪽으로 몰기 -> 오른쪽에 있는 파란 공 세야됨
        count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls[i] != 'R') count++;
            else break;
        }
        answer = Math.min(answer, blue - count);

        System.out.println(answer);
    }

}

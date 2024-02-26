package SoraeCodingMasters.C.BOJ20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 20055번
 * 컨베이어 벨트 위의 로봇
 * 2024-02-26
 * 시간 제한 : 1초
 * 메모리 제한 : 512MB
 */

public class Main {
    static int N, K, len; // 2 <= N <= 100 / 1 <= K <= 2N
    static int[] belt; // 1 <= belt[i] <= 1,000
    static boolean[] on;
    static int step = 0;
    static int broken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        len = 2 * N;

        belt = new int[len + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= len; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        on = new boolean[len + 1];

        int up = 1;
        while (broken < K) {

            // 1. 벨트 회전
            if (up == 1) up = len;
            else up--;

            int down = index(up + N - 1);
            if (on[down]) {
                on[down] = false;
            }

            // 2. 로봇 이동
            for (int i = up + N - 2; i >= up; i--) {
                // 현재 칸 내구도가 있어야 하며 비어 있어야 함
                int cur = index(i);
                int next = index(i + 1);
                if (on[cur] && !on[next] && belt[next] > 0) {
                    on[cur] = false;
                    on[next] = true;
                    belt[next]--;
                }
            }

            // 3. 내리는 위치
            if (on[down]) {
                on[down] = false;
            }

            // 4. 로봇 올리기
            if (belt[up] > 0) {
                on[up] = true;
                belt[up]--;
            }

            // 5. 벨트 내구도 체크
            int temp = 0;
            for (int i = 1; i <= len; i++) {
                if (belt[i] == 0)
                    temp++;
            }
            broken = temp;
            step++;
        }

        System.out.println(step);
    }

    public static int index(int i) {
        if (i > len) return i % len;
        else return i;
    }
}

package SoraeCodingMasters.C.BOJ24337;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * 백준 24337번
 * 가희와 탑
 * 2024-04-02
 * 시간 제한 : 1초
 * 메모리 제한 : 512MB
 */

public class Main {
    static int N; // 1 <= N <= 100,000
    static int a, b; // 1 <= a, b <= N
    static List<Integer> dq = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        if (a + b > N + 1) {
            System.out.println(-1);
            return;
        }

        if (a >= b) {
            for (int i = 1; i <= a; i++) {
                dq.add(i);

                if (i == 1) {
                    for (int j = 0; j <= N - a - b; j++) {
                        dq.add(1);
                    }
                }
            }

            for (int i = b - 1; i >= 1; i--) {
                dq.add(i);
            }
        } else {
            if (a == 1) {
                for (int i = b; i >= 1; i--) {
                    dq.add(i);

                    if (i == b) {
                        for (int j = 0; j <= N - a - b; j++) {
                            dq.add(1);
                        }
                    }
                }
            } else {
                for (int i = 0; i <= N - a - b; i++) {
                    dq.add(1);
                }

                for (int i = 1; i <= a - 1; i++) {
                    dq.add(i);
                }

                for (int i = b; i >= 1; i--) {
                    dq.add(i);
                }
            }
        }

        for (int v : dq) {
            sb.append(v).append(" ");
        }

        System.out.println(sb);
    }
}
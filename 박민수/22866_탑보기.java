package SoraeCodingMasters.C.BOJ22866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 백준 22866번
 * 탑 보기
 * 2024-03-28
 * 시간 제한 : 1.5초
 * 메모리 제한 : 1024MB
 */

public class Stack {
    static int N; // 1 <= N <= 100,000
    static Building[] building;
    static int[][] close;
    static int[] cnt;
    static Building[] s;
    static int top = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = new int[N + 1];

        close = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(close[i], Integer.MAX_VALUE);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        building = new Building[N + 1];
        for (int i = 1; i <= N; i++) {
            building[i] = new Building(i, Integer.parseInt(st.nextToken()));
        }

        s = new Building[N];
        ltor();
        top = -1; // 스택 초기화
        rtol();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
             sb.append(cnt[i]).append(" ");
             if(cnt[i] != 0) {
                 int ld = Math.abs(close[i][0] - i);
                 int rd = Math.abs(close[i][1] - i);

                 if (ld == rd) sb.append(close[i][0]);
                 else if (ld > rd) sb.append(close[i][1]);
                 else sb.append(close[i][0]);
             }
             sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void ltor() {

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                s[++top] = building[i];
            } else {
                while(top >= 0 && s[top].L <= building[i].L) {
                    top--;
                }

                if (top >= 0) close[building[i].idx][0] = s[top].idx; // 왼쪽에서 가장 가까운
                cnt[building[i].idx] += top + 1;
                s[++top] = building[i];
            }
        }
    }
    public static void rtol() {

        for (int i = N; i >= 1; i--) {
            if (i == N) {
                s[++top] = building[i];
            } else {
                while(top >= 0 && s[top].L <= building[i].L) {
                    top--;
                }

                if (top >= 0) close[building[i].idx][1] = s[top].idx; // 오른쪽에서 가장 가까운
                cnt[building[i].idx] += top + 1;
                s[++top] = building[i];
            }
        }
    }

    public static class Building {
        int idx;
        int L;

        public Building(int idx, int l) {
            this.idx = idx;
            L = l;
        }
    }
}
package SoraeCodingMasters.BOJ3758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/***
 * 백준 3758번
 * KCPC
 * 2024-02-14
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int T;
    static int n, k, t, m; // 3 <= n, k <= 100 / 1 <= t <= n / 3 <= m <= 10,000 /
    static int i, j, s; // 1 <= i <= n / 1 <= j <= k / 0 <= s <= 100
    static int[][][] table;
    static List<Team> teams;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            table = new int[n + 1][k + 1][3]; // 0 : 문제에 대한 최고 점수, 1 : 제출 횟수, 2 : 제출 순서

            for(int a = 1; a <= m; a++) {
                st = new StringTokenizer(br.readLine());
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

                table[i][j][0] = Math.max(table[i][j][0] , s);
                table[i][j][1]++;
                table[i][j][2] = a;
            }

            teams = new ArrayList<>();
            for (int a = 1; a <= n; a++) {
                int totalScore = 0;
                int totalSubmit = 0;
                int lastSubmit = Integer.MIN_VALUE;
                for(int b = 1; b <= k; b++) {
                    totalScore += table[a][b][0];
                    totalSubmit += table[a][b][1];
                    lastSubmit = Math.max(lastSubmit, table[a][b][2]);
                }
                teams.add(new Team(a, totalScore, totalSubmit, lastSubmit));
            }
            Collections.sort(teams);

            for (int grade = 0; grade < teams.size(); grade++) {
                if (teams.get(grade).teamId == t) {
                    sb.append(grade + 1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    public static class Team implements Comparable<Team> {
        int teamId;
        int totalScore;
        int totalSubmit;
        int lastSubmit;

        public Team(int teamId, int totalScore, int totalSubmit, int lastSubmit) {
            this.teamId = teamId;
            this.totalScore = totalScore;
            this.totalSubmit = totalSubmit;
            this.lastSubmit = lastSubmit;
        }

        @Override
        public int compareTo(Team o) {
            if (this.totalScore < o.totalScore) {
                return 1;
            } else if (this.totalScore == o.totalScore) {
                if (this.totalSubmit > o.totalSubmit) {
                    return 1;
                } else if (this.totalSubmit == o.totalSubmit) {
                    return this.lastSubmit - o.lastSubmit;
                } else {
                    return  -1;
                }
            } else {
                return -1;
            }
        }
    }

}

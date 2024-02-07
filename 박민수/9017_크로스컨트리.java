package SoraeCodingMasters.BOJ9017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.StringTokenizer;

/***
 * 백준 9017번
 * 크로스 컨트리
 * 2024-02-07
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static final int M = 200; // 1 <= M <= 200
    static final int TEAM = 6;
    static int T;
    static int N; // 6 <= N <= 1,000
    static int[] table;
    static int[] teams = new int[M + 1];
    static List<Integer>[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Arrays.fill(teams, 0);
            table = new int[N + 1];

            // 팀원 수 구하기
            int totalTeam = 0;
            for(int i = 1; i <= N; i++) {
                int teamNum = Integer.parseInt(st.nextToken());
                table[i] = teamNum;
                teams[teamNum] += 1;

                totalTeam = Math.max(totalTeam, teamNum);
            }

            scores = new ArrayList[totalTeam + 1];
            for(int i = 0; i <= totalTeam; i++) {
                scores[i] = new ArrayList<>();
            }

            // 점수 계산하기
            int score = 1;
            for (int i = 1; i <= N; i++) {
                int team = table[i];
                if (teams[team] == 6) {
                    scores[team].add(score++);
                }
            }

            for (int i = 1; i <= totalTeam; i++) {
                int temp = 0;
                if (scores[i].size() == 6) {
                    for (int j = 0; j < 4; j++) {
                        temp += scores[i].get(j);
                    }
                }
                scores[i].add(temp);
            }

            // 최소 점수 구하기
            int minScore = Integer.MAX_VALUE;
            for (int i = 1; i <= totalTeam; i++) {
                if (scores[i].size() > 6) {
                    minScore = Math.min(minScore, scores[i].get(6));
                }
            }

            // 동점자 구하기
            List<Integer> winners = new ArrayList<>();
            for (int i = 1; i <= totalTeam; i++) {
                if (scores[i].size() > 6 && scores[i].get(6) == minScore) {
                    winners.add(i);
                }
            }

            // 동점 시, 5번째 주자에 대한 정보가 필요하면 따로 1차원 배열을 사용하는 것이 효율적으로 보임
            int winner = 0;
            int winnerScore = Integer.MAX_VALUE;
            for (int team : winners) {
                int fifth = scores[team].get(4);
                if (winnerScore > fifth) {
                    winnerScore = fifth;
                    winner = team;
                }
            }
            sb.append(winner).append("\n");
        }
        System.out.println(sb);
    }
}

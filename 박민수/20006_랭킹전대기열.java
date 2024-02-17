package SoraeCodingMasters.BOJ20006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/***
 * 백준 20006번
 * 랭킹전 대기열
 * 2024-02-17
 * 시간 제한 : 1초
 * 메모리 제한 : 256MB
 */

public class Main {
    static int p, m; // 1 <= p, m <= 300
    static int l; // 1 <= l <= 500
    static String n;

    static List<List<Player>> rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = st.nextToken();

            requestJoin(new Player(l, n));
        }

        StringBuilder sb = new StringBuilder();
        for (List<Player> room : rooms) {
            if (room.size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            Collections.sort(room);

            for (Player player : room) {
                sb.append(player.score).append(" ").append(player.nickname).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void requestJoin(Player player) {
        for (List<Player> room : rooms) {
            int roomScore = room.get(0).score;
            int playerScore = player.score;
            // 절대값이 10 이내 & 풀방이 아니라면
            if (Math.abs(roomScore - playerScore) <= 10 && room.size() < m) {
                room.add(player);
                return;
            }
        }
        // 방이 없다면
        rooms.add(new ArrayList<>());
        rooms.get(rooms.size() - 1).add(player);
    }

    public static class Player implements Comparable<Player>{
        int score;
        String nickname;

        public Player(int score, String nickname) {
            this.score = score;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }

}

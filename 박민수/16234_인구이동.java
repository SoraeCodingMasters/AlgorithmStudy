package SoraeCodingMasters.B.BOJ16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/***
 * 백준 16234번
 * 인구 이동
 * 2024-02-28
 * 시간 제한 : 2초
 * 메모리 제한 : 512MB
 */

public class Main {
    static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N; // 1 <= N <= 50
    static int L, R; // 1 <= L <= R <= 100
    static int[][] lands;
    static boolean[][] visited;
    static int day = 0;
    static List<Location> union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        lands = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lands[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            // 매 회차당 초기화
            boolean stop = true;
            visited = new boolean[N][N];
            // 연합 만들기
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y]) {
                        int sum = bfs(x, y);

                        if (union.size() > 1) {
                            stop = false;
                            int people = sum / union.size();
                            // 연합 인구 이동
                            for (Location l : union) {
                                lands[l.x][l.y] = people;
                            }
                        }
                    }
                }
            }

            // 연합이 없다면 종료
            if(stop) break;

            day++;
        }

        System.out.println(day);
    }
    public static int bfs(int x, int y) {
        union = new ArrayList<>();
        union.add(new Location(x, y));

        Queue<Location> q = new LinkedList<>();
        q.add(new Location(x, y));
        visited[x][y] = true;

        int sum = lands[x][y];
        while(!q.isEmpty()) {
            Location l = q.poll();

            for (int i = 0; i < dir.length; i++) {
                int nx = l.x + dir[i][0];
                int ny = l.y + dir[i][1];

                if (check(nx, ny) && !visited[nx][ny]) {
                    int diff = Math.abs(lands[l.x][l.y] - lands[nx][ny]);

                    if (L <= diff && diff <= R) {
                        visited[nx][ny] = true;
                        sum += lands[nx][ny];
                        q.add(new Location(nx, ny));
                        union.add(new Location(nx, ny));
                    }
                }
            }
        }

        return sum;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}

package SoraeCodingMasters.BOJ1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/***
 * 백준 1446번
 * 지름길
 * 2024-02-23
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N, D; // 1 <= N <= 12 / 1 <= D <= 10,000
    static int[] dp; // index 까지의 최단 거리
    static List<Path> paths;
    static int to, from, w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dp = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = i;
        }

        paths = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            to = Integer.parseInt(st.nextToken());
            from = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            paths.add(new Path(to, from, w));
        }

        Path prev = new Path(0, 0, 0);
        for (Path path : paths) {
            if ((path.from - path.to) < path.w || path.from > D) continue;
            dp[path.from] = Math.min(dp[path.from], Math.min(dp[prev.from] + (path.to - prev.from) + path.w, dp[path.to] + path.w));
            for (int j = path.from + 1; j <= D; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1] + 1);
            }
        }

        System.out.println(dp[D]);
    }

    public static class Path implements Comparable<Path>{
        int to;
        int from;
        int w;

        public Path(int to, int from, int w) {
            this.to = to;
            this.from = from;
            this.w = w;
        }

        @Override
        public int compareTo(Path o) {
            return this.to - o.to;
        }
    }
}

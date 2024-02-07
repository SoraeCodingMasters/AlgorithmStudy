package SoraeCodingMasters.BOJ17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 17266번
 *
 * 2024-02-07
 * 시간 제한 : 1초
 * 메모리 제한 : 256MB
 */

public class Main {
    static int N; // 1 <= N <= 100,000
    static int M; // 1 <= M <= N;
    static int[] lamps;
    static boolean[] road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        lamps = new int[M];
        for (int i = 0; i < M; i++) {
            lamps[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int left = 1;
        int right = N;
        int result = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            if (isCover(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static boolean isCover(int height) {
        // 전 가로등 위치 + 높이 >= 현 가로등 위치 - 높이
        int start = 0;

        for (int i = 0; i < lamps.length; i++) {
            if (lamps[i] - height > start) {
                return false;
            }
            start = lamps[i] + height;
        }

        return start - N >= 0;
    }

}

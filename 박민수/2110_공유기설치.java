package SoraeCodingMasters.A.BOJ2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 백준 2110번
 * 공유기 설치
 * 2024-03-17
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 2 <= N <= 200,000
    static int C; // 2 <= C <= N
    static int[] houses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);


        binarySearch(1, houses[N - 1] - houses[0] + 1);
    }

    public static void binarySearch(int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;

            // C가 처음 나타나는 위치
            if (count(mid) < C) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(r - 1);
    }

    public static int count(int d) {
        int count = 1;
        int prev = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - prev >= d) {
                prev = houses[i];
                count++;
            }
        }

        return count;
    }

}
package SoraeCodingMasters.BOJ13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 백준 13305번
 * 주유소
 * 2024-02-08
 * 시간 제한 : 2초
 * 메모리 제한 : 512MB
 */

public class Main {
    static int N; // 2 <= N <= 100,000 -> 최소 NlogN
    static int[] distances;
    static int[] prices;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        distances = new int [N - 1];
        prices = new int [N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int minPrice = Integer.MAX_VALUE;
        long totalPrice = 0;
        for (int i = 0; i < N - 1; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            totalPrice += (long) minPrice * distances[i];
        }

        System.out.println(totalPrice);
    }

}

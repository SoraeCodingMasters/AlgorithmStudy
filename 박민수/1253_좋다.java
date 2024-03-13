package SoraeCodingMasters.A.BOJ1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/***
 * 백준 1253번
 * 좋다
 * 2024-03-13
 * 시간 제한 : 2초
 * 메모리 제한 : 256MB
 */

public class Main {
    static int N; // 1 <= N <= 2,000
    static int[] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int l = i == 0 ? 1 : 0;
            int r = i == N - 1 ? N - 2 : N - 1;
            int target = arr[i];
            while(l < r) {
                int sum = arr[l] + arr[r];

                if (sum > target) {
                    r = r - 1 == i ? r - 2 : r - 1;
                } else if (sum < target) {
                    l = l + 1 == i ? l + 2 : l + 1;
                } else {
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }

}
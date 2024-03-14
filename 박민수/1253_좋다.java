package SoraeCodingMasters.A.BOJ1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 백준 1253번
 * 좋다 (Binary Search) 버전
 * 2024-03-13
 * 시간 제한 : 2초
 * 메모리 제한 : 256MB
 */

public class BS {
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

        for(int i = 0; i < N; i++) {
            int target = arr[i];
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                int l = j + 1;
                int r = N - 1;

                while (l <= r) {
                    int mid = (l + r) / 2;
                    int second = target - arr[j];

                    if (second < arr[mid]) {
                        r = mid - 1;
                    } else if (second == arr[mid] && j != mid && i != mid) {
                        flag = true;
                        break;
                    } else {
                        l = mid + 1;
                    }
                }
            }
            if (flag) ans++;
        }

        System.out.println(ans);
    }
}
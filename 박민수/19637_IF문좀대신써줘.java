package SoraeCodingMasters.BOJ19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/***
 * 백준 19637번
 * IF문 좀 대신 써줘
 * 2024-02-15
 * 시간 제한 : 1초
 * 메모리 제한 : 1024MB
 */

public class Main {
    static int N, M; // 1 <= N, M <= 100,000
    static String title;
    static int power;
    static Map<Integer, String> titles;
    static int[] powers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        titles = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title = st.nextToken();
            power = Integer.parseInt(st.nextToken());

            titles.putIfAbsent(power, title);
        }

        powers = titles.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(powers);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(br.readLine());
            int key = lowerBound(value);
            sb.append(titles.get(powers[key])).append("\n");
        }

        System.out.println(sb);
    }
    public static int binarySearch(int value) {
        int left = 0;
        int right = powers.length;

        int answer = 0;

        while(left < right) {
           int mid = (left + right) / 2;

           if(powers[mid] < value) {
               // 왼쪽 잘라내기
               left = mid + 1;
           } else if (powers[mid] > value){
               // 오른쪽 잘라내기
               right = mid;
           } else {
               return mid;
           }

        }
        return answer;
    }

    public static int lowerBound(int value) {
        int left = 0;
        int right = powers.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(powers[mid] < value) {
                // 왼쪽 잘라내기
                left = mid + 1;
            } else {
                // 오른쪽 잘라내기
                right = mid;
            }
        }
        return right;
    }
}

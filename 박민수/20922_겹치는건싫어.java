package SoraeCodingMasters.BOJ20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/***
 * 백준 20922번
 * 겹치는 건 싫어
 * 2024-02-22
 * 시간 제한 : 1초
 * 메모리 제한 : 1024MB
 */

public class Main {
    static int N; // 1 <= N <= 200,000
    static int K; // 1 <= K <= 100
    static int[] sequence;
    static int s,e;
    static int answer = Integer.MIN_VALUE;
    static Map<Integer, Integer> section;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sequence = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        section = new HashMap<>();

        s = 0;
        e = 0;
        while(e < N) {
            int value = sequence[e];
            int count = section.getOrDefault(value, 0);
            if (count < K) {
                section.put(value, count + 1);
                e++;
            } else {
                int v = sequence[s];
                section.put(v, section.get(v) - 1);
                s++;
            }
            answer = Math.max(answer, e - s);
        }

        System.out.println(answer);
    }

}

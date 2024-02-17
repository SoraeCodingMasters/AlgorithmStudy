package SoraeCodingMasters.BOJ22233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/***
 * 백준 22233번
 * 가희와 키워드
 * 2024-02-16
 * 시간 제한 : 1.5초
 * 메모리 제한 : 512MB
 */

public class Main {
    static int N, M; // 1 <= N, M <= 200,000
    static HashMap<String, Boolean> words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            words.put(br.readLine(), true);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                if(words.getOrDefault(word, false)) {
                    words.put(word, false);
                    N--;
                }
            }
            sb.append(N).append("\n");
        }

        System.out.println(sb);
    }

}

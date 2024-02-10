package SoraeCodingMasters.BOJ20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/***
 * 백준 20920번
 * 영단어 암기는 괴로워
 * 2024-02-09
 * 시간 제한 : 1초
 * 메모리 제한 : 1024MB
 */

public class Main {
    static int N; // 1 <= N <= 100,000
    static int M; // 1 <= M <= 10

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            // 단어 카운팅하기
            if (word.length() >= M) {
                int count = wordMap.getOrDefault(word, 0); // key가 없다면 0을 반환
                wordMap.put(word, count + 1);
            }
        }

        List<String> wordList = new Arra    yList<>(wordMap.keySet());

        // Comparator lambda expression
        wordList.sort(((a , b) -> {
            int aCount = wordMap.get(a);
            int bCount = wordMap.get(b);

            // 1. 자주 나오는 단어일수록 앞에 배치
            if (aCount < bCount) {
                return 1;
            } else if (aCount == bCount) {
                int aLen = a.length();
                int bLen = b.length();
                // 2. 단어의 길이가 길수록 앞에 배치
                if (aLen < bLen) {
                    return 1;
                } else if (aLen == bLen) {
                    // 3. 알파벳 사전 순
                   return a.compareTo(b);
                }
            }
            return -1;
        }));

        StringBuilder sb = new StringBuilder();
        for (String s : wordList) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}

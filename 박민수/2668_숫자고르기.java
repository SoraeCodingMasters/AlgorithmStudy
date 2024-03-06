package SoraeCodingMasters.A.BOJ2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * 백준 2668번
 * 숫자고르기
 * 2024-03-06
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 1 <= N <= 100
    static int[] numbers;
    static boolean[] visited;
    static Set<Integer> index;
    static Set<Integer> value;
    static Set<Integer> ans = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            index = new HashSet<>();
            value = new HashSet<>();

            dfs(i);

            if (index.size() == value.size()) {
                ans.addAll(index);
            }
        }

        List<Integer> sortAns = new ArrayList<>(ans);
        Collections.sort(sortAns);

        StringBuilder sb = new StringBuilder();
        sb.append(sortAns.size()).append("\n");
        for (int n : sortAns) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        index.add(start);

        int next = numbers[start];
        value.add(next);

        if (!visited[next]) {
            dfs(next);
        }
    }
}

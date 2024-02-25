package SoraeCodingMasters.B.BOJ12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 백준 12919번
 * A와 B 2
 * 2024-02-25
 * 시간 제한 : 2초
 * 메모리 제한 : 512MB
 */

public class Main {
    static String S, T; // 1 <= S의 길이 <= 49 / 2 <= T의 길이 <= 50
    static int ta, tb;
    static int sa, sb;
    static Queue<String> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == 'A') ta++;
            else tb++;
        }

        q.add(S);
        while(!q.isEmpty()) {
            String w = q.poll();

            if (w.equals(T)) {
                System.out.println(1);
                return;
            }

            int wa = 0;
            int wb = 0;
            for (int i = 0; i < w.length(); i++) {
                if (w.charAt(i) == 'A') wa++;
                else wb++;
            }

            if (wa + wb < ta + tb) {
                if (wa < ta) q.add(new StringBuilder().append(w).append("A").toString());
                if (wb < tb) q.add(new StringBuilder().append(w).append("B").reverse().toString());
            }
        }

        System.out.println(0);
    }

}



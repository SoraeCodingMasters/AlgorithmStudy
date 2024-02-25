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
    static String S; // 1 <= S의 길이 <= 49 / 2 <= T의 길이 <= 50
    static boolean find;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        String T = br.readLine();

        dfs(T);
        if (find) System.out.println(1);
        else System.out.println(0);
    }

    public static void dfs(String target) {

        if (target.length() < S.length()) return;

        if (S.equals(target)) find = true;

        // 맨뒤에 A가 있을 때
        if (target.charAt(target.length() - 1) == 'A') {
           dfs(new StringBuilder().append(target, 0, target.length() - 1).toString());
        }
        // 맨앞에 B가 있을 때
        if (target.charAt(0) == 'B') {
           dfs(new StringBuilder().append(target.substring(1)).reverse().toString());
        }
    }

}



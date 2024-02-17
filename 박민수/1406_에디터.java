package SoraeCodingMasters.BOJ1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 백준 1406번
 * 에디터
 * 2024-02-18
 * 시간 제한 : 2초
 * 메모리 제한 : 512MB
 */

public class Main {
    static final int MAX_LEN = 600_000;
    static String input;  // 1 <= len(input) <= 100,000
    static int M; // 1 <= M <= 500,000
    static List<Character> editor = new LinkedList<>();
    static char command;
    static int cursor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        input = br.readLine();
        cursor = input.length();
        for (char c : input.toCharArray()) {
            editor.add(c);
        }

        M = Integer.parseInt(br.readLine());

        while(M-- > 0) {
            String s = br.readLine();
            command = s.charAt(0);

            if (command == 'L' && cursor > 0) cursor--;
            else if (command == 'D' && cursor < editor.size()) cursor++;
            else if (command == 'B' && cursor > 0) editor.remove(--cursor);
            else if (command == 'P') editor.add(cursor++, s.charAt(2));
        }

        StringBuilder sb = new StringBuilder();

        for (char c : editor) {
            sb.append(c);
        }

        System.out.println(sb);
    }

}

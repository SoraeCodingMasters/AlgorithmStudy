package SoraeCodingMasters.BOJ1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
    static String input;  // 1 <= len(input) <= 100,000
    static int M; // 1 <= M <= 500,000
    static List<Character> editor = new LinkedList<>();
    static char command;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        input = br.readLine();
        for (char c : input.toCharArray()) {
            editor.add(c);
        }

        M = Integer.parseInt(br.readLine());

        ListIterator<Character> iterator = editor.listIterator(); // Linked List의 cursor
        for (char c : editor) {
            iterator.next(); // 맨 끝으로 옮기기
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken().charAt(0);

            if (command == 'L' && iterator.hasPrevious()) iterator.previous();
            else if (command == 'D' && iterator.hasNext()) iterator.next();
            else if (command == 'B' && iterator.hasPrevious()) {
                iterator.previous();
                iterator.remove();
            }
            else if (command == 'P') iterator.add(st.nextToken().charAt(0));
        }

        StringBuilder sb = new StringBuilder();

        for (char c : editor) {
            sb.append(c);
        }

        System.out.println(sb);
    }

}

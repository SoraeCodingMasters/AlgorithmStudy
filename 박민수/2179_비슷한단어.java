package SoraeCodingMasters.A.BOJ2179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * 백준 2179번
 * 비슷한 단어
 * 2024-03-22
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 2 <= N <= 20,000
    static Word[] words;
    static Set<Word> s = new HashSet<>();
    static int matchCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        words = new Word[N];
        for (int i = 0; i < N; i++) {
            words[i] = new Word(br.readLine(), i);
        }

        Arrays.sort(words, (a, b) -> a.s.compareTo(b.s));

        int l = 0;
        int r = 1;
        while (r < N) {
            Word ls = words[l];
            Word rs = words[r];

            int temp = 0;
            // ls의 길이가 같거나 작다
            for (int i = 0; i < ls.s.length(); i++) {
                if (ls.s.charAt(i) == rs.s.charAt(i)) temp++;
                else break;
            }

            if (matchCount < temp) {
                s.clear();
                s.add(ls); s.add(rs);
                matchCount = temp;
            } else if (matchCount == temp) {
                s.add(ls); s.add(rs);
            }

            l = r;
            r = l + 1;
        }

        List<Word> w = new ArrayList<>(s);
        Collections.sort(w, (a, b) -> (Integer.compare(a.i, b.i)));

        Word first = w.get(0);
        Word second = w.get(1);
        for (int i = 1; i < w.size(); i++) {
            if (first.s.charAt(0) == w.get(i).s.charAt(0)) {
                second = w.get(i);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(first.s).append("\n").append(second.s).append("\n");
        System.out.println(sb);
    }

    public static class Word {
        String s;
        int i;

        public Word(String s, int i) {
            this.s = s;
            this.i = i;
        }
    }
}
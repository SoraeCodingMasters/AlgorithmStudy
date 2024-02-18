package SoraeCodingMasters.BOJ2304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/***
 * 백준 2304번
 * 창고 다각형
 * 2024-02-18
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 */

public class Main {
    static int N; // 1 <= N <= 1,000
    static Stick[] sticks;
    static int height, location;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sticks = new Stick[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            location = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            sticks[i] = new Stick(location, height);
        }

        Arrays.sort(sticks);
        int lowerBound = findLowerBound();
        int upperBound = findUpperBound();

        // 고점 전
        Stick beforeMax = sticks[0];
        for (int i = 1; i <= lowerBound; i++) {
            if (beforeMax.height < sticks[i].height) {
                total += beforeMax.height * (sticks[i].location - beforeMax.location);
                beforeMax = sticks[i];
            }
        }

        // 고점
        total += (sticks[upperBound].location - sticks[lowerBound].location + 1) * sticks[lowerBound].height;

        // 고점 후
        Stick afterMax = sticks[N - 1];
        for (int i = N - 1; i >= upperBound; i--) {
            if (afterMax.height < sticks[i].height) {
                total += afterMax.height * (afterMax.location - sticks[i].location);
                afterMax = sticks[i];
            }
        }

        System.out.println(total);
    }

    public static int findLowerBound() {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < N; i++) {
            if (maxValue < sticks[i].height) {
                maxValue = sticks[i].height;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static int findUpperBound() {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < N; i++) {
            if (maxValue <= sticks[i].height) {
                maxValue = sticks[i].height;
                maxIndex = i;
            }
        }

        return maxIndex;
    }


    public static class Stick implements Comparable<Stick> {
        int location;
        int height;

        @Override
        public int compareTo(Stick o) {
            return this.location - o.location;
        }

        public Stick(int location, int height) {
            this.location = location;
            this.height = height;
        }
    }
}


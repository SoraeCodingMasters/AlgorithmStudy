package SoraeCodingMasters.A.BOJ7682;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 백준 7682번
 * 틱택토
 * 2024-03-05
 * 시간 제한 : 1초
 * 메모리 제한 : 128MB
 */

public class Main {
    static final int LEN = 3;
    static final String VALID = "valid";
    static final String INVALID = "invalid";
    static String game;
    static char[][] board = new char[3][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (!(game = br.readLine()).equals("end")) {

            int x = 0;
            int o = 0;

            boolean isWinX = false;
            boolean isWinO = false;

            for (int i = 0; i < LEN; i++) {
                for (int j = 0; j < LEN; j++) {
                    board[i][j] = game.charAt(LEN * i + j);

                    if (board[i][j] == 'X') x++;
                    else if (board[i][j] == 'O') o++;

                    // 가로
                    if (j == LEN - 1 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                        if (board[i][1] == 'X') isWinX = true;
                        else if (board[i][1] == 'O') isWinO = true;
                    }

                    // 대각선
                    if (i == LEN - 1 && j == LEN - 1) {
                        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                            if(board[1][1] == 'X') isWinX = true;
                            else if (board[1][1] == 'O') isWinO = true;
                        }
                        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                            if(board[1][1] == 'X') isWinX = true;
                            else if (board[1][1] == 'O') isWinO = true;
                        }
                    }
                }
            }

            // 세로 검사
            for (int i = 0; i < LEN; i++) {
                if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                    if (board[0][i] == 'X') isWinX = true;
                    else if (board[0][i] == 'O') isWinO = true;
                }
            }

            if (x - o == 1 && !isWinO && !isWinX && x + o == 9) sb.append(VALID);
            else if (x - o == 1 && !isWinO && isWinX) sb.append(VALID);
            else if (x - o == 0 && isWinO && !isWinX) sb.append(VALID);
            else sb.append(INVALID);

            sb.append("\n");
        }

        System.out.println(sb);
    }

}

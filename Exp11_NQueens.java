import java.util.Scanner;

public class NQueen {

    static int N;
    static int[] board;

    static void NQUEEN(int row) {
        if (row > N) {
            printBoard();
            return;
        }

        for (int col = 1; col <= N; col++) {
            if (IS_SAFE(row, col)) {
                board[row] = col;

                NQUEEN(row + 1);

                board[row] = 0;
            }
        }
    }

    static boolean IS_SAFE(int row, int col) {
        for (int i = 1; i <= row - 1; i++) {

            if (board[i] == col)
                return false;

            if (Math.abs(board[i] - col) == Math.abs(i - row))
                return false;
        }

        return true;
    }

    static void printBoard() {
        System.out.println("Solution:");

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (board[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        N = sc.nextInt();

        board = new int[N + 1];

        NQUEEN(1);

        sc.close();
    }
}
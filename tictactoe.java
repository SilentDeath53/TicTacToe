import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;

        while (!isGameOver) {
            printBoard();

            System.out.print("Player " + currentPlayer + ", enter your move (row column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                makeMove(row, col);
                if (checkWin()) {
                    isGameOver = true;
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (isBoardFull()) {
                    isGameOver = true;
                    System.out.println("It's a tie!");
                } else {
                    currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    public void printBoard() {
        System.out.println("Tic Tac Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }
        return board[row][col] == '-';
    }

    public void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }

        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}

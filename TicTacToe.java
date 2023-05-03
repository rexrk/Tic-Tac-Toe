package LearnJava.Arrays;
import java.util.Scanner;


public class TicTacToe {
    private final static char[][] board;
    private static char player = 'O';


    static {
        board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //usable variables
        Scanner in = new Scanner(System.in);
        int moves = 1;

        //Start Page
        System.out.println("+++++++Tic-Tac-Toe+++++++");
        System.out.println("+++++++___________+++++++");
        System.out.println("New Game...." + "\n");


        //Main Logic
        while (moves <= 9) {
            printBoard(board);
            System.out.print("'" + player + "'->" + " Enter Position: ");

            int row = in.nextInt();
            int col = in.nextInt();
            if(row >= board.length || col >= board.length){
                throw new Exception("Invalid Move");
            }

            if (board[row][col] == ' ') {
                board[row][col] = player;
                moves++;

                if (gameOver(row, col)) {
                    System.out.println(player + " won.....<<<3");
                    printBoard(board);
                    break;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }

            }

        }
        System.out.println("Game Over </3 ...");
        in.close();
    }

    //prints board
    private static void printBoard(char[][] board) {
        for (char[] rows : board) {
            System.out.print("\t" + " | ");
            for (char elements : rows) {
                System.out.print(elements + " | ");
            }
            System.out.println("\n \t" + " ----|---|----");
        }
    }

    //winning logic
    private static boolean gameOver(int row, int col) {
        //Row wise Check
        if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
            board[row][0] = '⦻';
            board[row][1] = '⦻';
            board[row][2] = '⦻';
            return true;
        }

        //Col wise check
        if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
            board[0][col] = '⦻';
            board[1][col] = '⦻';
            board[2][col] = '⦻';
            return true;
        }


        //Left Diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            board[0][0] = '⦻';
            board[1][1] = '⦻';
            return true;
        }

        //else
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            board[0][2] = '⦻';
            board[1][1] = '⦻';
            board[2][0] = '⦻';
            return  true;

        }

        return false;

    }
}

import java.util.*;

class Board{
    private char[][] grid1 = {{'.','.','.'},{'.','.','.'},{'.','.','.'}};
    private int[][] grid2 = {{8,1,6},{3,5,7},{4,9,2}};
    private boolean whichPlayer = false;
    private String position;
    private int index1, index2;
    private boolean gameover = false;
    private String gameState;
    private char winner;
    private int scoreO = 0;
    private int scoreX = 0;

    public static void main(String[] args) {
        Board program = new Board();
        program.run();
    }

    private void run() {
        testBoard();
    }

    //------------ Getters ------------

    public boolean whichPlayer() {
        return whichPlayer;
    }
    public String position() {
        return position;
    }
    public int index1() {
        return index1;
    }
    public int index2() {
        return index2;
    }
    public boolean gameover() {
        return gameover;
    }
    public char getGrid1(int num1, int num2) {
        return grid1[num1][num2];
    }
    public int getGrid2(int num1, int num2) {
        return grid2[num1][num2];
    }
    public int scoreX() {
        return scoreX;
    }
    public int scoreO() {
        return scoreO;
    }

    //------------ Setters ------------

    public void position(String position) {
        this.position = position;
    }
    public void whichPlayer(boolean whichPlayer) {
        this.whichPlayer = whichPlayer;
    }
    public void index1(int index1) {
        this.index1 = index1;
    }
    public void index2(int index2) {
        this.index2 = index2;
    }
    public void scoreX(int score) {
        scoreX = score;
    }
    public void scoreO(int score) {
        scoreO = score;
    }
    public void setGrid1(int index1, int index2, char player) {
         grid1[index1][index2] = player;
    }

    //--------------- Methods ----------------

    public char checkGameState() {
        boolean done = true;
        for(int i=0; i<grid1.length; i++) {
            for(int j=0; j<grid1.length; j++) {
                if(grid1[i][j] == '.') {
                    done = false;
                }
            }
        }
        if(scoreX == 15) {
            gameState = "Win";
            winner = 'X';
            gameover = true;
            System.out.println("Player X Wins!!!\n");
        }
        else if(scoreO == 15) {
            gameState = "Win";
            winner = 'O';
            gameover = true;
            System.out.println("Player O Wins!!!\n");
        }
        else if(done) {
            gameState = "Draw";
            gameover = true;
            System.out.println("Game is a Draw\n");
        }
        return winner;
    }

    // ---------- Unit Testing -----------

    private void testBoard() {
        grid1 = new char[][] {{'X','O','X'},{'X','O','X'},{'O','X','O'}};
        assert(checkGameState() == '\0');
        grid1 = new char[][] {{'X','X','X'},{'X','O','X'},{'O','X','O'}};
        scoreX = 15;
        assert(checkGameState() == 'X');
        grid1 = new char[][] {{'X','O','X'},{'X','O','X'},{'O','O','O'}};
        scoreX = 0;
        scoreO = 15;
        assert(checkGameState() == 'O');
    }
}

import java.util.*;

class Oxo {

    public static void main(String[] args) {
        Oxo program = new Oxo();
        program.run();
    }

    void run() {
        Display display = new Display();
        Board board = new Board();
        while(!board.gameover()) {
            display.getInput(board);
            display.displayBoard(board);
            board.checkGameState();
        }
    }
}

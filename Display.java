import java.util.*;

class Display {

    public static void main(String[] args) {
        Display program = new Display();
        program.run();
    }

    private void run() {
        testDisplay();
    }

    //--------------- Methods ----------------

    public void getInput(Board b) {
        Scanner input = new Scanner(System.in);
        if(b.whichPlayer() == false) {
            System.out.print("Player X's move: ");
        }
        else if (b.whichPlayer() == true) {
            System.out.print("Player O's move: ");
        }
        b.position(input.next());
        System.out.println();
        while(!checkValidity(b)) {
            System.out.println("You did not enter a valid position");
            System.out.print("Please Try Again: ");
            b.position(input.next());
            System.out.println();
        }
        if(b.whichPlayer() == false) {
            b.setGrid1(b.index1(),b.index2(), 'X');
            b.scoreX(b.scoreX() + b.getGrid2(b.index1(),b.index2()));
        }
        else if(b.whichPlayer() == true) {
            b.setGrid1(b.index1(),b.index2(),'O');
            b.scoreO(b.scoreO() + b.getGrid2(b.index1(),b.index2()));
        }
        b.whichPlayer(!b.whichPlayer());
    }

    private boolean checkValidity(Board b) {
        if(b.position().length() != 2) {
            return false;
        }
        b.index1(b.position().charAt(0) - 'a');
        b.index2(Character.getNumericValue(b.position().charAt(1))-1);
        if(!Character.isLetter(b.position().charAt(0))) {
            return false;
        }
        if(!Character.isDigit(b.position().charAt(1))) {
            return false;
        }
        if(b.index1()>2 || b.index1()<0 || b.index2()>2 || b.index2()<0) {
            return false;
        }
        if(b.position().length()>2) {
            return false;
        }
        if(b.getGrid1(b.index1(),b.index2()) != '.') {
            return false;
        }
        return true;
    }

    public void displayBoard(Board b)
    {
        System.out.println("   123");
        for(int i=0; i<3; ++i) {
            switch(i) {
                case 0: System.out.print("a  ");
                        break;
                case 1: System.out.print("b  ");
                        break;
                case 2: System.out.print("c  ");
                        break;
            }
            for(int j=0; j<3; ++j) {
                System.out.print(b.getGrid1(i,j));
            }
            System.out.println();
        }
        System.out.println();
    }

    // ---------- Unit Testing -----------

    private void testDisplay() {
        Board test = new Board();
        test.position("a4");
        assert(!checkValidity(test));
        test.position("d1");
        assert(!checkValidity(test));
        test.position("1");
        assert(!checkValidity(test));
        test.position("a");
        assert(!checkValidity(test));
        test.position("");
        assert(!checkValidity(test));
        test.position("a1");
        assert(checkValidity(test));
        test.position("b2");
        assert(checkValidity(test));
        test.position("c3");
        assert(checkValidity(test));
    }
}

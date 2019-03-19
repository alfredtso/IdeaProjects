import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

import static java.lang.Math.abs;

public class Board {

    private char[] myBoard;
    private int dimension;
    private int manhattan;
    private Stack<Board> boards;

    public Board(int[][] blocks) {
        dimension = blocks.length;
        myBoard = new char[dimension * dimension];
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                int index = getIndex(i, j);
                myBoard[index] = (char) blocks[i][j];
            }
        }
    }

    private Board(char[] blocksArray) {
        myBoard = new char[blocksArray.length];
        System.arraycopy(blocksArray, 0, myBoard,0, blocksArray.length);
        dimension = (int) Math.sqrt(blocksArray.length);
    }

    private int getIndex(int row, int col) {
        return row * dimension + col;
    }

    private int getColumn(int index) {
        return index % dimension;
    }

    private int getRow(int index) {
        return index / dimension;
    }

    public int dimension() {
        return dimension;
    }

    public int hamming() {
        //return the number of blocks out of pos
        int result = 0;

        for (int i = 0; i < myBoard.length-1; i++) {
            if (myBoard[i] != i+1) result++;
        }

        return result;
    }

    public int manhattan() {
        int result = 0;

        for (int i = 0; i < myBoard.length; i++) {
            if (myBoard[i] != i+1 && myBoard[i] != 0)
            {
                int temp = myBoard[i];
                int currentPosCol = getColumn(i);
                int currentPosRow = getRow(i);
                int supposedPosCol = getColumn(temp-1);
                int supposedPosRow = getRow(temp - 1);

                result += abs(currentPosCol-supposedPosCol) +
                        abs(currentPosRow-supposedPosRow);
            }
        }
        return result;
    }

    public boolean isGoal() {
        for (int i = 0; i < myBoard.length; i++) {
            if ( myBoard[i] != i+1 && myBoard[i] !=0 ) return false;
        }
        return true;
    }

    public Board twin() {
        char[] copy = new char[dimension * dimension];
        System.arraycopy(myBoard, 0, copy, 0, myBoard.length);
        int randomIndex1 = StdRandom.uniform(myBoard.length);
        int randomIndex2 = randomIndex1 + 1;
        while (copy[randomIndex1] == 0 || copy[randomIndex2] == 0)
        {
            randomIndex1++;
            randomIndex2++;
        }
        char temp = copy[randomIndex1];
        copy[randomIndex1] = copy[randomIndex2];
        copy[randomIndex2] = temp;
        Board twin = new Board(copy);
        return twin;
    }

    // TODO: failed test
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Board that = (Board) other;
        return java.util.Arrays.equals(this.myBoard, that.myBoard);
    }

    public Iterable<Board> neighbors() {
        boards = new Stack<>();
        // loop through terrible nested if else
        for (int i = 0; i < myBoard.length; i++) {
            // check for 0 position
            if (myBoard[i] == 0) {
                // First Column case
                if ( i%dimension == 0) {
                    // Common to all first column case
                    boards.push(move(this, 2));
                    // First row first column
                    if ( i == 0) { boards.push(move(this,3));}
                    // Last row first column
                    else if ( i/dimension == dimension-1)
                    {
                        boards.push(move(this, 1));
                    }
                    else { boards.push(move(this, 1));
                           boards.push(move(this, 3)); }
                }
                // Last Column case
                else if ( i%dimension == dimension-1) {
                    // Common to all last column case
                    boards.push(move(this, 4));
                    // First row last column
                    if ( i/dimension == 0) { boards.push(move(this,3));}
                    // Last row last column
                    else if ( i/dimension == dimension-1)
                    {
                        boards.push(move(this, 1));
                    }
                    else { boards.push(move(this, 1));
                        boards.push(move(this, 3)); }
                }
                // In between columns
                else {
                    // all can move to left move to the right...
                    boards.push(move(this,2));
                    boards.push(move(this,4));
                    // First row, can only move down
                    if ( i/dimension == 0) {
                        boards.push(move(this,3));
                    }
                    // Last row, can only move up
                    // private method for checking first row and last row
                    else if ( i/dimension == dimension-1) {
                        boards.push(move(this,1));
                    }
                    else {
                        boards.push(move(this,1));
                        boards.push(move(this,3));
                    }
                }
            }
        }
        return boards;
    }

    private Board move(Board board, int direction) {
        // direction: 1 up 2 right 3 down 4 left, cw from 12

        char[] myChar = new char[board.myBoard.length];
        System.arraycopy(board.myBoard, 0, myChar, 0, board.myBoard.length);

        int indexToBeMoved = 0;
        int indexOfZero = 0;
        for (int i = 0; i < myBoard.length; i++) {
            if (myChar[i] == 0) {
                indexOfZero = i;
                if (direction == 1) {indexToBeMoved = i-board.dimension;}
                else if (direction == 2) {indexToBeMoved = i+1;}
                else if (direction == 3) {indexToBeMoved = i+board.dimension;}
                else if (direction == 4) {indexToBeMoved = i-1;}
                else throw new IllegalArgumentException();
                break;
            }
        }
        exch(myChar, indexOfZero, indexToBeMoved);
        return new Board(myChar);
    }

    private void exch(char[] myChar, int original, int after) {
        char temp = myChar[original];
        myChar[original] = myChar[after];
        myChar[after] = temp;
    }


//    private boolean cornerIndex(int i, int dimension) {
//        int length = dimension*dimension - 1;
//        if (i == 0) {return true;}
//        else if (i == dimension-1 ) {return true;}
//        else if (i == length) {return true;}
//        else return i == length - dimension;
//    }
    private static String padding(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    public String toString() {
        System.out.println(dimension);
        // TODO: amend later
        int maxlength = (int)(Math.log10(myBoard.length)) + 2;
        for (int i = 0; i < this.myBoard.length; i++) {
            String number = Integer.toString(myBoard[i]);
            String padded = padding(number, maxlength);
            System.out.print(padded);
            if ( i%dimension == dimension-1) {
                System.out.println();
            }
        }
        return "";
    }

    // TODO: Basic error checking for input

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        Board another = new Board(blocks);
        System.out.println(initial.hamming());
        System.out.println(initial.manhattan());
        System.out.println(initial.twin());
        System.out.println(initial.equals(another));
        System.out.println(initial.equals(initial));
        for (Board b: initial.neighbors()) {
            System.out.println(b);
        }
    }
}

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Solver {

    MinPQ<Manhattan> pq;
    Queue<Board> sol;

    private class Manhattan implements Comparable<Manhattan> {
        // TODO: not sure if all 3 is needed
        private int priority;
        private int manhattan;
        private final Board board;
        private final boolean valid;

        Manhattan(Board board, Board previousBoard, int moves) {
            this.board = board;
            this.valid = !board.equals(previousBoard);
            this.manhattan = board.manhattan();
            this.priority = manhattan + moves;
        }

        public int compareTo(Manhattan that) {
            // breaking ties case
            if (this.priority == that.priority) {
                return this.board.hamming() - that.board.hamming();
            }
            // < 0 meaning lower priority, therefore got removed earlier
            return this.priority - that.priority;
        }

        // TODO: critical optimization?
        public boolean isValid() {
            return valid;
        }

    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {

        // TODO: check initial validity
        // initialize
        pq = new MinPQ<>();
        sol = new Queue<>();

        // insert initial search node
        Board currentBoard = initial;
        sol.enqueue(initial);
        int moves = 0;

        while (!currentBoard.isGoal()) {

            //update moves
            moves++;

            // add first loop of search nodes
            Manhattan localval;
            Iterable<Board> debugWatch = currentBoard.neighbors();
            for (Board b : debugWatch) {
                localval = new Manhattan(b, currentBoard, moves);
                if (localval.isValid()) {
                    pq.insert(localval);
                }
            }

            //TODO: change to localval
            Manhattan currentNode = pq.delMin();
            currentBoard = currentNode.board;
            sol.enqueue(currentBoard);
        }

    }

    // is the initial board solvable?
    // TODO: implement
    public boolean isSolvable() {
        return false;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return 0;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return sol;
    }

    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        for (Board board : solver.solution())
            StdOut.println(board);

        // print solution to standard output
//        if (!solver.isSolvable())
//            StdOut.println("No solution possible");
//        else {
//            StdOut.println("Minimum number of moves = " + solver.moves());
//            for (Board board : solver.solution())
//                StdOut.println(board);
//        }
    }

}



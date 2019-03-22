import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Stack;

public class Solver {

    MinPQ<Manhattan> pq;
    Queue<Board> sol;
    Queue<Board> twinsSol;

    private class Manhattan implements Comparable<Manhattan> {
        // TODO: not sure if all 3 is needed
        private int priority;
        private int manhattan;
        private final Board board;
        private final boolean valid;
        private boolean twins = false;

        // TODO: need to include a twin and solve

        Manhattan(Board board, Board previousBoard, int moves) {
            this.board = board;
            this.valid = !board.equals(previousBoard);
            this.manhattan = board.manhattan();
            this.priority = manhattan + moves;
        }

        public int compareTo(Manhattan that) {
            // breaking ties case using hamming distance
            if (this.priority == that.priority) {
                return this.board.hamming() - that.board.hamming();
            }
            // < 0 meaning lower priority, therefore got removed earlier
            return this.priority - that.priority;
        }

        public boolean isValid() {
            return valid;
        }

        // todo: not sure if this is needed
        public void setTwins() { this.twins = true;}
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {

        // TODO: check initial validity
        // initialize
        pq = new MinPQ<>();
        sol = new Queue<>();
        twinsSol = new Queue<>();

        // insert initial search node
        Board currentBoard = initial;
        Board currentTwins = initial.twin();

    // if twin is solvable ( have a goal board) then the initial one is not solvable
        sol.enqueue(initial);
        twinsSol.enqueue(currentTwins);
        int moves = 0;
        // use boolean instead ?
        int twinTurn = 0;

        while (!currentBoard.isGoal()) {

            //update moves
            if (twinTurn%2 == 0) { moves++; }

            // add first loop of search nodes
            // todo; this is initial queue
            Manhattan localval;
            Iterable<Board> debugWatch;
            if (twinTurn%2 == 0) {
                debugWatch = currentBoard.neighbors();
                for (Board b : debugWatch) {
                    localval = new Manhattan(b, currentBoard, moves);
                    if (localval.isValid()) {
                        pq.insert(localval);
                    }
                }
                Manhattan currentNode = pq.delMin();
            }
            else {
                // todo refractor
                debugWatch = currentTwins.neighbors();
                for (Board b : debugWatch) {
                    localval = new Manhattan(b, currentTwins, moves);
                    localval.setTwins();
                    if (localval.isValid()) {
                        pq.insert(localval);
                    }
                }

                Stack<Manhattan> temp = new Stack<>();
                temp.contains()
                Manhattan currentNode = pq.delMin();
                if
            }

            //TODO: change to localval
            currentBoard = currentNode.board;
            sol.enqueue(currentBoard);

            // update twinTurn
            //todo: increment might overflow the int?
            twinTurn++;
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



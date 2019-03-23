import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Stack;

public class Solver {

    private MinPQ<Manhattan> pq;
    private Queue<Board> sol;
    private Queue<Board> twinsSol;
    private boolean solvable;
    private int moves;

    private class Manhattan implements Comparable<Manhattan> {
        // TODO: not sure if all 3 is needed
        private int priority;
        private int manhattan;
        private final Board board;
        private final boolean valid;
        private boolean twins;

        // TODO: need to include a twin and solve

        Manhattan(Board board, Board previousBoard, int moves, boolean twins) {
            this.board = board;
            this.valid = !board.equals(previousBoard);
            this.manhattan = board.manhattan();
            this.priority = manhattan + moves;
            this.twins = twins;
        }

        public int compareTo(Manhattan that) {
            // breaking ties case using hamming distance
            if (this.priority == that.priority) {
                return this.board.hamming() - that.board.hamming();
            }
            // < 0 meaning lower priority, therefore got removed earlier
            return this.priority - that.priority;
        }

        private boolean isValid() {
            return valid;
        }
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
        twinsSol.enqueue(currentTwins); // initial.twins?
        this.moves = 0;
        // use boolean instead ?
        int twinTurn = 0;

        // for temp storage
        Stack<Manhattan> temp = new Stack<>();
        Manhattan currentNode;
        Manhattan currentNodeTwins;

        while (!currentBoard.isGoal()) {

            //update moves
            if (twinTurn%2 == 0) { this.moves++; }

            // add first loop of search nodes
            // todo; this is initial queue
            Manhattan localval;
            Iterable<Board> debugWatch;
            if (twinTurn%2 == 0) {
                debugWatch = currentBoard.neighbors();
                for (Board b : debugWatch) {
                    localval = new Manhattan(b, currentBoard, moves, false);
                    if (localval.isValid()) {
                        pq.insert(localval);
                    }
                }

                // temp stack to store non twins node
                currentNode = pq.delMin();
                // while currentNode is twins
                while (currentNode.twins) {
                    temp.push(currentNode);
                    currentNode = pq.delMin();
                }

                // put it back, empty it
                while (!temp.empty()) {
                    pq.insert(temp.pop());
                }

                // update currentTwin
                currentBoard = currentNode.board;
                sol.enqueue(currentBoard);

                // todo: assertion should be turn off later
                assert temp.isEmpty();
            }
            // Twins case
            else {
                debugWatch = currentTwins.neighbors();
                for (Board b : debugWatch) {
                    localval = new Manhattan(b, currentTwins, moves, true);
                    if (localval.isValid()) {
                        pq.insert(localval);
                    }
                }

                // temp stack to store non twins node
                currentNodeTwins = pq.delMin();
                while (!currentNodeTwins.twins) {
                    temp.push(currentNodeTwins);
                    currentNodeTwins = pq.delMin();
                }

                // put it back
                while (!temp.empty()) {
                    pq.insert(temp.pop());
                }

                // update currentTwin
                currentTwins = currentNodeTwins.board;
                twinsSol.enqueue(currentTwins);

                //todo: assertion
                assert temp.isEmpty();
            }

            // update twinTurn, meaning if twinTurn odd num is initial even is twins
            //todo: increment might overflow the int?
            twinTurn++;
        }
        solvable = (twinTurn%2 == 1);
        System.out.println(isSolvable());

    }

    // is the initial board solvable?
    // TODO: implement
    public boolean isSolvable() {
        return solvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (isSolvable()) {
            return moves;
        }
        else { return -1;}
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (isSolvable()) {
            return sol;
        }
        else { return null; }
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

//         print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}



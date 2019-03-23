import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Stack;

public class Solver {

    private MinPQ<Manhattan> pq;
    private Stack<Board> sol;
    private boolean solvable;
    private int moves;

    private class Manhattan implements Comparable<Manhattan> {
        // TODO: not sure if all 3 is needed
        private int priority;
        private int manhattan;
        private int moves;
        private final Board board;
        private final Manhattan previousNode;
        private final boolean valid;
        private boolean twins;

        // TODO: need to include a twin and solve

        Manhattan(Board board, Manhattan previousNode, int moves, boolean twins) {
            this.board = board;
            this.previousNode = previousNode;
            if (previousNode == null) {
                this.valid = true;
            } else {
                this.valid = !board.equals(previousNode.board);
            }
            this.manhattan = board.manhattan();
            this.priority = manhattan + moves;
            this.twins = twins;
            this.moves = moves;
        }

        public int compareTo(Manhattan that) {
            // breaking ties case using hamming distance
            if (this.priority == that.priority) {
                return this.manhattan - that.manhattan;
            }
            // < 0 meaning lower priority, therefore got removed earlier
            return this.priority - that.priority;
        }

        private Manhattan previousNode() {
            return previousNode;
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
        sol = new Stack<>();

        // insert initial search node
        Board currentBoard = initial;
        Board currentTwins = initial.twin();

        // use boolean instead ?
        boolean twinTurn = false;

        // for temp storage
        Stack<Manhattan> temp = new Stack<>();
        Manhattan minNode = new Manhattan(initial, null, 0, false);
        Manhattan minNodeTwin = new Manhattan(initial.twin(), null, 0, true);

        while (!currentBoard.isGoal() && !currentTwins.isGoal()) {

            // add first loop of search nodes
            // todo; this is initial queue
            Manhattan localval;
            Iterable<Board> debugWatch;
            if (!twinTurn) {
                debugWatch = currentBoard.neighbors();
                for (Board b : debugWatch) {
                    localval = new Manhattan(b, minNode, minNode.moves + 1, false);
                    if (localval.isValid()) {
                        pq.insert(localval);
                    }
                }


                // temp stack to store non twins node
                minNode = pq.delMin();
                // while currentNode is twins
                while (minNode.twins) {
                    temp.push(minNode);
                    minNode = pq.delMin();
                }

                // put it back, empty it
                while (!temp.empty()) {
                    pq.insert(temp.pop());
                }

                // update currentTwin
                currentBoard = minNode.board;

                // TwinTue
                twinTurn = true;

                // todo: assertion should be turn off later
                assert temp.isEmpty();
            }
            // Twins case
            else {
                debugWatch = currentTwins.neighbors();
                for (Board b : debugWatch) {
                    localval = new Manhattan(b, minNodeTwin, minNodeTwin.moves + 1, true);
                    if (localval.isValid()) {
                        pq.insert(localval);
                    }
                }

                // temp stack to store non twins node
                minNodeTwin = pq.delMin();
                // while the node is not twins
                while (!minNodeTwin.twins) {
                    temp.push(minNodeTwin);
                    minNodeTwin = pq.delMin();
                }

                // put it back
                while (!temp.empty()) {
                    pq.insert(temp.pop());
                }

                // update currentTwin
                currentTwins = minNodeTwin.board;
                twinTurn = false;

                //todo: assertion
                assert temp.isEmpty();
            }

            // update twinTurn, meaning if twinTurn odd num is initial even is twins
            //todo: increment might overflow the int?
        }
        // because before twinturn is true
        solvable = currentBoard.isGoal();
        System.out.println(isSolvable());

        // todo: chase has problem
        // chase back from currentboard/currentnode
        if (isSolvable()) {
            while (minNode != null) {
                sol.push(minNode.board);
                moves++;
                minNode = minNode.previousNode();
            }
        }
    }

    // is the initial board solvable?
    // TODO: implement
    public boolean isSolvable() {
        return solvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (isSolvable()) {
            return moves - 1;
        } else {
            return -1;
        }
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        Queue<Board> result = new Queue<>();
        if (isSolvable()) {
            while (!sol.isEmpty()) {
                result.enqueue(sol.pop());
            }
            return result;
        } else {
            return null;
        }
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



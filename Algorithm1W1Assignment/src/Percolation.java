import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {


    private WeightedQuickUnionUF path;
    private boolean[] grid;             // true: open, false: close
    private int openedSites;            // number of opened entries
    private int side;                   // the length of the grid

    /**
     * Initialize a n^2 boolean array represent the n x n grid. Each entry initially false.
     *
     * @param n the length of the grid
     * @throws IllegalArgumentException if {@code n < 0}
     */

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be greater than zero");
        path = new WeightedQuickUnionUF(n * n + 2);
        grid = new boolean[n * n + 2];
        side = n;
        for (int i = 1; i < n * n + 1; i++) {
            grid[i] = false;
        }
        grid[0] = true;
        grid[n * n + 1] = true;
        openedSites = 0;
    }

    /**
     * Returns the index using row and col
     *
     * @param row ranging from 1 to n
     * @param col ranging from 1 to n
     * @return the index of grid represented by row and col
     */
    private int getIndex(int row, int col) {
        return (row - 1) * side + col;
    }

    private boolean isOpen(int index) {
        return grid[index];
    }

    private void legalArgs(int row, int col) {
        if (col < 1 || col > side) throw new IllegalArgumentException("please use prescribed range");
        if (row < 1 || row > side) throw new IllegalArgumentException("please use prescribed range");
    }

    /**
     * Open a site according to row and col
     *
     * @param row
     * @param col
     * @throws IllegalArgumentException unless {@code 1 <= row,col <= n}
     */
    public void open(int row, int col) {
        // Check pre-requisite
        legalArgs(row, col);
        int index = getIndex(row, col);
        if (isOpen(index)) {
            return;
        }

        // Get array index, Open it and increment openedSites
        grid[index] = true;
        openedSites++;

        // Get all the 4 possible position for checking isOpen
        int rowWisePrev = index - side, rowWiseNext = index + side,
                colWisePrev = index - 1, colWiseNext = index + 1;

        // Row wise : first row
        if (row == 1) {
            // connect the imaginary 0 point at the top
            path.union(0, index);
        } else if (isOpen(rowWisePrev)) {
            path.union(index, rowWisePrev);
        }

        if (row == side) {
            // connect the imaginary bottom
            path.union(side * side + 1, index);
        } else if (isOpen(rowWiseNext)) {
            path.union(index, rowWiseNext);
        }

        // Col wise :
        if (col != 1) {
            if (isOpen(colWisePrev)) {
                path.union(index, colWisePrev);
            }
        }

        if (col != side) {
            if (isOpen(colWiseNext)) {
                path.union(index, colWiseNext);
            }
        }
    }


    public boolean isOpen(int row, int col) {
        legalArgs(row, col);
        return grid[getIndex(row, col)];
    }

    public boolean isFull(int row, int col) {
        legalArgs(row, col);
        return !grid[getIndex(row,col)];
    }

    public int numberOfOpenSites() {
        return openedSites;
    }

    public boolean percolates() {
        return path.connected(0, side * side + 1);
    }

    public static void main(String[] args) {
        int n = 3;
        Percolation testing = new Percolation(n);
        System.out.println("Made " + n + " x " + n + " grids");
        testing.open(1, 1);
        testing.open(1, 2);
        testing.open(2, 2);
        testing.open(3, 2);
        System.out.println(testing.percolates());
        System.out.println(testing.isOpen(1,1));
        System.out.println(testing.isOpen(2,1));
        System.out.println(testing.isOpen(1,2));
        System.out.println(testing.isFull(2,1));
        System.out.println(testing.isFull(1,2));
        System.out.println(testing.numberOfOpenSites());
        //testing.open(4, 4);

    }

}


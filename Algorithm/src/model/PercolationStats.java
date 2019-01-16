package model;

public class PercolationStats {

    private Percolation myGrids;

    public PercolationStats(int n, int trials) {
       myGrids = new Percolation(n);

       for (int i = 0; i < trials; i++){
           int row = StdRandom.uniform(1,n);
           int col = StdRandom.uniform(1,n);
       }
    }
}

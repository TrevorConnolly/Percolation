import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    private double[] thresholds; // keeps an array of the threshold values
    private double constant = 1.96; // creates a variable to hold the constant
    private int tri; // holds an instance variable for the total trials

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("");
        }
        tri = trials;
        thresholds = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int randomnum1 = StdRandom.uniformInt(0, n);
                int randomnum2 = StdRandom.uniformInt(0, n);
                p.open(randomnum1, randomnum2);
            }
            thresholds[i] = ((double) p.numberOfOpenSites() / (n * n));
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return (mean() - ((constant * stddev()) / Math.sqrt(tri)));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return (mean() + ((constant * stddev()) / Math.sqrt(tri)));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        Stopwatch time = new Stopwatch();

        PercolationStats exp = new PercolationStats(n, t);
        StdOut.println("mean() = " + exp.mean());
        StdOut.println("stddev() = " + exp.stddev());
        StdOut.println("confidenceLow() = " + exp.confidenceLow());
        StdOut.println("confidenceHigh() = " + exp.confidenceHigh());
        double eltime = time.elapsedTime();
        StdOut.println("elapsed time = " + eltime);
    }
}

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid; // creates grid of sites nxn
    private int k; // k value max rows and cols
    private WeightedQuickUnionUF ex; // creates WeightedQuickUnionUF data type
    private int tracker; // used to keep track of total number of open sites
    private int top; // representing virtual top
    private int bottom; // representing virtual bottom

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        // verifies n is >0
        if (n <= 0) {
            throw new IllegalArgumentException("");
        }
        k = n;
        ex = new WeightedQuickUnionUF(n * n + 2); // add 2 to size for virtual
        // top and bottom
        grid = new boolean[n][n];
        tracker = 0;
        bottom = n * n + 1; // virtual bottom
        top = n * n; // virtual top

        // creates grid with all false sites initially
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!valIndex(row, col))
            throw new IllegalArgumentException("");

        // unions all items in top row to top virtual site
        if (row == 0) {
            ex.union(getIndex(row, col), top);
        }

        // unions all items in the bottom row to bottom virtual site
        if (row == k - 1) {
            ex.union(getIndex(row, col), bottom);
        }
        int index = getIndex(row, col);
        if (!grid[row][col]) {
            grid[row][col] = true;
            tracker++; // increments tracker by one each time a site is opened

            if (row + 1 < k && isOpen(row + 1, col))
                ex.union((index), index + k);
            if (row - 1 >= 0 && isOpen(row - 1, col))
                ex.union((index), index - k);
            if (col + 1 < k && isOpen(row, col + 1))
                ex.union((index), index + 1);
            if (col - 1 >= 0 && isOpen(row, col - 1))
                ex.union((index), index - 1);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!valIndex(row, col))
            throw new IllegalArgumentException("");
        else
            return (grid[row][col]);

    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!valIndex(row, col))
            throw new IllegalArgumentException("");
        return (ex.find(getIndex(row, col)) == ex.find(top)); // checks if
        // parent values match
    }


    // returns the number of open sites
    public int numberOfOpenSites() {
        return tracker;
    }

    // does the system percolate?
    public boolean percolates() {
        return ex.find(bottom) == ex.find(top); // checks if bottom virtual site
        // has same parent as top virtual site
    }

    // gets the proper index in one-d from the two-d grid of sites
    private int getIndex(int row, int col) {
        int index = row * k + col; // converts row, col form to one-d index form
        return index;
    }

    // ensures that the Index is valid depending on the max width/length of grid
    private boolean valIndex(int row, int col) {
        return !(row >= k || row < 0 || col >= k || col < 0);
    }

    // unit testing (required)
    public static void main(String[] args) {
        Percolation test = new Percolation(3);
        test.open(0, 2);
        test.open(1, 2);
        test.open(2, 2);
        System.out.println(test.isOpen(2, 2));
        System.out.println(test.isOpen(1, 1));
        System.out.println(test.percolates());
        System.out.println(test.isFull(1, 1));
        System.out.println(test.numberOfOpenSites());
    }

}

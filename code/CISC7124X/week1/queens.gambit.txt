public class Queens {

   /***************************************************************************
    * Return true if queen placement q[n] does not conflict with
    * other queens q[0] through q[n-1]
    ***************************************************************************/
    public static boolean isValid(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;   // same column
            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i)) return false;   // same minor diagonal
        }
        return true;
    }

   /***************************************************************************
    * Prints n-by-n placement of queens from permutation q in ASCII.
    ***************************************************************************/

    // learn more about Java StdOut
    // https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdOut.html
    public static void displayQueens(int[] q) {
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) StdOut.print("Q ");
                else           StdOut.print("* ");
            }
            StdOut.println();
        }  
        StdOut.println();
    }
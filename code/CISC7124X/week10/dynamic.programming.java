public class DP {
    /*
      table (+,+,min)
      egg(1,H,NTries) => NTries = H.
      egg(N,0,NTries) => NTries = 0.
      egg(N,H,NTries) =>
      between(1,H,K),
      egg(N-1,K-1,NTries1),
      egg(N,H-K,NTries2),
      NTries = max(NTries1,NTries2)+1.
    */
    public static int eggDrop(int n, int h) {
        int[][] table = new int[n+1][h+1];
        return eggDrop(n, h, table);
    }

    public static int eggDrop(int n, int h,  int[][] table) {
        if (n == 1) {
            table[n][h] = h;
        } else if (h == 0) {
            table[n][h] = 0;
        } else if (table[n][h] == 0) {
            int minDrops = Integer.MAX_VALUE, tempResult;
            for(int k = 1; k <= h; k++) {
                tempResult =  Math.max(eggDrop(n-1, k-1, table), eggDrop(n, h - k, table));
                minDrops = Math.min(tempResult, minDrops);
            }
            table[n][h] = minDrops + 1;
        }
        return table[n][h];
    }

    /*
      table
      largest_square(M,0,C,S) => S = 0.
      largest_square(M,_,0,S) => S = 0.
      largest_square(M,R,C,S) =>
      largest_square(M,R-1,C,S1),
      largest_square(M,R,C-1,S2),
      largest_square(M,R-1,C-1,S3),
      (M[R,C] == 1 -> S = min([S1,S2,S3])+1; S = 0).
    */
    public static int largeSubSqMatrix(int[][] m) {
        int r = m.length;
        int c = m[0].length;
        int[][] table = new int[r][c];
        largeSubSqMatrix(m, r-1, c-1, table);
        int maxSize = 0;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (table[i][j] > maxSize){
                    maxSize = table[i][k];
                }
            }
        }
        return maxSize;
    }


    public static int largeSubSqMatrix(int[][] m, int r, int c, int[][] table) {
        if (r < 0 || c < 0)
            return 0;
        if (table[r][c] == 0){
            int leftSize = largeSubSqMatrix(m, r, c-1, table);
            int topSize = largeSubSqMatrix(m, r-1, c, table);
            int diagonalSize = largeSubSqMatrix(m, r-1, c-1, table);
            if (m[r][c] != 0) {
                table[r][c] = 1 + Math.min(Math.min(topSize, leftSize), diagonalSize);
            }
        }
        return table[r][c];
    }

}
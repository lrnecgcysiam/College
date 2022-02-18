//required method to check the winner, return 'X' if 'X' won, 'O' if 'O'

// won, 'D' if draw or no one has won yet

// assuming board is a 3x3 board always

static char ticTacToe(char[][] board) {

    // looping from i=0 to i=2

    for (int i = 0; i < 3; i++) {

         // checking if row i has three 'X'

         if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {

             return 'X'; //'X' won

         }

         // checking if row i has three 'O'

         if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {

             return 'O'; //'O' won

         }

         // checking if column i has three 'X'

         if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') {

             return 'X';

         }

         // checking if column i has three 'O'

         if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O') {

             return 'O';

         }

    }

    //checking diagonally (top left to bottom right)

    if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {

         return 'X';

    }

    if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {

         return 'O';

    }

   

    //checking diagonally (top right to bottom left)

    if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') {

         return 'X';

    }

    if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O') {

         return 'O';

    }

    //draw or no one won

    return 'D';

}
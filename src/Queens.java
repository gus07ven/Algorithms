public class Queens {

  private static final int NUM_QUEENS = 4;
  private boolean[][] chessboard = new boolean[4][4];

  private void clearBoard(boolean[][] board){
    for(int row = 0; row < board.length; row++){
      for(int column = 0; column < board.length; column++){
        board[row][column] = false;
      }
    }
  }

  private boolean IsSafe(boolean[][] board, int row, int col){
    return (LowerDiagIsClear(board, row, col) &&
            RowIsClear(board, row, col) &&
            UpperDiagIsClear(board, row, col));
  }

  private boolean LowerDiagIsClear(boolean[][] board, int row, int col){
    return true;
  }

  private boolean RowIsClear(boolean[][] board, int row, int col){
    return true;
  }

  private boolean UpperDiagIsClear(boolean[][] board, int row, int col){
    return true;
  }

  public static void main(String[] args) {
   Queens game = new Queens();
   System.out.println(game.chessboard.length);
  }
}

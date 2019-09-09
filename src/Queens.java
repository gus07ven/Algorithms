public class Queens {

  private static final int NUM_QUEENS = 4;
  private boolean[][] chessboard = new boolean[4][4];

  public static void main(String[] args) {
   Queens game = new Queens();
    System.out.println(game.chessboard.length);
  }
}

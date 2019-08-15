public class TowerOfHanoi {

  private static void moves(int n, boolean left) {
    if (n == 0) return;
    moves(n-1, !left);
    if (left) StdOut.println(n + " left");
    else      StdOut.println(n + " right");
    moves(n-1, !left);
  }

  public static void main(String[] args) {
    int n = 4;
    moves(n, true);
  }
}

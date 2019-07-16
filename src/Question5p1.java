public class Question5p1 {

  // Update n by inserting m in the indexes indicated by i and j
  public static int updateBits(int n, int m, int i, int j){
    int allOnes = ~0;
    int left = allOnes << (j + 1);
    int right = ((1 << i) - 1);
    int mask = left | right;

    int n_cleared = n & mask;
    int m_shifted = m << i;
    return n_cleared | m_shifted;
  }

  public static void main(String[] args) {
    int n = 255;
    int m = 6;
    System.out.println(updateBits(n, m, 2, 5));
  }
}

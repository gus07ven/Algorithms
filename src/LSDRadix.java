// Radix sort based on the least significant digit.

public class LSDRadix {

  public static void sort(String[] a, int W){
    int R = 256;
    int N = a.length;
    String[] aux = new String[N];

    for(int d = W - 1; d >= 0; d--){
      int[] count = new int[R + 1];
      for(int i = 0; i < N; i++){
        count[a[i].charAt(d) + 1]++;
      }
      for(int r = 0; r < R; r++){
        count[r + 1] += count[r];
      }
      for(int i = 0; i < N; i++){
        aux[count[a[i].charAt(d)]++] = a[i];
      }
      for(int i = 0; i < N; i++){
        a[i] = aux[i];
      }
    }
  }

  public static void main(String[] args) {
    String[] strings = {"dab", "add", "cab", "fad", "fee", "bad", "dad",
                        "bee", "fed", "bed", "ebb", "ace"};
    sort(strings, 2);
    for(String s : strings){
      System.out.println(s);
    }
  }
}

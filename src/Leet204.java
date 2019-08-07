public class Leet204 {

  public static int countPrimes(int n) {
    if(n <= 2) return 0;

    int count = 1;
    for(int i = 2; i < n; i++){
      for(int j = 2; j < i; j++){
        if(i % j == 0) break;
        else if(j == i - 1) count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int n = 10;
    System.out.println(countPrimes(n));
  }
}

public class Leet476 {

  public static int findComplement(int num) {
    int numShifts = 0;

    while (num >> numShifts != 0) {
      numShifts++;
    }

    int mask = -1 >>> (32 - numShifts);
    return num ^ mask;
  }

  public static void main(String[] args) {
    int n = 0;
    System.out.println(findComplement(n));
  }
}

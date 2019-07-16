public class BitRev {

  public static void main(String[] args) {

    int x = 7;
    int y = 2;

    int test = x ^ 0;
    int test2 = x ^ 1;
    int test3 = x ^ x;
    int test4 = x ^ y;

    System.out.println(test4);

    int and1 = x & 0;
    int and2 = x & 1;
    int and3 = x & x;

    System.out.println(and2);

    int or1 = x | 0;
    int or2 = x | 1;
    int or3 = x | x;

    System.out.println(or2);
  }
}

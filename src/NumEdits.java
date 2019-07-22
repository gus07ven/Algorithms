public class NumEdits {

  public static void main(String[] args) {

    // Bitwise operators
    // ~ NOT = ~x == (-x) - 1
    System.out.println("NOT result of ~1 = " + ~1);
    System.out.println("NOT result of ~-10 = " + ~-10);

    // Bitwise AND(&), logical AND(&&)
    // AND = only true if both are true (1 & 1 = 1), (0 & 1 = 0), (0 & 0 = 0).
    // Example:
    // 38 = 10 0110
    // 23 = 01 0111
    //  6 = 00 0110 (result)
    System.out.println("AND result of 38 & 23 = " + (38 & 23));

    // Bitwise OR(|), logical OR(||)
    // OR = only true if there is one true anywhere. The only that is false is both false (0 | 0 = 0)
    // Example:
    // 38 = 10 0110
    // 23 = 01 0111
    // 55  = 11 0111 (result)
    System.out.println("OR results of 38 | 23 = " + (38 | 23));

    // Bitwise XOR(^), logical XOR(^)
    // XOR = only true if bits are different. (1 ^ 0 = 1).
    // Example:
    // 38 = 10 0110
    // 23 = 01 0111
    // 49 = 11 0001 (result)
    System.out.println("OR results of 38 ^ 23 = " + (38 ^ 23));

    // Bitwise left shift(<<)
    // A left shift is equivalent to multiplying by 2.
    System.out.println("40 << 1 = " + (40 << 1));
    System.out.println("-20 << 2 = " + (-20 << 2));

    // Bitwise right shift(>>)
    // A right shift is equivalent to dividing by 2. We are doing integer division (40/16) = 2.5 = 2.
    // (40/ 262144) = 0.0001525.. = 0
    System.out.println("40 >> 1 = " + (40 >> 1));
    System.out.println("-20 >> 2 = " + (-20 >> 2));

    // Bitwise right shift(>>>). NOTE: the extra >
    // With positive numbers everything is the same. A right shift is equivalent to dividing by 2.
    // We are doing integer division (40/16) = 2.5 = 2. (40/ 262144) = 0.0001525.. = 0
    // With negative numbers >>> changes the value to a positive number, >> maintains the resulting value as negative.
    System.out.println("-1 >>> 1 = " + (-1 >>> 1));
    System.out.println("-1 >> 1 = " + (-1 >> 1));

    // Get ith bit
    byte test = 0b00101100;
    System.out.println((1 << 5));
  }

}

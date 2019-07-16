public class BitRev {

  public static int repeatedArithmeticShift(){
    int x = -93242;
    int count = 40;
    for(int i = 0; i < count; i++){
      x >>= 1;  // Arithmetic shift by 1
    }
    return x;
  }

  public static int repeatedLogicalShift(){
    int x = -93242;
    int count = 40;
    for(int i = 0; i < count; i++){
      x >>>= 1;  // Logical shift by 1
    }
    return x;
  }

  public static boolean getBit(int num, int i){
    return (num & (1 << i)) != 0;
  }

  public static int setBit(int num, int i){
    return num | (1 << i);
  }

  public static int clearBit(int num, int i){
    int mask = ~(1 << i);
    return num & mask;
  }

  public static int clearBitMSBthroughI(int num, int i){
    int mask = (1 << i) - 1;
    return num & mask;
  }

  public static int clearBitsIthrough0(int num, int i){
    int mask = (-1 << (i + 1));
    return num & mask;
  }

  public static int updateBit(int num, int i, boolean bitIs1){
    int value = bitIs1 ? 1 : 0;
    int mask = ~(1 << i);
    return (num & mask) | (value << i);
  }

  public static void main(String[] args) {

    int x = 7;
    int y = 2;

    int test = x ^ 0;
    int test2 = x ^ 1;
    int test3 = x ^ x;
    int test4 = x ^ y;

//    System.out.println(test4);

    int and1 = x & 0;
    int and2 = x & 1;
    int and3 = x & x;

//    System.out.println(and2);

    int or1 = x | 0;
    int or2 = x | 1;
    int or3 = x | x;

//    System.out.println(or2);

//    System.out.println(repeatedArithmeticShift());
//    System.out.println(repeatedLogicalShift());

    System.out.println("Get bit examples: ");
    System.out.println(getBit(6, 2));
    System.out.println(getBit(6, 0));

    System.out.println("Set bit examples: ");
    System.out.println(setBit(6, 2));
    System.out.println(setBit(6, 0));

    System.out.println("Clear bit examples: ");
    System.out.println(clearBit(14, 3));
    System.out.println(clearBit(6, 1));

    System.out.println("Clear MSB-i examples: ");
    System.out.println(clearBitMSBthroughI(50, 1));
    System.out.println(clearBitMSBthroughI(50, 4));

    System.out.println("Clear Ithrough0 examples: ");
    System.out.println(clearBitsIthrough0(50, 2));
    System.out.println(clearBitsIthrough0(50, 4));

    System.out.println("Update bit examples: ");
    System.out.println(updateBit(50, 1, true));
    System.out.println(updateBit(50, 5, false));
  }
}

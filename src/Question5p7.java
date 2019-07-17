public class Question5p7 {

  public static int swapPairs(int num){
    if(num == 0) return 0;

    int mask = 1;
    int even = 0;
    int odd = 0;
    Stack<Integer> revNum = new Stack<>();

    for(int i = num; i != 0; i >>= 2){
      even = (i & mask) != 0 ? 1 : 0;
      odd = ((i >> 1) & mask) != 0 ? 1 : 0;
      if(even != odd){
        revNum.push(odd);
        revNum.push(even);
      } else {
        revNum.push(even);
        revNum.push(odd);
      }
    }

    StringBuilder finalNum = new StringBuilder();
    while(!revNum.isEmpty()){
      finalNum.append(revNum.pop());
    }

    return Integer.parseInt(finalNum.toString(), 2);
  }

  public static void main(String[] args) {
    int num = 21;
    System.out.println(swapPairs(num));
  }
}

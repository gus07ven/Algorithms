public class SieveOfErastosthenes {

  public static boolean[] sieveOfEratosthenes(int max){
    boolean[] flags = new boolean[max + 1];
    int count = 0;

    initFlags(flags);
    int prime = 2;

    while(prime <= Math.sqrt(max)){
      crossOff(flags, prime);
      prime = getNextPrime(flags, prime);
    }
    return flags;
  }

  private static void initFlags(boolean[] flags){
    for(int i = 2; i < flags.length; i++){
      flags[i] = true;
    }
  }

  private static void crossOff(boolean[] flags, int prime){
    for(int i = prime * prime; i < flags.length; i += prime){
      flags[i] = false;
    }
  }

  private static int getNextPrime(boolean[] flags, int prime){
    int next = prime + 1;
    while(next < flags.length && !flags[next]){
      next++;
    }
    return next;
  }

  public static void main(String[] args) {
    int max = 121;
    boolean[] result = sieveOfEratosthenes(max);
    for(int i = 0; i < result.length; i++){
      if(result[i]) System.out.println(i);
    }
  }
}

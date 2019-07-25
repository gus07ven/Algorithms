import java.util.Random;

public class BoyGirlRatio {

  public static double runNFamilies(int n){
    int boys = 0;
    int girls = 0;
    for(int i = 0; i < n; i++){
      int[] genders = runOneFamily();
      girls += genders[0];
      boys += genders[1];
    }
    return girls / (double) (boys + girls);
  }

  public static int[] runOneFamily(){
    Random random = new Random();
    int boys = 0;
    int girls = 0;
    while(girls == 0){
      if(random.nextBoolean()){
        girls += 1;
      } else {
        boys += 1;
      }
    }
    int[] genders = {girls, boys};
    return genders;
  }

  public static void main(String[] args) {
    int fam = 10;
    int fam2 = 100;
    int fam3 = 1000;
    System.out.println("Boy to girl ratio for " + fam + " families is " + runNFamilies(fam));
    System.out.println("Boy to girl ratio for " + fam2 + " families is " + runNFamilies(fam2));
    System.out.println("Boy to girl ratio for " + fam3 + " families is " + runNFamilies(fam3));
  }
}

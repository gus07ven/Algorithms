public class BoyGirlRatio {

  public static double runNFamilies(int n){
    int boys = 0;
    int girls = 0;
    for(int i = 0; i < n; i++){
      int[] genders = runOneFamily();
      girls += genders[0];
      boys += genders[0];
    }
    return girls / (double) (boys + girls);
  }
}

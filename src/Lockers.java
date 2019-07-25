public class Lockers {

  public static int numOpenDoors(int numLockers){
    if(numLockers == 0) return 0;
    if(numLockers < 2) return 1;

    boolean[] lockers = new boolean[numLockers + 1];
    openAllDoors(lockers);
    closeEvery2ndDoor(lockers);
    toggleDoors(lockers);
    return countOpenDoors(lockers);
  }

  private static void openAllDoors(boolean[] lockers){
    for(int i = 0; i < lockers.length; i++){
      lockers[i] = true;
    }
  }

  private static void closeEvery2ndDoor(boolean[] lockers){
    for(int i = 0; i < lockers.length; i++){
      if(i % 2 == 0) lockers[i] = false;
    }
  }

  private static void toggleDoors(boolean[] lockers){
    for(int i = 3; i < lockers.length; i++) {
      for (int j = i; j < lockers.length; j++) {
        if (j % i == 0) lockers[j] = !lockers[j];
      }
    }
  }

  private static int countOpenDoors(boolean[] lockers){
    int openDoors = 0;
    for(int i = 1; i < lockers.length; i++){
      if(lockers[i]) openDoors++;
    }
    return openDoors;
  }

  public static void main(String[] args) {
    int numLockers = 100;
    System.out.println(numOpenDoors(numLockers));
  }
}

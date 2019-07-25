public class EggDrop {

  int breakingPoint = 100;
  int countDrops = 0;

  public boolean drop(int floor){
    countDrops++;
    return floor >= breakingPoint;
  }

  public int findBreakingPoint(int floors){
    int interval = 14;
    int previousFloor = 0;
    int egg1 = interval;

    // Drop egg1 at decreasing intervals
    while(!drop(egg1) && egg1 <= floors){
      interval -= 1;
      previousFloor = egg1;
      egg1 += interval;
    }

    int egg2 = previousFloor + 1;
    while(egg2 < egg1 && egg2 <= floors && !drop(egg2)){
      egg2 += 1;
    }

    return egg2 > floors ? -1 : egg2;
  }

  public static void main(String[] args) {
    EggDrop ed = new EggDrop();
    int floors = 100;
    System.out.println(ed.findBreakingPoint(100));
    System.out.println("The number of drops for " + floors + " is " + ed.countDrops);
  }
}

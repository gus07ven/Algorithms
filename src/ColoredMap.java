public class ColoredMap {

  private int[][] map;

  public void createMap(){
    map = new int[7][];
    map[0] = new int[] { 1, 4, 2, 5};
    map[1] = new int[] { 0, 4, 6, 5};
    map[2] = new int[] { 0, 4, 3, 6, 5};
    map[3] = new int[] {2, 4, 6};
    map[4] = new int[] {0, 1, 6, 3, 2};
    map[5] = new int[] {2, 6, 1, 0};
    map[6] = new int[] {2, 3, 4, 1, 5};
  }

}

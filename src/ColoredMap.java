public class ColoredMap {

  private int[][] map;
  private static final int NONE = 0;
  private static final int RED = 1;
  private static final int YELLOW = 2;
  private static final int GREEN = 3;
  private static final int BLUE = 4;
  private int[] mapColors = { NONE, NONE, NONE, NONE, NONE, NONE, NONE};

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

  public boolean okToColor(int country, int color){
    for (int i = 0; i < map[country].length; i++) {
      int ithAdjCountry = map[country][i];
      if(mapColors[ithAdjCountry] == color) return false;
    }
    return true;
  }

  public boolean explore(int country, int color){
    if(country >= map.length) return true;
    if(okToColor(country, color)){
      mapColors[country] = color;
      for(int i = RED; i <= BLUE; i++){
        if(explore(country + 1, i)) return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    ColoredMap map = new ColoredMap();
    map.createMap();
  }

}

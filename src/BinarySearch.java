import java.util.Arrays;

public class BinarySearch {

  public static int binarySearch(int[] array, int key){
    int low = 0;
    int high = array.length - 1;

    while(low <= high){
      int mid = low + (high - low) / 2;
      if(key < array[mid]) high = mid - 1;
      else if(key > array[mid]) low = mid + 1;
      else return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    In input = new In(args[0]);
    In values = new In(args[1]);
    int[] whitelist = input.readAllInts();
    int[] keys = values.readAllInts();
    Arrays.sort(whitelist);

    for (Integer key : keys) {
      if(binarySearch(whitelist, key) == -1)
        StdOut.println(key);
    }
  }
}

public class BinarySearch {

  public static binarySearch(int[] array, int key){
    int low = 0;
    int high = array.length - 1;

    while(low <= high){
      int mid = low + (high - low) / 2;
      if(key < array[mid]) high = mid - 1;
      else if(key > array[mid]) low = mid + 1;
      else return mid
    }
    return -1;
  }

}

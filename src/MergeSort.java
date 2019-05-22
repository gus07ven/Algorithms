import java.util.Arrays;

public class MergeSort {

  public static void mergesort(int[] arr){
    int[] helper = new int[arr.length];
    mergesort(arr, helper, 0, arr.length - 1);
  }

  private static void mergesort(int[] arr, int[] helper, int low, int high){
    if(low < high){
      int middle = (low + high)/ 2;
      mergesort(arr, helper, low, middle);
      mergesort(arr, helper, middle + 1, high);
      merge(arr, helper, low, middle, high);
    }
  }

  private static void merge(int[] arr, int[] helper, int low, int middle, int high){
    for(int i = low; i <= high; i++){
      helper[i] = arr[i];
    }

    int helperLeft = low;
    int helperRight = middle + 1;
    int current = low;

    while(helperLeft <= middle && helperRight <= high){
      if(helper[helperLeft] <= helper[helperRight]){
        arr[current] = helper[helperLeft];
        helperLeft++;
      } else {
        arr[current] = helper[helperRight];
        helperRight++;
      }
      current++;
    }

    int remaining = middle - helperLeft;
    for(int i = 0; i <= remaining; i++){
      arr[current + i] = helper[helperLeft + i];
    }
  }

  public static void main(String[] args) {
    int[] array = {8, 9, 12, 0, 3, 7, 2};
    mergesort(array);
    System.out.println(Arrays.toString(array));
  }
}

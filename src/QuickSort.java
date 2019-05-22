import java.util.Arrays;

public class QuickSort {

  public static void quickSort(int[] arr, int left, int right){
    int index = partition(arr, left, right);
    if (left < index - 1){
      quickSort(arr, left, index - 1);
    }
    if (right > index){
      quickSort(arr, index, right);
    }
  }

  public static int partition(int[] arr, int left, int right){
    int pivot = arr[(left + right)/2];
    while (left <= right){
      while(arr[left] < pivot) left++;
      while(arr[right] > pivot) right--;
      if(left <= right){
        swap(arr, left, right);
        left++;
        right--;
      }
    }
    return left;
  }

  public static void swap(int[] arr, int left, int right){
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {15, 3, 9, 8, 5, 2, 7, 1, 6};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}

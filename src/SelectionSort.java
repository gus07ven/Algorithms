public class SelectionSort {

  public static void sort(Comparable[] a){
    int N = a.length;
    for(int i = 0; i < N; i++){
      int min = i;
      for(int j = i + 1; j < N; j++){
        if(Helper.less(a[j], a[min])){
          min = j;
        }
      }
      Helper.exch(a, i, min);
    }
  }

  public static void main(String[] args) {
    Character[] text = {'S','O','R','T','E','X','A','M','P','L','E'};
    SelectionSort.sort(text);
    for (Object i : text) {
      System.out.println(i);
    }
  }
}

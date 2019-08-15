
// API
// Item get - get item by index
// void add - append item to end of list
// Item remove - remove item by index

public class MyArrayList<Item> {

  private Object[] items;
  private int initCapacity = 10;
  private int currentIndex = 0;

  public Item get(int index){
    if(index > items.length) return null;
    for(int i = 0; i < items.length; i++){
      if(i == index) return (Item) items[i];
    }
  }
}

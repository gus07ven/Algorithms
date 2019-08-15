
// API
// Item get - get item by index
// void add - append item to end of list
// Item remove - remove item by index

public class MyArrayList<Item> {

  private Object[] items = new Object[10];
  private int currentIndex = 0;

  public Item get(int index){
    if(index < 0 || index > items.length) return null;
    Item item = null;
    for(int i = 0; i < items.length; i++) {
      if (i == index) {
        item = (Item) items[i];
        break;
      }
    }
    return item;
  }

  public void add(Item item){
    if(currentIndex > items.length) resize(2 * items.length);
    items[currentIndex++] = item;
  }

  public Item remove(int index){
    if(index < 0 || index > items.length - 1) return null;
    else {
      Item item = (Item) items[index];
      reorderItems(index);
      currentIndex = currentIndex == 0 ? 0 : currentIndex--;
      if(currentIndex < items.length / 4) resize(items.length / 2);
      return item;
    }
  }

  private Object[] resize(int newCapacity){
    Object[] copy = new Object[newCapacity];
    for(int i = 0; i < items.length; i++){
      copy[i] = items[i];
    }
    items = copy;
    return items;
  }

  private void reorderItems(int startingIndex){
    for(int i = 0; i < items.length; i++){
      if(i >= startingIndex) items[i] = i == items.length - 1 ? null : items[i + 1];
    }
  }

  public static void main(String[] args) {
    MyArrayList list = new MyArrayList();
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    System.out.println(list.get(3));
  }
}

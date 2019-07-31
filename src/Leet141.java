import java.util.HashMap;

public class Leet141 {
  public static boolean hasCycle(SLinkedList.Node head) {
    if(head == null) return false;

    HashMap<SLinkedList.Node,Integer> values = new HashMap<>();
    SLinkedList.Node root = head;
    int pos = 0;
    while(root != null){
      if(values.containsKey(root)){
        return true;
      } else {
        values.put(root, pos);
      }
      pos++;
      root = root.next;
    }
    return false;
  }

  public static void main(String[] args) {
    SLinkedList.Node head = new SLinkedList.Node(1);
    SLinkedList.Node two = new SLinkedList.Node(2);
    SLinkedList.Node three = new SLinkedList.Node(3);
    head.next = two;
    two.next = three;
    three.next = head;

    System.out.println(hasCycle(head));
  }
}

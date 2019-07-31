import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

  public static boolean hasCycle2(SLinkedList.Node head){
    Set<SLinkedList.Node> nodesSeen = new HashSet<>();
    while (head != null) {
      if (nodesSeen.contains(head)) {
        return true;
      } else {
        nodesSeen.add(head);
      }
      head = head.next;
    }
    return false;
  }

  public static boolean hasCycleSlowFast(SLinkedList.Node head){
    if(head == null || head.next == null){
      return false;
    }
    SLinkedList.Node slow = head;
    SLinkedList.Node fast = head.next;
    while(slow != fast){
      if(fast == null || fast.next == null) return false;
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }

  public static void main(String[] args) {
    SLinkedList.Node head = new SLinkedList.Node(1);
    SLinkedList.Node two = new SLinkedList.Node(2);
    SLinkedList.Node three = new SLinkedList.Node(3);
    head.next = two;
    two.next = three;
    three.next = head;

    System.out.println(hasCycle(head));
    System.out.println(hasCycle2(head));
    System.out.println(hasCycleSlowFast(head));
  }
}

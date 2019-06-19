import java.util.HashSet;

public class Question2p8 {

  static SLinkedList.Node findCycleNode(SLinkedList.Node head){
    if(head == null) return null;

    HashSet<SLinkedList.Node> set = new HashSet<>();
    while(head != null){
      if(set.contains(head)){
        break;
      } else {

        set.add(head);
        head = head.next;
      }
    }
    return head;
  }


  public static void main(String[] args) {
    // To run my implementation
    SLinkedList.Node head = new SLinkedList.Node(3);
    SLinkedList.Node node1 = new SLinkedList.Node(1);
    SLinkedList.Node node2 = new SLinkedList.Node(5);
    SLinkedList.Node node3 = new SLinkedList.Node(9);
    SLinkedList.Node node4 = new SLinkedList.Node(7);
    SLinkedList.Node node5 = new SLinkedList.Node(2);
    SLinkedList.Node node6 = new SLinkedList.Node(1);
    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node4;
    SLinkedList sll = new SLinkedList();
    sll.head = head;
    System.out.println("The corrupt node is: " + findCycleNode(head).data);
  }
}

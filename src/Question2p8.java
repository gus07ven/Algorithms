import java.util.HashSet;

public class Question2p8 {

  static SLinkedList.Node findCycleUsingRunners(SLinkedList.Node head){
    if(head == null) return null;

    SLinkedList.Node slow = head;
    SLinkedList.Node fast = head;

    // Find meeting point. This will be LOOP_SIZE - k steps into the linked list.
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){  // Collision
        break;
      }
    }

    // Error check - no meeting point, and therefore no loop
    if(fast == null || fast.next == null){
      return null;
    }

    // Move slow to head. Keep fast at meeting point. Each are k steps from the loop start. If they move at the
    // same pace, they must meet at Loop Start.
    slow = head;
    while(slow != fast){
      slow = slow.next;
      fast = fast.next;
    }

    // Both now point to the start of the loop
    return fast;
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
    System.out.println("The corrupt node is: " + findCycleUsingRunners(head).data);
  }
}

public class Partitioner {

  static SLinkedList.Node partition(SLinkedList.Node head, int p){
    if(head == null) return null;

    SLinkedList.Node leftPart = null;
    SLinkedList.Node rightPart = null;
    SLinkedList.Node beginRightPart = null;
    SLinkedList.Node finalList = null;

    while(head != null){
      if(head.data < p){
        if(leftPart == null) leftPart = new SLinkedList.Node(head.data);
        else {
          SLinkedList.Node headLeft = leftPart;
          while(headLeft.next != null) headLeft = headLeft.next;
          headLeft.next = new SLinkedList.Node(head.data);
        }
      } else {
        if(rightPart == null){
          rightPart = new SLinkedList.Node(head.data);
          beginRightPart = rightPart;
        } else {
          while(rightPart.next != null) rightPart = rightPart.next;
          rightPart.next = new SLinkedList.Node(head.data);
        }
      }
      head = head.next;
    }

    if(leftPart == null) return beginRightPart;

    finalList = leftPart;
    while(leftPart.next != null) leftPart = leftPart.next;
    leftPart.next = beginRightPart;
    return finalList;
  }

  static LinkedListNode partitionTwo(LinkedListNode node, int x){
    LinkedListNode beforeStart = null;
    LinkedListNode beforeEnd = null;
    LinkedListNode afterStart = null;
    LinkedListNode afterEnd = null;

    // Partition list
    while(node != null){
      LinkedListNode next = node.next;
      node.next = null;
      if(node.data < x){
        // Insert node into end of before list
        if(beforeStart == null){
          beforeStart = node;
          beforeEnd = beforeStart;
        } else {
          beforeEnd.next = node;
          beforeEnd = node;
        }
      } else {
        // Insert node into end of after list
        if(afterStart == null){
          afterStart = node;
          afterEnd = afterStart;
        } else {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      node = next;
    }

    if(beforeStart == null){
      return afterStart;
    }

    // Merge before list and after list
    beforeEnd.next = afterStart;
    return beforeStart;
  }

  static LinkedListNode partitionThree(LinkedListNode node, int x){
    LinkedListNode head = node;
    LinkedListNode tail = node;

    while(node != null){
      LinkedListNode next = node.next;
      if(node.data < x){
        // Insert node at head
        node.next = head;
        head = node;
      } else {
        // Insert node at tail
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    tail.next = null;

    // The head has changed, so we need to return it to the user
    return head;
  }

  public static void main(String[] args) {

    // Using my classes
    System.out.println("-----Partition-------");
    SLinkedList.Node head = new SLinkedList.Node(7);
    SLinkedList.Node node1 = new SLinkedList.Node(3);
    SLinkedList.Node node2 = new SLinkedList.Node(5);
    SLinkedList.Node node3 = new SLinkedList.Node(1);
    SLinkedList.Node node4 = new SLinkedList.Node(6);
    SLinkedList.Node node5 = new SLinkedList.Node(12);
    SLinkedList.Node node6 = new SLinkedList.Node(8);

    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;

    SLinkedList sll = new SLinkedList();
    sll.head = partition(head, 3);
    sll.printList();

    // Using book classes
    System.out.println("-----Partition Two-------");
    LinkedListNode h = new LinkedListNode(7);
    LinkedListNode n1 = new LinkedListNode(3);
    LinkedListNode n2 = new LinkedListNode(5);
    LinkedListNode n3 = new LinkedListNode(1);
    LinkedListNode n4 = new LinkedListNode(6);
    LinkedListNode n5 = new LinkedListNode(12);
    LinkedListNode n6 = new LinkedListNode(8);
    h.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
//    LinkedListNode result = null;
//    result = partitionTwo(h, 3);
//
//    while(result != null){
//      System.out.println(result.data);
//      result = result.next;
//    }

    System.out.println("-----Partition Three------");
    LinkedListNode result3 = null;
    result3 = partitionThree(h, 3);

    while(result3 != null){
      System.out.println(result3.data);
      result3 = result3.next;
    }
  }
}

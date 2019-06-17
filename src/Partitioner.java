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

  public static void main(String[] args) {
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
  }

}

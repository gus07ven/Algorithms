public class KthElement {

  static SLinkedList.Node getKthNode(SLinkedList.Node head, int k){
    if(head == null) return null;
    SLinkedList.Node headCopy = head;
    int size = 0;
    int counter = 1;

    while(head != null){
      head = head.next;
      size++;
    }

    while(counter < (size - k)){
      headCopy = headCopy.next;
      counter++;
    }
    return headCopy;
  }

  static SLinkedList.Node getKthNodeConstSpace(SLinkedList.Node head, int k){
    if(head == null) return null;
    SLinkedList.Node p1 = head;
    SLinkedList.Node p2 = head;
    int counter = 0;
    while(head.next != null){
      if(counter != k && counter < k){
        p2 = p2.next;
        counter++;
      } else {
        p1 = p1.next;
        p2 = p2.next;
      }
      head = head.next;
    }
    return p1;
  }

  public static void main(String[] args) {
    SLinkedList.Node head = new SLinkedList.Node(7);
    SLinkedList.Node node1 = new SLinkedList.Node(3);
    SLinkedList.Node node2 = new SLinkedList.Node(5);
    SLinkedList.Node node3 = new SLinkedList.Node(1);
    SLinkedList.Node node4 = new SLinkedList.Node(3);
    SLinkedList.Node node5 = new SLinkedList.Node(5);
    SLinkedList.Node node6 = new SLinkedList.Node(8);

    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;

    System.out.println(getKthNodeConstSpace(head, 4).data);
  }
}




public class Question2p7 {

  SLinkedList.Node findIntersection(SLinkedList.Node list1, SLinkedList.Node list2){
     if(list1 == null || list2 == null) return null;

     // Get tail and size
    Result result1 = getTailAndSize(list1);
    Result result2 = getTailAndSize(list2);

    if(result1.tail != result2.tail){
      return null;
    }

    SLinkedList.Node shorter = result1.size < result2.size ? list1 : list2;
    SLinkedList.Node longer = result1.size < result2.size ? list2 : list1;

    longer = getKthNode(longer, Math.abs(result1.size - result2.size));

    while(shorter != longer){
      shorter = shorter.next;
      longer = longer.next;
    }
    return longer;
  }

  class Result {
    public SLinkedList.Node tail;
    public int size;
    public Result(SLinkedList.Node tail, int size){
      this.tail = tail;
      this.size = size;
    }
  }

  Result getTailAndSize(SLinkedList.Node list){
    if(list == null) return null;

    int size = 1;
    SLinkedList.Node current = list;
    while(current.next != null){
      size++;
      current = current.next;
    }
    return new Result(current, size);
  }

  SLinkedList.Node getKthNode(SLinkedList.Node head, int k){
    SLinkedList.Node current = head;
    while(k > 0 && current != null){
      current = current.next;
      k--;
    }
    return current;
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
      SLinkedList.Node head2 = new SLinkedList.Node(4);
      SLinkedList.Node node11 = new SLinkedList.Node(6);
      head2.next = node11;
      node11.next = node4;
      SLinkedList sll = new SLinkedList();
      sll.head = head;
      sll.printList();
      Question2p7 q27 = new Question2p7();
      System.out.println("The intersecting node is: " + q27.findIntersection(head, head2).data);
  }
}

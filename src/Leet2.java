import java.math.BigInteger;

public class Leet2 {

  public static SLinkedList.Node addTwoNumbers(SLinkedList.Node l1, SLinkedList.Node l2) {
    SLinkedList.Node dummyHead = new SLinkedList.Node(0);
    SLinkedList.Node p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.data : 0;
      int y = (q != null) ? q.data : 0;
      int sum = carry + x + y;
      carry = sum / 10;
      curr.next = new SLinkedList.Node(sum % 10);
      curr = curr.next;
      if (p != null) p = p.next;
      if (q != null) q = q.next;
    }
    if (carry > 0) {
      curr.next = new SLinkedList.Node(carry);
    }
    return dummyHead.next;
  }

  public static void main(String[] args) {
    SLinkedList.Node head = new SLinkedList.Node(7);
    SLinkedList.Node node1 = new SLinkedList.Node(1);
//    SLinkedList.Node node2 = new SLinkedList.Node(6);
//    SLinkedList.Node node3 = new SLinkedList.Node(3);
    head.next = node1;
//    node1.next = node2;
//    node2.next = node3;
    SLinkedList.Node head2 = new SLinkedList.Node(5);
    SLinkedList.Node node4 = new SLinkedList.Node(9);
//    SLinkedList.Node node5 = new SLinkedList.Node(2);
//    SLinkedList.Node node6 = new SLinkedList.Node(8);
    head2.next = node4;
//    node4.next = node5;
//    node5.next = node6;
    SLinkedList.Node sll = new SLinkedList.Node();

    sll = addTwoNumbers(head, head2);

    while(sll != null){
      System.out.println(sll.data);
      sll = sll.next;
    }
  }

}

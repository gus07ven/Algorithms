import java.math.BigInteger;

public class Leet2 {

  public static SLinkedList.Node addTwoNumbers(SLinkedList.Node l1, SLinkedList.Node l2) {
    Stack<Integer> num1 = new Stack<>();
    while(l1 != null){
      num1.push(l1.data);
      l1 = l1.next;
    }

    Stack<Integer> num2 = new Stack<>();
    while(l2 != null){
      num2.push(l2.data);
      l2 = l2.next;
    }

    StringBuilder s1 = new StringBuilder();
    while(!num1.isEmpty()) s1.append(num1.pop());

    StringBuilder s2 = new StringBuilder();
    while(!num2.isEmpty()) s2.append(num2.pop());

    BigInteger n1 = new BigInteger(s1.toString());
    BigInteger n2 = new BigInteger(s2.toString());
    BigInteger total = n1.add(n2);
    String stotal = total.toString();
    SLinkedList.Node head = null;

    for(Character c : stotal.toCharArray()){
      int value = Integer.parseInt(c.toString());
      if(head == null) {
        head = new SLinkedList.Node(value);
      } else {
        SLinkedList.Node prevHead = head;
        head = new SLinkedList.Node(value);
        head.next = prevHead;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    SLinkedList.Node head = new SLinkedList.Node(7);
    SLinkedList.Node node1 = new SLinkedList.Node(1);
    SLinkedList.Node node2 = new SLinkedList.Node(6);
    //    SLinkedList.Node node3 = new SLinkedList.Node(3);
    head.next = node1;
    node1.next = node2;
    //    node2.next = node3;
    SLinkedList.Node head2 = new SLinkedList.Node(5);
    SLinkedList.Node node4 = new SLinkedList.Node(9);
    SLinkedList.Node node5 = new SLinkedList.Node(2);
    SLinkedList.Node node6 = new SLinkedList.Node(8);
    head2.next = node4;
    node4.next = node5;
    node5.next = node6;
    SLinkedList.Node sll = new SLinkedList.Node();

    sll = addTwoNumbers(head, head2);

    while(sll != null){
      System.out.println(sll.data);
      sll = sll.next;
    }
  }

}

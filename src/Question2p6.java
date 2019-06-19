
public class Question2p6 {

  static private boolean isPalindrome(SLinkedList.Node head){
    if(head == null) return false;

    SLinkedList.Node headCopy = head;
    int listSize = 0;

    while(head != null){
      head = head.next;
      listSize++;
    }

    return isListPalindrome(headCopy, listSize);
  }

  static private boolean isListPalindrome(SLinkedList.Node head, int listSize){
    Stack<Integer> st = new Stack<>();
    int position = 0;

    while(head != null && position != (listSize / 2)){
      st.push(head.data);
      head = head.next;
      position++;
    }

    if(listSize % 2 != 0) {
      head = head.next;
    }

    while(head != null){
      if(st.pop() != head.data) {
        return false;
      }
      head = head.next;
    }
    return st.isEmpty();
  }

  static boolean isPalindromeTwo(LinkedListNode head){
    LinkedListNode fast = head;
    LinkedListNode slow = head;

    Stack<Integer> stack = new Stack<Integer>();

    while(fast != null && fast.next != null){
      stack.push(slow.data);
      slow = slow.next;
      fast = fast.next.next;
    }

    if(fast != null){
      slow = slow.next;
    }

    while(slow != null){
      int top = stack.pop().intValue();

      if(top != slow.data){
        return false;
      }
      slow = slow.next;
    }
    return true;
  }

  public static void main(String[] args) {

    // To run my implementation
//    SLinkedList.Node head = new SLinkedList.Node(0);
//    SLinkedList.Node node1 = new SLinkedList.Node(1);
//    SLinkedList.Node node2 = new SLinkedList.Node(2);
//    SLinkedList.Node node3 = new SLinkedList.Node(2);
//    SLinkedList.Node node4 = new SLinkedList.Node(1);
//    SLinkedList.Node node5 = new SLinkedList.Node(2);
////    SLinkedList.Node node6 = new SLinkedList.Node(0);
//    head.next = node1;
//    node1.next = node2;
//    node2.next = node3;
//    node3.next = node4;
//    node4.next = node5;
////    node5.next = node6;
//    SLinkedList sll = new SLinkedList();
//    sll.head = head;
//    sll.printList();
//    System.out.println(isPalindrome(head));

    // To run books method
    LinkedListNode h = new LinkedListNode(0);
    LinkedListNode n1 = new LinkedListNode(1);
    LinkedListNode n2 = new LinkedListNode(6);
    LinkedListNode n3 = new LinkedListNode(6);
    LinkedListNode n4 = new LinkedListNode(1);
    LinkedListNode n5 = new LinkedListNode(0);
    h.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    System.out.println(isPalindromeTwo(h));
  }
}

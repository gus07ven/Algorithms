import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Question2p6 {

  static boolean isPalindrome(SLinkedList.Node head){
    if(head == null) return false;

    SLinkedList.Node headCopy = head;
    int listSize = 0;

    while(head != null){
      head = head.next;
      listSize++;
    }

    return isListPalindrome(headCopy, listSize);
  }

  static boolean isListPalindrome(SLinkedList.Node head, int listSize){
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
      if(st.peek() == head.data) {
        st.pop();
      } else {
       return false;
      }
      head = head.next;
    }
    return st.isEmpty();
  }

  public static void main(String[] args) {

    SLinkedList.Node head = new SLinkedList.Node(0);
    SLinkedList.Node node1 = new SLinkedList.Node(1);
    SLinkedList.Node node2 = new SLinkedList.Node(2);
    SLinkedList.Node node3 = new SLinkedList.Node(3);
    SLinkedList.Node node4 = new SLinkedList.Node(2);
    SLinkedList.Node node5 = new SLinkedList.Node(1);
    SLinkedList.Node node6 = new SLinkedList.Node(1);
    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    SLinkedList sll = new SLinkedList();
    sll.head = head;
    sll.printList();

    System.out.println(isPalindrome(head));
  }

}

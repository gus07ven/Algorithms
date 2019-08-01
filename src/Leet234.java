import java.util.ArrayList;

public class Leet234 {

  public static boolean isPalindrome(SLinkedList.Node head) {
    if(head == null) return true;

    ArrayList<Integer> nums = new ArrayList<>();

    while(head != null){
      nums.add(head.data);
      head = head.next;
    }

    int leftPtr = 0;
    int rightPtr = 0;
    if(nums.size() % 2 == 0){
      leftPtr = (nums.size()/2) - 1;
      rightPtr = (nums.size()/2);
    } else {
      leftPtr = rightPtr = nums.size() / 2;
    }

    while(leftPtr >= 0 && rightPtr < nums.size()){
      if(!nums.get(leftPtr).equals(nums.get(rightPtr))) return false;
      else {
        leftPtr--;
        rightPtr++;
      }
    }
    return true;
  }

  public static boolean isPalindromeOpt(SLinkedList.Node head) {
    SLinkedList.Node fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
      slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;

    while (slow != null) {
      if (fast.data != slow.data) {
        return false;
      }
      fast = fast.next;
      slow = slow.next;
    }
    return true;
  }

  public static void main(String[] args) {
    SLinkedList.Node head = new SLinkedList.Node(3);
    SLinkedList.Node node1 = new SLinkedList.Node(1);
    SLinkedList.Node node2 = new SLinkedList.Node(1);
    SLinkedList.Node node3 = new SLinkedList.Node(1);
    SLinkedList.Node node4 = new SLinkedList.Node(1);
    SLinkedList.Node node5 = new SLinkedList.Node(3);
//    SLinkedList.Node node6 = new SLinkedList.Node(1);
    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = null;
//    node6.next = node4;
    System.out.println(isPalindrome(head));
    System.out.println(isPalindromeOpt(head));
  }
}

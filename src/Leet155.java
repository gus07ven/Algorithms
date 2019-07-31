import java.util.ArrayList;

// Assuming that I can't use a Java stack as underlying ds.
public class Leet155 {

    ArrayList<Integer> stack;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public Leet155() {
      this.stack = new ArrayList<>();
    }

    public void push(int x) {
      if(x < this.min) this.min = x;
      this.stack.add(x);
    }

    public void pop() {
      if(stack.size() == 0) return;
      if(stack.get(stack.size() - 1) == min){
        stack.remove(stack.size() - 1);
        this.min = Integer.MAX_VALUE;
        for(Integer i : stack){
          if(i < min) min = i;
        }
      } else {
        stack.remove(stack.size() - 1);
      }
    }

    public int top() {
      if(stack.size() == 0){
        return 0;
      } else {
        return stack.get(stack.size() - 1);
      }
    }

    public int getMin() {
      return min;
    }

  public static void main(String[] args) {
     int x = -2;
     int x2 = 0;
     int x3 = -3;
     Leet155 obj = new Leet155();
     obj.push(x);
     obj.push(x2);
     obj.push(x3);
     obj.pop();
     int param_3 = obj.top();
     int param_4 = obj.getMin();

  }
}

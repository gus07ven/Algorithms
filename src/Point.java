public class Point {

  public int row;
  public int column;

  public Point(int r, int c){
    row = r;
    column = c;
  }

  public String toString(){
    return "(" + row + ", " + column + ")";
  }

  public int hashCode(){
    return this.toString().hashCode();
  }

  public boolean equals(Object o){
    if((o instanceof Point) && (((Point) o).row == this.row) && (((Point) o).column == this.column)){
      return true;
    } else {
      return false;
    }
  }
}

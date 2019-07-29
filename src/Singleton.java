public class Singleton {

  private static Singleton _instance = null;

  protected Singleton(){}

  public static Singleton getInstance(){
    if(_instance == null){
      _instance = new Singleton();
    }
    return _instance;
  }

  public static void main(String[] args) {
    Singleton s = getInstance();
    Singleton same = getInstance();
    System.out.println(s.equals(same));
  }
}


public class StringRev {

  public static void main(String[] args) {
    String randomString = "I'm just a randomstring";
    String gotToQuote = "He said, \"I'm here\"";

    System.out.println(randomString);
    System.out.println(gotToQuote);

    StringBuilder randSB = new StringBuilder("This string");
    System.out.println(randSB);
    System.out.println(randSB.append(" is crazy"));
    System.out.println(randSB.delete(0,4));

    StringBuilder rand2 = new StringBuilder("and likes to party.");
    System.out.println(rand2);
    System.out.println(randSB.insert(0, "This"));
    StringBuilder longString = randSB.append(" " + rand2);
    System.out.println(longString);

    String regString = longString.toString();
    System.out.println(regString.getClass());

  }
}

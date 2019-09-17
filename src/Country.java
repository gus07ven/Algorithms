import java.util.ArrayList;
import java.util.List;


public class Country {

  private int population;
  private String continent;

  public Country(int population, String continent){
    this.population = population;
    this.continent = continent;
  }

  public int getPopulation(){
    return this.population;
  }

  public String getContinent(){
    return this.continent;
  }

  public static int getPopulation(List<Country> countries, String continent){
    return countries.stream().map(c -> c.getContinent().equals(continent)? c.getPopulation() : 0)
            .reduce(0, (a, b) -> a + b);
  }

  public static void main(String[] args) {
    Country usa = new Country(300, "North America");
    Country canada = new Country(100, "North America");
    Country venezuela = new Country(30, "South America");
    List<Country> countries = new ArrayList<>();
    countries.add(usa);
    countries.add(canada);
    countries.add(venezuela);

    System.out.println(Country.getPopulation(countries, "South America"));
    System.out.println(Country.getPopulation(countries, "North America"));
  }
}

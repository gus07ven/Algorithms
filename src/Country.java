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
}

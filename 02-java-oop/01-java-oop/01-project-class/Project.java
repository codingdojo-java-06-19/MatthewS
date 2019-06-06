public class Project {
  private String name;
  private String description;

  public Project() {
    this.name = "Atomic Whoopie";
    this.description = "Very powerful whoopie cushions.";
  }

  public String elevatorPitch() {
    return this.name + " : " + this.description;
  }

  public Project(String name) {
    this.name = name;
    this.description = "Very powerful whoopie cushions.";
  }

  public Project(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
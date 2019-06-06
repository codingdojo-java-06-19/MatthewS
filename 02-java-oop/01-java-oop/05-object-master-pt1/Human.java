class Human {
  public int strength = 3;
  public int stealth = 3;
  public int intelligence = 3;
  public int health = 100;

  public Human() {
    this.strength = 3;
    this.stealth = 3;
    this.intelligence = 3;
    this.health = 100;
  }

  public void displayHealth() {
    System.out.println("This imaginary savage current has: " + health);
  }

  public void attack(Human otherPlayer) {
    otherPlayer.health = otherPlayer.health - this.strength;
    System.out.println("Direct Hit! Health has been reduced by: " + this.strength + " to " + otherPlayer.health);
  }

}
class Ninja extends Human {
  public Ninja() {
    this.stealth = 10;
  }

  public void steal(Human otherHuman) {
    otherHuman.health = otherHuman.health - this.stealth;
    System.out.println("The Ninja just took " + this.stealth + " health from the other player.");
  }

  public void runAway() {
    health = health - 10;
    System.out.println("The ninja wasn't so tough, he ran away and lost 10 health! Current Health: " + health);
  }
}

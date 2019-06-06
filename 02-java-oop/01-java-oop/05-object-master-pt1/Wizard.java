class Wizard extends Human {

  public Wizard() {
    this.health = 50;
    this.intelligence = 8;
  }

  public void heal(Human otherHuman) {
    otherHuman.health = otherHuman.health + intelligence;
    System.out.println(
        "The Wizard just healed the other player for: " + intelligence + " Giving them health of " + otherHuman.health);
  }

  public void fireball(Human otherHuman) {
    otherHuman.health = otherHuman.health - this.intelligence * 3;
    System.out
        .println("The Wizard just cast a fireball that seared the other players face for " + this.intelligence * 3);
  }
}
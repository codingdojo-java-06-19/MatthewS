class Samurai extends Human {

  private static int numSamurai = 0;

  public Samurai() {
    this.health = 200;
    numSamurai++;
  }

  public void deathBlow(Human otherHuman) {
    otherHuman.health = otherHuman.health - otherHuman.health;
    this.health = this.health / 2;
    System.out.println(
        "The Samurai has dealt a DEATH BLOW, Killing the other player, but decreasing his own health by half.");
  }

  public void meditate() {
    this.health = this.health += this.health / 2;
    System.out.println("The Samurai channeled his inner Yanni and healed himself for half his health!");
  }

  public void howMany() {
    System.out.println("There are currently " + numSamurai + " up in here.");
  }
}
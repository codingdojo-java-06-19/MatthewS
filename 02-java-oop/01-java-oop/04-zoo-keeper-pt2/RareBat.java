class RareBat extends Mammal {

  public void fly() {
    energyLevel = energyLevel - 50;
    System.out
        .println("Flap, Flap, Flap. Flying, looking for it's next victim: (-50 Energy) New Energy: " + energyLevel);
  }

  public void eatHuman() {
    energyLevel = energyLevel + 25;
    System.out.println("This human was mighty tender! (+25 Energy) New Energy: " + energyLevel);
  }

  public void attackTown() {
    energyLevel = energyLevel - 100;
    System.out.println("**sounds of fire and calamity engulf the town** (-100 Energy) New Energy: " + energyLevel);
  }
}
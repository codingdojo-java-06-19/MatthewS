class Gorilla extends Mammal {

  public void announcePresence() {
    System.out.println("I'm a gorilla, hear me roar!");
  }

  public void throwSomething() {
    energyLevel = energyLevel - 5;
    System.out.println("Nailed him! (-5 energy) New Energy: " + energyLevel);
  }

  public void eatBananas() {
    energyLevel = energyLevel + 10;
    System.out.println("Those were good! (+10 energy) New Energy: " + energyLevel);
  }

  public void climb() {
    energyLevel = energyLevel - 10;
    System.out.println("You just climbed pretty high! (-10 energy) New Energy: " + energyLevel);
  }
}
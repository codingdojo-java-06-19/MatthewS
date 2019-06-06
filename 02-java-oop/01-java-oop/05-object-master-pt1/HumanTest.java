class HumanTest {
  public static void main(String[] args) {
    Wizard w = new Wizard();
    Wizard w2 = new Wizard();
    Ninja n = new Ninja();
    Ninja n2 = new Ninja();
    n.steal(n2);
    n.runAway();
    n.steal(n2);
    n.displayHealth();
    n2.displayHealth();
    Samurai s = new Samurai();
    Samurai s2 = new Samurai();
    s.deathBlow(n2);
    n2.displayHealth();
    s.displayHealth();
    s.howMany();
  }
}
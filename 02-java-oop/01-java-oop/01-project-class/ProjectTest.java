class ProjectTest {
  public static void main(String[] args) {
    Project p = new Project();
    System.out.println(p.getName());
    System.out.println(p.elevatorPitch());
    p.setName("Atomic Whoopie v2");
    System.out.println(p.getName());
    p.setDescription("Even more powerful whoopie cushion!");
    System.out.println(p.getDescription());
    System.out.println(p.elevatorPitch());

    Project p2 = new Project("Digital Camera Dog Toy", "Dogs can now take selfies too!");
    System.out.println(p2.getName());
    System.out.println(p2.elevatorPitch());
  }
}
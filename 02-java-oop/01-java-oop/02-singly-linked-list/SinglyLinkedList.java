public class SinglyLinkedList {
  public Node head;

  public SinglyLinkedList() {

  }

  // SLL Methods here.
  public void add(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      System.out.println("Node: " + newNode + " has been added!");
    } else {
      Node runner = head;
      while (runner.next != null) {
        runner = runner.next;
      }
      runner.next = newNode;
    }
  }

  public void remove() {
    if (head == null) {
      System.out.println("There are no values");
    } else if (head.next == null) {
      head = null;
    } else {
      Node runner = head;
      while (runner.next.next != null) {
        runner = runner.next;
      }
      System.out.println(runner.value + " has been removed from the list.");
      runner.next = null;
    }
  }

  public void printValues() {
    Node runner = head;
    while (runner != null) {
      System.out.println("Node: " + runner.value);
      runner = runner.next;
    }
  }
}
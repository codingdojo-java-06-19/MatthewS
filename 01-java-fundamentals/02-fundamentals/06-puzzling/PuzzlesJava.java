public class PuzzlesJava {
  public static void main(String[] args) {
    int[] myArray = { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 };
    PuzzlesJava.greaterThanTen(myArray);
  }

  public static void greaterThanTen(int[] arr) {
    ArrayList<Integer> newArr = new ArrayList<Integer>();
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (arr[i] > 10) {
        newArr.add(arr[i]);
      }
    }
    System.out.println(sum);
    System.out.println(newArr);
  }

}
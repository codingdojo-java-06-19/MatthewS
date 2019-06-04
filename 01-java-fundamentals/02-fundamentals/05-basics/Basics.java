import java.util.ArrayList;
import java.util.Arrays;

public class Basics {
  public static void main(String[] args) {
    // Basics.oneTo255();
    // Basics.oddOneTo255();
    // Basics.sumOneTo255();
    // int[] X = { 1, 3, 5, 7, 9, 13 };
    // Basics.printArray(X);
    // int[] X = { -3, -5, -7 };
    // Basics.findMax(X);
    // int[] X = { 2, 10, 3 };
    // Basics.getAverage(X);
    // Basics.arrayOddNumbers();
    // int[] X = { 1, 3, 5, 7 };
    // int y = 3;
    // Basics.greaterThanY(X, y);

    // int[] X = { 1, 5, 10, -2 };
    // Basics.squareValues(X);

    // int[] X = { 1, 5, 10, -2 };
    // Basics.eliminateNegative(X);

    // int[] X = { 1, 5, 10, -2 };
    // Basics.minMaxAvg(X);

    int[] X = { 1, 5, 10, 7, -2 };
    Basics.shiftValues(X);
  }

  public static void oneTo255() {
    for (int i = 0; i <= 255; i++) {
      System.out.println(i);
    }
  }

  public static void oddOneTo255() {
    for (int i = 1; i <= 255; i += 2) {
      System.out.println(i);
    }
  }

  public static void sumOneTo255() {
    int sum = 0;
    for (int i = 0; i <= 255; i++) {
      sum += i;
      System.out.println("New Number: " + i + " Sum: " + sum);
    }
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    System.out.println(max);
  }

  public static void getAverage(int[] arr) {
    int avg = 0;
    for (int i = 0; i < arr.length; i++) {
      avg += arr[i];
    }
    int num = (avg / arr.length);
    System.out.println(num);
  }

  public static void arrayOddNumbers() {
    ArrayList<Integer> y = new ArrayList<Integer>();
    for (int i = 1; i <= 255; i += 2) {
      y.add(i);
    }
    System.out.println(y);
  }

  public static void greaterThanY(int[] arr, int y) {
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > y) {
        result += 1;
      }
    }
    System.out.println(result);
  }

  public static void squareValues(int[] arr) {
    ArrayList<Integer> myArray = new ArrayList<Integer>();
    for (int i = 0; i < arr.length; i++) {
      myArray.add(arr[i] * arr[i]);
    }
    System.out.println(myArray);
  }

  public static void eliminateNegative(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {
        arr[i] = 0;
      }
    }
    System.out.println(arr);
  }

  public static void minMaxAvg(int[] arr) {
    ArrayList<Integer> myArray = new ArrayList<Integer>();
    int max = arr[0];
    int min = arr[0];
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (arr[i] > max) {
        max = arr[i];
      } else if (arr[i] < min) {
        min = arr[i];
      }
    }
    myArray.add(max);
    myArray.add(min);
    int avg = (sum / arr.length);
    myArray.add(avg);
    System.out.println(myArray);
  }

  public static void shiftValues(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[arr.length - 1] = 0;
    System.out.println(arr);
  }
}
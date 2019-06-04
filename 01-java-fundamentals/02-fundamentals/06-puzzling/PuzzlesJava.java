import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzlesJava {

  public ArrayList greaterThanTen(int[] myArray) {
    int sum = 0;
    ArrayList<Integer> myArr = new ArrayList<Integer>();
    for (int i = 0; i < myArray.length; i++) {
      sum += myArray[i];

      if (myArray[i] > 10) {
        myArr.add(myArray[i]);
      }
    }
    System.out.println(sum);
    System.out.println(myArr);
    return myArr;
  }

  public ArrayList shuffleNames() {
    ArrayList<String> names = new ArrayList<String>();
    names.add("Nancy");
    names.add("Jinichi");
    names.add("Fujibayashi");
    names.add("Momochi");
    names.add("Ishikawa");
    Collections.shuffle(names);

    ArrayList<String> longNames = new ArrayList<String>();
    for (String name : names) {
      System.out.println(name);
      if (name.length() > 5) {
        longNames.add(name);
      }
    }
    System.out.println(longNames);
    return longNames;
  }

  public ArrayList shuffleAlpha() {
    ArrayList<Character> alphabet = new ArrayList<Character>();
    alphabet.add('a');
    alphabet.add('b');
    alphabet.add('c');
    alphabet.add('d');
    alphabet.add('e');
    alphabet.add('f');
    alphabet.add('g');
    alphabet.add('h');
    alphabet.add('i');
    alphabet.add('j');
    alphabet.add('k');
    alphabet.add('k');
    alphabet.add('l');
    alphabet.add('m');
    alphabet.add('n');
    alphabet.add('o');
    alphabet.add('p');
    alphabet.add('q');
    alphabet.add('r');
    alphabet.add('s');
    alphabet.add('t');
    alphabet.add('u');
    alphabet.add('v');
    alphabet.add('w');
    alphabet.add('x');
    alphabet.add('y');
    alphabet.add('z');
    Collections.shuffle(alphabet);

    System.out.println(alphabet.get(0));
    System.out.println(alphabet.get(alphabet.size() - 1));

    Character[] vowel = { 'a', 'e', 'i', 'o', 'u' };
    for (int i = 0; i < vowel.length; i++) {
      if (alphabet.get(0) == vowel[i]) {
        System.out.println("special message");
      }
    }

    return alphabet;
  }

  public ArrayList random55100() {
    ArrayList<Integer> num = new ArrayList<Integer>();
    Random rnd = new Random();
    for (int i = 0; i < 10; i++) {
      num.add(rnd.nextInt(100 - 55 + 1) + 55);
    }

    System.out.println(num);
    return num;
  }

  public ArrayList randNums() {
    ArrayList<Integer> num = new ArrayList<Integer>();
    Random rnd = new Random();
    for (int i = 0; i < 10; i++) {
      num.add(rnd.nextInt(100 - 55 + 1) + 55);
    }
    Collections.sort(num);
    System.out.println(num);
    // for (int nums : num) {
    // System.out.println(nums);
    // }

    System.out.println(num.get(0));
    System.out.println(num.get(num.size() - 1));
    return num;
  }

  public String randStr() {
    Random rnd = new Random();
    char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z' };
    String myStr = "";
    for (int i = 0; i < 5; i++) {
      int randNum = (rnd.nextInt(26) + 1);
      myStr += alpha[randNum];
    }
    System.out.println(myStr);
    return myStr;
  }

  public String[] randArr() {
    Random rnd = new Random();
    String[] arr = new String[10];
    char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z' };
    for (int i = 0; i < 10; i++) {
      String newStr = "";
      for (int j = 0; j < 5; j++) {
        int randNum = (rnd.nextInt(26));
        newStr += alpha[randNum];
      }
      arr[i] = newStr;
    }
    System.out.println(Arrays.toString(arr));
    return arr;
  }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Test {
  public static void main(String[] args) {
    PuzzlesJava pz = new PuzzlesJava();

    int[] myArray = { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 };
    pz.greaterThanTen(myArray);

    pz.shuffleNames();

    pz.shuffleAlpha();

    pz.random55100();

    pz.randNums();

    pz.randStr();

    pz.randArr();
  }

}
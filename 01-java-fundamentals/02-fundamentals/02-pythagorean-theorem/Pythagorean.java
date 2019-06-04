public class Pythagorean {
  public double calculateHypotenuse(int LegA, int LegB) {
    int squareA = LegA * LegA;
    int squareB = LegB * LegB;
    int total = squareA + squareB;
    double c = Math.sqrt(total);
    return c;
  }
}
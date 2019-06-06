public class Iphone extends Phone implements Ringable {
  public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
    super(versionNumber, batteryPercentage, carrier, ringTone);
  }

  @Override
  public String ring() {
    return getRingTone();
  }

  @Override
  public String unlock() {
    return "Password accepted! Phone is unlocked!";
  }

  @Override
  public void displayInfo() {
    String version = getVersionNumber();
    int battery = getBatteryPercentage();
    String carry = getCarrier();
    System.out.println("Phone is: " + version + " Battery Percentage: " + battery + " On Carrier: " + carry);
  }
}
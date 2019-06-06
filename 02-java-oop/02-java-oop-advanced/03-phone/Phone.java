public abstract class Phone {
  private String versionNumber;
  private int batteryPercentage;
  private String carrier;
  private String ringTone;

  public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
    this.versionNumber = versionNumber;
    this.batteryPercentage = batteryPercentage;
    this.carrier = carrier;
    this.ringTone = ringTone;
  }

  // abstract method. subclasses will get this implemented
  public abstract void displayInfo();

  public String getVersionNumber() {
    return this.versionNumber;
  }

  public String getCarrier() {
    return this.carrier;
  }

  public String getversionNumber() {
    return this.versionNumber;
  }

  public int getBatteryPercentage() {
    return this.batteryPercentage;
  }

  public String getRingTone() {
    return this.ringTone;
  }
}
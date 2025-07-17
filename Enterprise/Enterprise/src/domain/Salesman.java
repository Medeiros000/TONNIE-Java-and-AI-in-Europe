package domain;

public non-sealed class Salesman extends Employee {
  private double percentPerSold;
  private double soldAmount;

  public Salesman() {
  }

  public Salesman(double percentPerSold, double soldAmount, String code, String name, String address, int age,
      double salary) {
    super(code, name, address, age, salary);
    this.percentPerSold = percentPerSold;
    this.soldAmount = soldAmount;
  }

  @Override
  public String getCode() {
    return "SL" + this.code;
  }

  public double getPercentPerSold() {
    return percentPerSold;
  }

  public void setPercentPerSold(double percentPerSold) {
    this.percentPerSold = percentPerSold;
  }

  public double getSoldAmount() {
    return soldAmount;
  }

  public void setSoldAmount(double soldAmount) {
    this.soldAmount = soldAmount;
  }

  @Override
  public double getFullSalary() {
    return this.salary + (soldAmount * percentPerSold);
  }

}

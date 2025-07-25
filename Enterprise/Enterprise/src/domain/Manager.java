package domain;

public non-sealed class Manager extends Employee {
  private String login;
  private String password;
  private double commission;

  public Manager() {
  }

  public Manager(String login, String password, double commission, String code, String name, String address, int age,
      double salary) {
    super(code, name, address, age, salary);
    this.login = login;
    this.password = password;
    this.commission = commission;
  }

  @Override
  public String getCode() {
    return "MN" + this.code;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public double getCommission() {
    return commission;
  }

  public void setCommission(double commission) {
    this.commission = commission;
  }

  @Override
  public double getFullSalary() {
    return this.salary + this.commission;
  }

  public double getFullSalary(double extra) {
    return this.getFullSalary() + extra;
  }

}

public record Pentagon(double side) implements GeometricForm {
  @Override
  public double getArea() {
    double apothem = side / (2 * Math.tan(Math.PI / 5));
    return (5 * side * apothem) / 2;
  }

  @Override
  public String toString() {
    return String.format("Pentagon with side: %.2f, Area: %.2f", side, getArea());
  }
}

public record Square(double side) implements GeometricForm {
  @Override
  public double getArea() {
    return side * side;
  }

  @Override
  public String toString() {
    return String.format("Square with side: %.2f, Area: %.2f", side, getArea());
  }
}

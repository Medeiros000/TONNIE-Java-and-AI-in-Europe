public record Hexagon(double side) implements GeometricForm {
  @Override
  public double getArea() {
    return (3 * Math.sqrt(3) * side * side) / 2;
  }

  @Override
  public String toString() {
    return String.format("Hexagon with side: %.2f, Area: %.2f", side, getArea());
  }
}

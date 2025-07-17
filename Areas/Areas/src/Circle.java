public record Circle(double radius) implements GeometricForm {
  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return String.format("Circle with radius: %.2f, Area: %.2f", radius, getArea());
  }
}

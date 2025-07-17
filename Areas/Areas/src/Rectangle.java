public record Rectangle(double length, double width) implements GeometricForm {
  @Override
  public double getArea() {
    return length * width;
  }

  @Override
  public String toString() {
    return String.format("Rectangle with length: %.2f, width: %.2f, Area: %.2f", length, width, getArea());
  }
}

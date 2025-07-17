
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    var scanner = new java.util.Scanner(System.in);
    int option = -1;

    System.out.println("Enter the type of geometric form:");
    System.out.println("1. Circle");
    System.out.println("2. Rectangle");
    System.out.println("3. Square");
    System.out.println("4. Pentagon");
    System.out.println("5. Hexagon");

    while (option != 0) {
      System.out.print("Choose an option: ");
      option = scanner.nextInt();

      String answer = switch (option) {
        case 1 -> getRectangleArea(scanner);
        case 2 -> getCircleArea(scanner);
        case 3 -> getSquareArea(scanner);
        case 4 -> getPentagonArea(scanner);
        case 5 -> getHexagonArea(scanner);
        case 0 -> closeApp(scanner);
        default -> "Invalid option. Please try again.";
      };

      System.out.println(answer);
    }
  }

  private static String getRectangleArea(Scanner scanner) {
    System.out.print("Enter radius of the circle: ");
    double radius = scanner.nextDouble();
    return new Circle(radius).toString();
  }

  private static String getCircleArea(Scanner scanner) {
    System.out.print("Enter length of the rectangle: ");
    double length = scanner.nextDouble();
    System.out.print("Enter width of the rectangle: ");
    double width = scanner.nextDouble();
    return new Rectangle(length, width).toString();
  }

  private static String getSquareArea(Scanner scanner) {
    System.out.print("Enter side of the square: ");
    double side = scanner.nextDouble();
    return new Square(side).toString();
  }

  private static String getPentagonArea(Scanner scanner) {
    System.out.print("Enter side of the pentagon: ");
    double side = scanner.nextDouble();
    return new Pentagon(side).toString();
  }

  private static String getHexagonArea(Scanner scanner) {
    System.out.print("Enter side of the hexagon: ");
    double side = scanner.nextDouble();
    return new Hexagon(side).toString();
  }

  private static String closeApp(Scanner scanner) {
    scanner.close();
    return "Exiting...";
  }
}

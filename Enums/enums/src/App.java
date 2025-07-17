
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        var option = -1;
         while (option != 5) {
          System.out.println("Escolha uma opção");
          System.out.println("1. Soma");
          System.out.println("2. Subtração");
          System.out.println("3. Multiplicação");
          System.out.println("4. Divisão");
          System.out.println("5. Sair");
          option = scanner.nextInt();

          if (option > 5 || option < 1) {
              System.out.println("Selecione uma opção válida.");
          }

          if (option == 5) break;

          var selectedOption = OperationEnum.values()[option -1];

          System.out.print("Informe o primeiro valor: ");
          var value1 = scanner.nextInt();
          System.out.print("Informe o segundo valor: ");
          var value2 = scanner.nextInt();

          var result = selectedOption.getCalculate().apply(value1, value2);

          System.out.printf("%s %s %s = %s%n", value1, selectedOption.getSymbol(), value2, result);
            
        }

    }
}

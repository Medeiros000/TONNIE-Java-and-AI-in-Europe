import br.com.dio.dao.UserDAO;
import br.com.dio.model.MenuOption;
import br.com.dio.model.UserModel;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private final static UserDAO dao = new UserDAO();

    private static final Scanner scanner = new Scanner(System.in);

    private static final String linha = "=".repeat(25);

    public static void main(String[] args) {

        while (true){
            System.out.println("Bem vindo ao cadastro de usuários, selecione a operação desejada.");
            System.out.println("1. Cadastrar: ");
            System.out.println("2. Atualizar: ");
            System.out.println("3. Excluir: ");
            System.out.println("4. Buscar o identificador: ");
            System.out.println("5. Listar: ");
            System.out.println("6. Sair: ");
            var userInput = scanner.nextInt();

            var selectedOption = MenuOption.values()[userInput - 1];
            switch (selectedOption){
                case SAVE -> {
                    var user = requestUserInfo();
                    dao.save(user);
                    System.out.printf("Usuário cadastrado %s%n", user);
                }
                case UPDATE -> {
                    var user = requestToUpdate();
                    dao.update(user);
                    System.out.printf("Usuário atualizado %s%n", user);
                }
                case DELETE -> {
                    dao.delete(requestDelete());
                    System.out.println(" Usuário excluído");
                }
                case FIND_BY_ID -> {
                    var user = dao.findById(requestId());
                    System.out.printf("Usuário com id %s%n", user.getId());
                    System.out.println(user);
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários cadastrados");
                    System.out.println(linha);
                    users.forEach(System.out::println);
                    System.out.println(linha);
                }
                case EXIT -> System.exit(0);
            }
        }

    }

    private static long requestId() {
        System.out.println("Digite o Id do usuário: ");
        return scanner.nextLong();
    }

    private static long requestDelete() {
        System.out.println("Digite o Id do usuário: ");
        return scanner.nextLong();
    }

    private static UserModel requestUserInfo() {
        System.out.print("Digite o nome: ");
        var name = scanner.next();
        System.out.print("Digite o e-mail: ");
        var email = scanner.next();
        System.out.print("Digite a data de nascimento do usuário (dd/mm/aaaa): ");
        var birthdayString = scanner.next();
        var birthday = OffsetDateTime.parse(birthdayString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var formattedBirthday = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new UserModel(0L, name, email, birthday);
    }

    private static UserModel requestToUpdate() {
        System.out.println("Digite o Id do usuário: ");
        var id = scanner.nextLong();
        System.out.println("Digite o nome: ");
        var name = scanner.nextLine();
        System.out.println("Digite o e-mail: ");
        var email = scanner.next();
        System.out.println("Digite a data de nascimento do usuário (dd/mm/aaaa): ");
        var birthdayString = scanner.next();
        var birthday = OffsetDateTime.parse(birthdayString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var formattedBirthday = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new UserModel(id, name, email, birthday);
    }

}
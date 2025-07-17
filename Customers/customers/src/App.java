
import domain.Contact;
import static domain.ContactType.EMAIL;
import static domain.ContactType.PHONE;
import static domain.SexEnum.FEMALE;
import static domain.SexEnum.MALE;
import domain.User;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
    List<User> users = new ArrayList<>(generateUsers());

//    users.sort(Comparator.comparing(User::name, Comparator.reverseOrder()));

    var values = users.stream()
            .filter(u -> u.sex() == FEMALE)
            .collect(Collectors.toMap(User::name, u -> u));
    values.forEach((key, value) -> System.out.printf("key: %s | value: %s\n", key, value));

    // Ordenando por descrição dos contatos
//    var values = users.stream()
//            .flatMap(u -> u.contacts().stream())
//            .filter(c -> c.type() == PHONE)
//            .map(c -> c.description().replace("(", "").replace(")", "").replace("-", ""))
//            .mapToLong(Long::parseLong);
//    values.forEach(System.out::println);

    // Ordenando por descrição dos contatos
//    var values = users.stream()
//            .flatMap(u -> u.contacts().stream())
//            .sorted(Comparator.comparing(Contact::description))
//            .map(c -> "{%n'description': '%s', 'type': '%s'%n}".formatted(c.description(), c.type()))
//            .toList();
//    values.forEach(System.out::println);

    // Retorna usuários que só tenham contato por e-mail
//    var values = users.stream()
//            .filter(u -> u.contacts().stream().allMatch(c -> c.type() == EMAIL))
//            .toList();
//    values.forEach(System.out::println);

    // Retorna usuários que não tenham nenhum contato
//    var values = users.stream().filter(u -> u.contacts() == null || u.contacts().isEmpty());
//    values.forEach(System.out::println);

    // Retorna usuários que tem pelo menos dois contatos
//    var values = users.stream().filter(u -> u.contacts().size() >= 2).toList();
//    values.forEach(System.out::println);


  }

  private static List<User> generateUsers() {
    var contacts1 = List.of(
        new Contact("(19)90665-8104", PHONE),
        new Contact("joao@gmail.com", EMAIL));
    var contacts2 = List.of(
        new Contact("(21)92121-0032", PHONE));
    var contacts3 = List.of(
        new Contact("lucas@outlook.com", EMAIL));
    var contacts4 = List.of(
        new Contact("andreia@outlook.com", EMAIL),
        new Contact("andreia@gmail.com", EMAIL));
    var contacts5 = List.of(
        new Contact("(31)97785-4456", PHONE),
        new Contact("(31)92115-0011", PHONE));
    var user1 = new User("João", 26, MALE, new ArrayList<>(contacts1));
    var user2 = new User("Maria", 28, FEMALE, new ArrayList<>(contacts2));
    var user3 = new User("Lucas", 19, MALE, new ArrayList<>(contacts3));
    var user4 = new User("Andreia", 40, FEMALE, new ArrayList<>(contacts4));
    var user5 = new User("Vitor", 30, MALE, new ArrayList<>(contacts5));
    var user6 = new User("Bruna", 36, FEMALE, new ArrayList<>());
    return List.of(user1, user2, user3, user4, user5, user6);
  }
}

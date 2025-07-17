
import domain.User;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

public class App {
  public static void main(String[] args) throws Exception {
    var init = OffsetDateTime.now();

    Map<String, User> users = new HashMap<>();
    users.put("joao@joao.com", new User("João", 22));
    users.put("maria@maria.com", new User("Maria", 32));
    users.put("juca@juca.com", new User("Juca", 18));
    users.put("leo@leo.com", new User("Leo", 40));
    System.out.println(users);
    System.out.println("===================================");
    users.keySet().forEach(System.out::println);
    System.out.println("===================================");
    users.values().forEach(System.out::println);
    System.out.println("===================================");
    System.out.println(users.containsKey("marcos@marcos.com"));
    System.out.println(users.containsValue(new User("Leo", 40)));

    users.forEach((k, v) -> System.out.printf("key: %s | value: %s \n", k, v));
    System.out.println("===================================");
    users.replace("joao@joao.com", new User("João", 60));
    users.forEach((k, v) -> System.out.printf("key: %s | value: %s \n", k, v));
    System.out.println("===================================");
    users.merge("leo@leo.com", new User("Tomas", 38), (user, user2) -> {
      System.out.println(user);
      System.out.println(user2);
      return user2;
    });
    System.out.println("===================================");
    System.out.println(users.size());

    // List<String> argsList = List.of(args);
    // // clonar array
    // String[] argsArray = { "um", "dois", "três" };
    // List<String> lista = new ArrayList<>();
    // Arrays.stream(argsArray).forEach(s -> lista.add(s));
    // lista.forEach(System.out::println);
    // for (String arg : argsArray) {
    // System.out.println("Array Argument: " + arg);
    // }

    // Adicionar itens da Array na lista
    // List<String> argsList = Arrays.stream(argsArray).toList();
    // System.out.println(args.getClass().getSimpleName());
    // List<String> argsArraytoList = new ArrayList<>();
    // for (String arg : argsArray) {
    // argsArraytoList.add(arg);
    // }
    // argsArraytoList.remove(0);
    // argsArraytoList.forEach(System.out::println);

    var end = OffsetDateTime.now();
    var timeLapsed = Duration.between(init, end).toMillis();
    System.out.printf("Tempo em milisegundos da operação: %s%n", timeLapsed);
  }
}

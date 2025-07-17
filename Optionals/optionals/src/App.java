
import domain.SexEnum;
import domain.User;
import domain.UserV2;
import java.util.Optional;

public class App {
  public static void main(String[] args) {
    // User user = null;
    // Optional<User> optional = Optional.empty();

    Optional<User> optional = Optional.of(new User("João", 18, SexEnum.MALE));
    var newUser = optional.map(user -> new UserV2(user.name(), user.age(), user.sex())).orElseThrow();
    System.out.println(newUser);

    // Optional<User> optional = Optional.ofNullable(null);

    // optional.ifPresentOrElse(
    // user -> System.out.printf("Usuário: %s%n", user),
    // () -> System.out.println("Não foi informado um usuário."));

    // System.out.println(optional.orElse(defaulUser()));
    // System.out.println(optional.orElse(new User("Maria", 22, FEMALE)));
    // System.out.println(optional.orElseThrow(() -> new
    // InvalidObjectException("Objeto inválido")));
    // System.out.println(optional.isEmpty());
  }

  // public static User defaulUser(){
  // return new User("Maria", 22, FEMALE);
  // }
}

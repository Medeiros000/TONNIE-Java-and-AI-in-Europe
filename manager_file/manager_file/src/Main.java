import br.com.dio.persistence.FielPersistence;
import br.com.dio.persistence.IOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var line = "=".repeat(30);

        FielPersistence persistence = new IOFilePersistence("user.csv");
//        System.out.println(persistence.write("Jr;junior@manager.com;09/11/1981"));
//        System.out.println(persistence.write("Cecilia;cecilia@manager.com;21/04/2000"));
//        System.out.println(persistence.write("Beatriz;bia@manager.com;01/02/2006"));
        persistence.write("Jr;junior@manager.com;09/11/1981");
        persistence.write("Cecilia;cecilia@manager.com;21/04/2000");
        persistence.write("Beatriz;bia@manager.com;01/02/2006");

//        System.out.println(line);
//        var found1 = persistence.findBy("junior");
//        System.out.println(found1);
//        System.out.println(line);
//        var found2 = persistence.findBy("2000");
//        System.out.println(found2);
        System.out.println(line);
        var allUsersBefore = persistence.findAll();
        System.out.println(allUsersBefore);
        System.out.println(line);
        var found2 = persistence.removeContent("Cecilia");
        System.out.println(found2);
        System.out.println(line);
        var found3 = persistence.replace("Beatriz", "Blabla;blabla@manager.com;01/01/2025");
        System.out.println(found3);
        System.out.println(line);
        var allUsersAfter = persistence.findAll();
        System.out.println(allUsersAfter);
        System.out.println(line);

    }
}

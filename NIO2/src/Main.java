
import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.IOFilePersistence;
import br.com.dio.persistence.NIO2FilePersistence;
import br.com.dio.persistence.NIOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var line = "=".repeat(40);
        FilePersistence persistence = new IOFilePersistence("user.csv");
        var className = persistence.getClass().getSimpleName().toLowerCase();

        System.out.println(line);
        System.out.println(persistence.write(String.format("Bianca;bia@%s.com;22/09/1997", className)));
        System.out.println(line);
        System.out.println(persistence.write(String.format("Bernardo;bernardo@%s.com;28/11/1999", className)));
        System.out.println(line);
        System.out.println(persistence.write(String.format("Ricardo;ricardo@%s.com;12/01/2000", className)));
        System.out.println(line);
        System.out.println(persistence.write(String.format("Fernanda;fernanda@%s.com;02/10/1993", className)));
        System.out.println(line);
        System.out.println(persistence.findAll());
        System.out.println(line);
        System.out.println(persistence.findBy("Bernardo"));
        System.out.println(line);
        System.out.println(persistence.findBy("Luiz"));
        System.out.println(line);
        System.out.println(persistence.removeContent("Bernardo"));
        System.out.println(line);
        System.out.println(persistence.removeContent("Luiz"));
        System.out.println(line);
        System.out.println(persistence.replace("Ricardo", String.format("Marone;marone@%s.com;12/12/2012", className)));
        System.out.println(line);
        System.out.println(persistence.replace("Jose", String.format("Marone;marone@%s.com;12/12/2012", className)));
        System.out.println(line);
        System.out.println(persistence.findAll());
        System.out.println(line);
    }
}


import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.NIOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var line = "=".repeat(40);
        FilePersistence persistence = new NIOFilePersistence("user.csv");

//        System.out.println(persistence.write("Bianca;bia@nio.com;22/09/1997;"));
//        System.out.println(persistence.write(line));
//        System.out.println(persistence.write("Bernardo;bernardo@nio.com;28/11/1999;"));
//        System.out.println(persistence.write(line));
//        System.out.println(persistence.write("Ricardo;ricardo@nio.com;12/01/2000;"));
//        var teste = "Bianca;bia@nio.com;22/09/1997\n\r";
//        System.out.println(teste.substring(0, teste.length() -2));
        System.out.println(line);
        persistence.write("Bianca;bia@nio.com;22/09/1997");
        persistence.write("Bernardo;bernardo@nio.com;28/11/1999");
        persistence.write("Fernanda;fernanda@nio.com;02/10/1993");
        persistence.write("Ricardo;ricardo@nio.com;12/01/2000");
        System.out.println(line);
        System.out.println(persistence.findAll());
        System.out.println(line);
        System.out.println(persistence.removeContent("Bernardo"));
        System.out.println(line);
        System.out.println(persistence.findBy("Bernardo"));
        System.out.println(line);
        System.out.println(persistence.replace("Ricardo", "Lucas;lucas@nio.com;17/12/1988"));
        System.out.println(line);
    }
}

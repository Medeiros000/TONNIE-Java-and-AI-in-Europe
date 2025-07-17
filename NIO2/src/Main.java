
import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.NIO2FilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var line = "=".repeat(40);
        FilePersistence persistence = new NIO2FilePersistence("user.csv");

        System.out.println(line);
        System.out.println(persistence.write("Bianca;bia@nio2.com;22/09/1997"));
        System.out.println(line);
        System.out.println(persistence.write("Bernardo;bernardo@nio2.com;28/11/1999"));
        System.out.println(line);
        System.out.println(persistence.write("Ricardo;ricardo@nio2.com;12/01/2000"));
        System.out.println(line);
        System.out.println(persistence.write("Fernanda;fernanda@nio2.com;02/10/1993"));
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
        System.out.println(persistence.replace("Ricardo", "Marone;marone@nio2.com;12/12/2012"));
        System.out.println(line);
        System.out.println(persistence.replace("Jose", "Marone;marone@nio2.com;12/12/2012"));
        System.out.println(line);
        System.out.println(persistence.findAll());
        System.out.println(line);
//        var teste = "Bianca;bia@nio.com;22/09/1997\n\r";
//        System.out.println(teste.substring(0, teste.length() -2));
//        persistence.write("Bianca;bia@nio.com;22/09/1997");
//        persistence.write("Bernardo;bernardo@nio.com;28/11/1999");
//        persistence.write("Fernanda;fernanda@nio.com;02/10/1993");
//        persistence.write("Ricardo;ricardo@nio.com;12/01/2000");
//        System.out.println(line);
//        System.out.println(line);
//        System.out.println(persistence.removeContent("Bernardo"));
//        System.out.println(line);
//        System.out.println(line);
//        System.out.println(persistence.replace("Ricardo", "Lucas;lucas@nio.com;17/12/1988"));
//        System.out.println(line);
    }
}

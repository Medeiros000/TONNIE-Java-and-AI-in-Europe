import dao.ClientDAO;
import dao.GenericDAO;
import dao.UserDAO;
import domain.ClientDomain;
import domain.UserDomain;

public class Main {

  private static final GenericDAO<Integer, UserDomain> userDao = new UserDAO();

  private static final GenericDAO<String, ClientDomain> clientDao = new ClientDAO();

  public static void main(String[] args) {

    var user = new UserDomain(1, "João", 36);
    String linha = "=".repeat(10);
    System.out.println(linha + "UserDAO" + linha);
    System.out.println(userDao.count());
    System.out.println(userDao.save(user));
//    System.out.println(userDao.save(new UserDomain("Maria", 36)));
    System.out.println(userDao.find(d -> d.getId().equals(0)));
    System.out.println(userDao.findAll());
    System.out.println(userDao.count());
    System.out.println(userDao.delete(new UserDomain(2, "", -1)));
    System.out.println(userDao.delete(user));
    System.out.println(userDao.count());
    System.out.println(linha + "UserDAO (final)" + linha);

    System.out.println(linha + "ClienteDAO" + linha);
    var client = new ClientDomain("A", "João", 36);

    System.out.println(clientDao.count());
    System.out.println(clientDao.save(client));
//    System.out.println(clientDao.save(new UserDomain("Maria", 36)));
    System.out.println(clientDao.find(d -> d.getId().equals("A")));
    System.out.println(clientDao.findAll());
    System.out.println(clientDao.count());
    System.out.println(clientDao.delete(new ClientDomain("A", "", -1)));
    System.out.println(clientDao.delete(client));
    System.out.println(clientDao.count());
    System.out.println(linha + "ClienteDAO (final)" + linha);
  }
}

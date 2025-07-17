import domain.Employee;
import domain.Manager;
import domain.Salesman;

public class Main {
  public static void main(String[] args) throws Exception {
    printEmployee(new Manager());
    printEmployee(new Salesman());

  }

  public static void printEmployee(Employee employee) {
    System.out.printf("=======%s=======\n", employee.getClass().getSimpleName());
    switch (employee) {
      case Manager manager -> {
        employee.setCode("123");
        employee.setName("João");
        employee.setSalary(5000);
        manager.setLogin("joao");
        manager.setPassword("123456");
        manager.setCommission(1200);

        System.out.println(employee.getCode());
        System.out.println(employee.getSalary());
        System.out.println(employee.getName());
        System.out.println(manager.getLogin());
        System.out.println(manager.getPassword());
        System.out.println(manager.getCommission());
      }
      case Salesman salesMan -> {
        salesMan.setName("Lucas");
        salesMan.setCode("456");
        salesMan.setName("lucas");
        salesMan.setSalary(1800);
        salesMan.setPercentPerSold(10);
        salesMan.setSoldAmount(1000);

        System.out.println(salesMan.getCode());
        System.out.println(salesMan.getSalary());
        System.out.println(salesMan.getName());
      }
    }
    System.out.println(employee.getFullSalary());
    System.out.println("======================");
  }
}

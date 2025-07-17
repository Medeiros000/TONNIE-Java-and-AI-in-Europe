import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var calendar = Calendar.getInstance();
        var dayOfWeek = List.of("domingo", "segunda", "terça", "quarta", "quinta", "sexta", "sábado");
        System.out.println(dayOfWeek.get(calendar.get(Calendar.DAY_OF_WEEK) - 1));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss Z");
        System.out.println("DateFormat: " + dateFormat.format(calendar.getTime()));
//        var date = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.printf("Date: %s%n", date);
//        System.out.println("DateFormat: " + dateFormat.format(date));
//
//        var dateSystem = new Date((System.currentTimeMillis()));
//        System.out.printf("DateSystem: %s%n", dateSystem);
    }
}
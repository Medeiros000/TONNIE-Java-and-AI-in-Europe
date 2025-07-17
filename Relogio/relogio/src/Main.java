public class Main {
  public static void main(String[] args) throws Exception {
    Clock brlClock = new BRLClock();
    brlClock.setMinute(0);
    brlClock.setSecond(0);
    brlClock.setHour(13);

    System.out.println(brlClock.getTime());
    System.out.println(new USClock().convert(brlClock).getTime());
  }
}

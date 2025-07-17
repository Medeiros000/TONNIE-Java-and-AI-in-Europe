public class MusicBox implements MusicPlayer {
  @Override
  public void playMusic() {
    System.out.println("Musicbox playing music.");
  }

  @Override
  public void pauseMusic() {
    System.out.println("Musicbox paused music.");
  }

  @Override
  public void stopMusic() {
    System.out.println("Musicbox stopped music.");
  }
}

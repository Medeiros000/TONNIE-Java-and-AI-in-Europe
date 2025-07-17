public class Main {
  public static void main(String[] args) throws Exception {
    var musicPlayer = new Computer();

    runMusic(musicPlayer);
    runVideo(musicPlayer);

    System.out.println(musicPlayer.getClass().getSimpleName());
  }

  public static void runVideo(VideoPlayer videoPlayer) {
    videoPlayer.playVideo();
  }

  public static void runMusic(MusicPlayer musicPlayer) {
    musicPlayer.playMusic();
  }
}

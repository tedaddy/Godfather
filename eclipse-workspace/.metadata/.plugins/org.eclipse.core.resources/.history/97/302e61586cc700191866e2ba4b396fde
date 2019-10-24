import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class AudioDriver extends Thread {
	Player playMP3;
	public void run() {
        try {
        	FileInputStream fis = new FileInputStream("src/audio/Eminem – Venom.mp3");
        	playMP3 = new Player(fis);

        	playMP3.play();
        } catch(Exception e) {System.out.println(e);}
	}
	
	
}
import java.io.FileInputStream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import com.mpatric.mp3agic.*;
import javazoom.jl.player.Player;

public class AudioDriver implements Runnable{
	Player playMP3;
	String src;
	
	public AudioDriver(String src) {
		this.src = src;
	}
	
	public void run() {
        try {
        	FileInputStream fis = new FileInputStream(src);
        	playMP3 = new Player(fis);

        	playMP3.play();
        } catch(Exception e) {System.out.println(e);}
	}
	
	public int[] getTimeMarks() {
		int [] time_marks;
		
        try {
        	FileInputStream file = new FileInputStream(src);
        	Mp3File mp3file = new Mp3File(src);
        	byte[] bytes = inputStreamToByteArray(file);
        	int headSize = mp3file.getId3v2Tag().getLength();
        	int duration = (int)mp3file.getLengthInSeconds();
        	byte[] new_bytes = Arrays.copyOfRange(bytes, headSize, bytes.length);
        	int bytes_on_sec = new_bytes.length/duration;
        	int[] map = new int[duration];
        	int prev_sum = 0;
        	int sum = 0;
        	for( int j = 0; j < duration; j++ ) {
            	for( int i = j*bytes_on_sec; i<(j+1)*bytes_on_sec; i++ ) {
            		if(new_bytes[i]<0) {
            			sum+=-new_bytes[i];
            		}else {
            			sum+=new_bytes[i];
            		}
            	}
            	if(((sum*2)/bytes_on_sec)<=10) {
            		map[j]=0;
            	}
            	else if(((sum*2)/bytes_on_sec)>=90) {
            		map[j]=1;
            	}
            	else if( ((prev_sum*2)/bytes_on_sec)-((sum*2)/bytes_on_sec)>=20 ) {
            		map[j]=0;
            	}else {
            		map[j]=1;
            	}
            	prev_sum = sum;
            	sum = 0;
        	}    
        	String map_str = Arrays.toString(map);
        	map_str = map_str.replaceAll(",", "");
        	map_str = map_str.replaceAll(" ", "");
        	map_str = map_str.replaceAll("[\\[\\]]", "");
        	time_marks = new int[6];
        	int prev_mark = 0;
        	int mark;
        	int count=0;
        	String event = "00000000000000000000000000000000000";
        	for( int i = 0; i < duration; i++ ) {
            	if(	(i+event.length()) <= duration ) {
            		String cur_set = map_str.substring(i, i+event.length());
                	if( cur_set.equals(event) ) {
                		mark = i;
                		if( (mark - prev_mark)>=35 ) {
                    		time_marks[count] = mark;
                    		count+=1;
                		}
                		prev_mark = mark;
                	}           				
            	}
        	}
        } catch(Exception e) {
        	return null;
        }
        return time_marks;
	}
	
	static public byte[] inputStreamToByteArray(InputStream inStream) throws IOException {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    byte[] buffer = new byte[8192];
	    int bytesRead;
	    while ((bytesRead = inStream.read(buffer)) > 0) {
	        baos.write(buffer, 0, bytesRead);
	    }
	    return baos.toByteArray();
	}
	
	
}
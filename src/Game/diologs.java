package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import utils.Sound;

public class diologs {
	
	static String Nowtext = "";
	static ArrayList<String> textBuffer = new ArrayList<>();
	static ArrayList<Integer> soundB = new ArrayList<>();
	static ArrayList<Sound> soundBuffer = new ArrayList<>();
	static int idx;
	private static int time;
	private static int fixtime;
	private static float c;
	private static String tmptext;
	private int countofreplics = 1;
	
	private void loading() {
		File f;
		for (int i = 0; i < countofreplics ; i++) {
			f = new File("Voice/1 (" + String.valueOf(i) + ").wav");
			soundBuffer.add(new Sound(f));
			
		}
		
	}
	
	public static void clearBuff() {
		
		textBuffer.clear();
		
	}
	
	public static void add(String text) {
		
		textBuffer.add(text);
		soundB.add(1);
	}
	
	public static void start() {
		
		idx = 0;
		/*for (int i = 0; i < textBuffer.size(); i++) {
			
			soundBuffer.add(Sound.playSound(textBuffer.get(i)));
			
		}*/
		time = 0;
		fixtime = 0;
		c = 0;
		
	}
	
	public static void update() {
		
		
		if(time == fixtime) {
			Game.player.controls = false;
			if (idx < textBuffer.size()) {
			tmptext = textBuffer.get(idx);
			//soundBuffer.get(soundB.get(idx)).play();
			idx++;
			time = 0;
			fixtime = 200;
			c = 0;
			}else {
				Game.player.controls = true;
				Nowtext = "";
				
			}
		}
		if(tmptext != null && c > 0 && c < tmptext.length()+1)
		Nowtext = tmptext.substring(0, (int) c);
		c += 0.5f;
				System.out.println(c);
		time ++;
		
		
		
	}
	
}

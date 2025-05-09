package Game;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import utils.Sound;

public class diologs {
	
	static String Nowtext = "";
	static ArrayList<String> textBuffer = new ArrayList<>();
	static ArrayList<Sound> soundBuffer = new ArrayList<>();
	static int idx;
	private static int time;
	private static int fixtime;
	
	public static void clearBuff() {
		
		textBuffer.clear();
		
	}
	
	public static void add(String text) {
		
		textBuffer.add(text);
		
	}
	
	public static void start() {
		
		idx = 0;
		/*for (int i = 0; i < textBuffer.size(); i++) {
			
			soundBuffer.add(Sound.playSound(textBuffer.get(i)));
			
		}*/
		time = 0;
		fixtime = 0;
		
	}
	
	public static void update() {
		
	
		if(time == fixtime) {
			if (idx < textBuffer.size()) {
			Nowtext = textBuffer.get(idx);
			idx++;
			time = 0;
			fixtime = 100;
			}else {
				Nowtext = "";
			}
		}
		
		time ++;
		
		
		
	}
	
}

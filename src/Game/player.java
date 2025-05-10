package Game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import Display.Display;
import utils.ResourceLoader;
import utils.Sound;
import utils.util;

public class player {
	
	static int px;
	static int py;
	static int ph = 16;
	static int pw = 16;
	
	static int dir = 0;
	static int animation;
	
	float jumpForce = 5;
	float playerSpeed = 1.5f;
	int pidx;
	boolean controls;
	static int Deaths;
	static int lvlDeaths;
	
	
	
	static float frame;
	
	static float sx;
	static float sy;
	
	Sound Death;
	Sound Restart;
	Sound jump;
	private int respawn;
	
	
	static BufferedImage player;
	
	public player() {
		
		player = ResourceLoader.loadimage("PlayerSpriteSheet.png");
		frame = 0;
		Deaths = 0;
		
	}
	
	static BufferedImage tmp;
	
	public static BufferedImage draw() {
		tmp = new BufferedImage(16,16,BufferedImage.TYPE_3BYTE_BGR);
		if(animation == 0)
		tmp = player.getSubimage((64*dir)+((int)frame%2)*16, 0, 16, 16);
		if(animation == 1)
			tmp = player.getSubimage(((64*dir)+32)+(((int)frame%2)*16), 0, 16, 16);
		if(animation == 2)
			tmp = player.getSubimage(((64*dir))+32+(((int)frame%2)*16), 16, 16, 16);
		if(animation == 3)
			tmp = player.getSubimage(((64*dir))+(((int)frame%4)*16), 32, 16, 16);
		/*if(animation == 4)
			tmp = player.getSubimage(((64*dir))+32+(((int)frame%2)*16), 16, 16, 16);*/
		frame += 0.1f;
		return tmp;
	}
	
	void playerUP() {
		pidx = ((px+8)/16)+(py/16)*Game.Gmax;
		respawn--;
		Game.playervis = respawn < 0;
		if (!controls) { animation = 0; return;}
		int h = 0;
		int v = 0; 
		
			h = (util.BiI(Game.input.getKey(KeyEvent.VK_RIGHT))-util.BiI(Game.input.getKey(KeyEvent.VK_LEFT)));
			v = (util.BiI(Game.input.getKey(KeyEvent.VK_UP)));
		
		sx += h*playerSpeed;
		
		
		if (h != 0) {
			animation = -1;
			dir = (h == 1) ? 0 : 1;
		}	
		h = (h == 1) ? 1 : 0;
		
		if(sy > 0.3) {
			animation = 2;
		}
		if(sy < 0) {
			animation = 3;
		}
		
		
		if(py+sy+ph > Game.Height) {
			
			Death();
			return;
		}
		
		if(Game.Current((int) ((px+sx+(pw*h))/16), (int) ((py+ph-0.1f)/16))) {
			
			sx = 0;
			
		} 
		px += Math.round(sx);
		if(Game.Current((px+8)/16, (int) (py+sy+ph)/16)) {
			
			if ((animation == -1)) {
				animation = 1;
			}else {
				animation = 0;
			}
			
			py = (((int) (py+sy)/16))*16;
			sy = 0;
			if(v > 0) {jump.play();}
			sy = v*-jumpForce;
			py += sy;
		}
		
		py += sy;
		sx = sx*0.8f;
		sy += Game.g;
		
		
	}
	
	void Death() {
		Game.playervis = false;
		Death.play();
		px = Game.level[880].x;
		py = Game.level[880].y;
		Deaths++;
		lvlDeaths++;
		sx = 0;
		sy = 0;
		
		respawn = 50;
		
		Restart.play();
	}

	public void loading() {
		File f = new File("resource/Sounds/sfx_death.wav");
		Death = new Sound(f);
		Display.swapBuffers();
		f = new File("resource/Sounds/sfx_restart.wav");
		Restart = new Sound(f);
		Display.swapBuffers();
		f = new File("resource/Sounds/sfx_jump.wav");
		jump = new Sound(f);
		Display.swapBuffers();
		
	}	
	
	
}

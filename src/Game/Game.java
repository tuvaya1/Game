package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Display.Display;
import utils.*;




public class Game implements Runnable{
	
	public static final int     Width          = 640;
	public static final int     Height         = 352;
	public static final String  Title          = "";
	public static final int     _clearColor    = 0xFF000000;
	public static final int      numBuffers    = 3;
	
	public static final float   updateRate     = 60.0f;
	public static final float   updateInterval = Time.SECOND / updateRate;
	public static final long    idleTime       = 1;
	
	public static final String  atlasFileName  = "Textures32.png";
	
	private boolean             running;
	private Thread              gameThread;
	private Graphics2D 			graphics;
	static Input               input;
	
	
	
	// Game constants
		static float g = 0.2f;
		
		
		
	// Game
		static int Gmax = 40;
		static int Gmay = 22;
		static player player;
		static block[] level;
		static int idx;
		
	// Resource
		BufferedImage BackGround;
		
		BufferedImage[] tilemap = new BufferedImage[38];
	//
		private float time;
	
	public Game() {
		player = new player();
		running = false;
		Display.create(Width, Height, Title, _clearColor, numBuffers);
		graphics = Display.getGraphics();
		input = new Input();
		Display.addInputListener(input);
		BackGround = ResourceLoader.loadimage("102079.jpg");
		
		for (int i = 0; i < 38; i++) {
			String tmp = "tileset/1 (" + (String.valueOf(i)) +").png";
			System.out.println(tmp);
		tilemap[i] = ResourceLoader.loadimage(tmp);
		}
		
		level = maps.map1;
		/*for (int i = 0; i < 38; i++) {
			
			int x = i%Gmax;
			int y = i/Gmax;
			level[i] = new block(x*16,y*16,false,i,null);
			
		}*/
		player.px = level[880].x;
		player.py = level[880].y;
	}
	
	public synchronized void start() {
		
		if (running)
			return;
		
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	public synchronized void stop() {
		
		if (!running)
			return;
	    
		running = false;
		
		try {
			gameThread.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cleanUp();
		
	}
	
	private void update() {
		
		for(idx = 0; idx < Gmax*Gmay;idx++) {
			if (level[idx].action != null) {
			level[idx].action.run();
			}
		}
		
		player.playerUP();
		
		
	}
	
	
	
	public static boolean Current(int px, int py) {
		
		return level[(py*Gmax)+px].collision;
		
	}
	
	
	
	private void render() {
		Display.clear();
		int sx = 10;
		float st = 0.5f;
		graphics.setColor(new Color(0x1B0A1C));
		for (int i = 0; i < Width; i += Width/sx) {
			graphics.drawLine(0, (int)(i+(time*st)%(Width/sx)+50), Width, (int)(i+(time*st)%(Width/sx)+50));
			graphics.drawLine((int)(i+(time*st)%(Width/sx))+60, 0, (int)(i+(time*st)%(Width/sx))+60, Height);
		}
		
		graphics.setColor(new Color(0x362134));
		for (int i = 0; i < Width; i += Width/sx) {
			graphics.drawLine(0, (int)(i+time%(Width/sx)), Width, (int)(i+time%(Width/sx)));
			graphics.drawLine((int)(i+time%(Width/sx)), 0, (int)(i+time%(Width/sx)), Height);
		}
		
		/*double sx = (double)Width / BackGround.getWidth();
		double sy = (double)Height / BackGround.getHeight();
		graphics.scale(sx, sy);
		graphics.drawImage(BackGround,0,0,null);
		graphics.scale(1/sx, 1/sy);*/
		
		
		
		
		
		for(int i = 0; i < Gmax*Gmay; i++) {
			
			
			int x = (level[i].x == -1) ? ((i%Gmax)*16) : level[i].x;
			int y = (level[i].y == -1) ? (int)(Math.floor(i/Gmax)*16) :level[i].y;
			int texture = level[i].texture;
			
			graphics.drawImage(tilemap[texture], x, y, null);
				
				
			
		}
		graphics.drawImage(player.draw(), player.px, player.py, null);
		graphics.drawString(String.valueOf(player.px/16), 0, 10);
		graphics.drawString(String.valueOf(player.py/16), 0, 20);
		graphics.drawString(String.valueOf(player.sx), 0, 30);
		graphics.drawString(String.valueOf(player.sy), 0, 40);
		graphics.drawString(String.valueOf(player.pidx), 0, 50);
		graphics.drawString(String.valueOf(player.Deaths), 0, Height-10);
		graphics.drawString(String.valueOf(player.lvlDeaths), 0, Height);
		time += 0.5;
		Display.swapBuffers();
	}
	
	public void run() {
		
		int fps = 0;
		int upd = 0;
		int updl = 0;
		
		long count = 0;
		
		float delta = 0;
		
		long lastTime = Time.get();
		while(running) {
			long now = Time.get();
			long elapsedTime = now - lastTime;
			lastTime = now;
			
			count += elapsedTime;
			
			boolean render = false;
			delta += (elapsedTime/ updateInterval);
			while(delta>1) {
				update();
				upd++;
				delta--;
				if(render) {
					updl++;
				}else {
					render = true;	
				}
				
			}
			
			if(render) {
				render();
				fps++;
			} else {
				try {
					Thread.sleep(idleTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(count >= Time.SECOND) {
				Display.setTitle(Title + " || " + fps + " " + upd + " " + updl + " || " );
				upd = 0;
				fps = 0;
				updl = 0;
				count = 0;
			}
				
			
		}
		
	}
	
	
	
	
	private void cleanUp() {
		Display.destroy();
	}
	
	
	
	
}

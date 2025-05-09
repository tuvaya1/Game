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
	public static final int     _clearColor    = 0xFFFFFFFF;
	public static final int      numBuffers    = 3;
	
	public static final float   updateRate     = 60.0f;
	public static final float   updateInterval = Time.SECOND / updateRate;
	public static final long    idleTime       = 1;
	
	public static final String  atlasFileName  = "Textures32.png";
	
	private boolean             running;
	private Thread              gameThread;
	private Graphics2D 			graphics;
	private Input               input;
	
	
	
	// Game constants
		float g = 0.1f;
		float jumpForce = 8;
		float playerSpeed = 1.5f;
		
		
	// Game
		static int Gmax = 40;
		static int Gmay = 22;
		static block[] level;
		static int px;
		static int py;
		int ph = 32;
		int pw;
		float sx;
		float sy;
		
		static int idx;
		
	// Resource
		BufferedImage BackGround;
		BufferedImage player;
		BufferedImage[] tilemap = new BufferedImage[11];
	//
	
	public Game() {
		running = false;
		Display.create(Width, Height, Title, _clearColor, numBuffers);
		graphics = Display.getGraphics();
		input = new Input();
		Display.addInputListener(input);
		BackGround = ResourceLoader.loadimage("102079.jpg");
		player = ResourceLoader.loadimage("tmp1.png");
		for (int i = 0; i < 10; i++) {
			String tmp = "tileset/1 (" + (String.valueOf(i)) +").png";
			System.out.println(tmp);
		tilemap[i] = ResourceLoader.loadimage(tmp);
		}
		/*for (int i = 0; i < level.length; i++) {
			
			int x = i%Gmax;
			int y = i/Gmax;
			level[i] = new block(x*16,y*16,false,(int) (Math.random()*11),null);
			
		}*/
		level = maps.map1;
		px = level[880].x;
		py = level[880].y;
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
		
		for(idx = 0; idx < level.length;idx++) {
			if (level[idx].action != null) {
			//level[idx].action.run();
			}
		}
		
		playerUP();
		
		
	}
	
	private void playerUP() {
		
		sx += (util.BiI(input.getKey(KeyEvent.VK_RIGHT))-util.BiI(input.getKey(KeyEvent.VK_LEFT)))*playerSpeed;
		
		
		
		
		px += Math.round(sx);
		py += sy;
		
		if(Current(px/16, (int) (py+sy+ph)/16)) {
			
			py = (((int) (py+sy)/16))*16;
			sy = 0;
			sy = (util.BiI(input.getKey(KeyEvent.VK_UP)))*-playerSpeed;
			py += sy;
		}
		
		sx = sx*0.8f;
		sy += g;
	}
	
	public boolean Current(int px, int py) {
		
		return level[(py*Gmax)+px].collision;
		
	}
	
	
	
	private void render() {
		Display.clear();
		
		double sx = (double)Width / BackGround.getWidth();
		double sy = (double)Height / BackGround.getHeight();
		graphics.scale(sx, sy);
		graphics.drawImage(BackGround,0,0,null);
		graphics.scale(1/sx, 1/sy);
		
		
		
		
		
		for(int i = 0; i < Gmax*Gmay; i++) {
			
			
			int x = (level[i].x == -1) ? ((i%Gmax)*16) : level[i].x;
			int y = (level[i].y == -1) ? (int)(Math.floor(i/Gmax)*16) :level[i].y;
			int texture = level[i].texture;
			
			graphics.drawImage(tilemap[texture], x, y, null);
				
				
			
		}
		graphics.drawImage(player, px, py, null);
		graphics.drawString(String.valueOf(px/16), 0, 10);
		graphics.drawString(String.valueOf(py/16), 0, 20);
		graphics.drawString(String.valueOf(this.sx), 0, 30);
		graphics.drawString(String.valueOf(this.sy), 0, 40);
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

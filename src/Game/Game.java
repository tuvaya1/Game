package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Display.Display;
import utils.*;




public class Game implements Runnable{
	
	public static final int     Width          = 640;
	public static final int     Height         = 360;
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
		float g = 1;
		float jumpForce = 2;
		float playerSpeed = 1.5f;
	// Game
		int px;
		int py;
		int ph = 32;
		int pw;
		float sx;
		float sy;
		
		
		
		
	// Resource
		BufferedImage BackGround;
		BufferedImage player;
		BufferedImage[] tilemap = new BufferedImage[10];
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
			String tmp = "tileset/1 ("+(String.valueOf(i+1)) +").png";
			System.out.println(tmp);
		tilemap[i] = ResourceLoader.loadimage(tmp);
		}
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
		
		sx += (util.BiI(input.getKey(KeyEvent.VK_RIGHT))-util.BiI(input.getKey(KeyEvent.VK_LEFT)))*playerSpeed;
		sy -= (util.BiI(input.getKey(KeyEvent.VK_UP))-util.BiI(input.getKey(KeyEvent.VK_DOWN)))*playerSpeed;
		
		sy += g;
		
		px += Math.round(sx);
		py += Math.round(sy);
		
		if(py+ph > Height) {
			
			py = Height-ph;
			sy = 0;
			
		}
		
		sx = sx*0.8f;
		
		
		
	}
	
	private void render() {
		Display.clear();
		
		double sx = (double)Width / BackGround.getWidth();
		double sy = (double)Height / BackGround.getHeight();
		graphics.scale(sx, sy);
		graphics.drawImage(BackGround,0,0,null);
		graphics.scale(1/sx, 1/sy);
		
		graphics.drawImage(player, px, py, null);
		
		graphics.drawString(String.valueOf(Math.round(this.sx)), 0, 10);
		
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

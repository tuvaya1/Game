package Main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;

import Display.Display;
import Game.Game;
import utils.*;




public class Menu implements Runnable{
	
	public static final int     Width          = 640;
	public static final int     height         = 352;
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
	private Input               input;
	
	// Game constants

	// Game
	BufferedImage menuBG;
	BufferedImage menuSMOn;
	BufferedImage menuPressENTER;
	BufferedImage menuPressENTER2;
	BufferedImage menuSMOff;
	BufferedImage menuCopyr;
	BufferedImage Titles;
	BufferedImage perehod;
	private BufferedImage menuLOGO;
	private int time;
	private boolean saveMode;
	private boolean m;
	private int tmp;
	Sound music;
	Sound start;
	Sound titlee;
	Sound pic;
	private int titles;
	
	//
	
	public Menu() {
		running = false;
		Display.create(Width, height, Title, _clearColor, numBuffers, false);
		graphics = Display.getGraphics();
		input = new Input();
		Display.addInputListener(input);
		menuBG = ResourceLoader.loadimage("menubg.png");
		menuPressENTER = ResourceLoader.loadimage("menupressenter.png");
		menuPressENTER2 = ResourceLoader.loadimage("menupressenter2.png");
		menuSMOff = ResourceLoader.loadimage("safetymodedisabled.png");
		menuSMOn = ResourceLoader.loadimage("safetymodeenabled.png");
		menuCopyr = ResourceLoader.loadimage("menucopyleft.png");
		menuLOGO = ResourceLoader.loadimage("gamelogo.png");
		Titles = ResourceLoader.loadimage("menumessage.png");
		perehod = ResourceLoader.loadimage("perehod.png");
		File f = new File("resource/Music/msc_menu.wav");
		music = new Sound(f);
		f = new File("resource/Sounds/sfx_restart.wav");
		start = new Sound(f);
		f = new File("resource/Sounds/sfx_dialogue.wav");
		pic = new Sound(f);
		f = new File("resource/Sounds/sfx_title.wav");
		titlee = new Sound(f);
		titles = 0;
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
		titles++;
		if(titles == 360)
			titlee.play();
		if(titles == 555)
		music.play();
		int mx = Display.getScLoc().x;
		int my = Display.getScLoc().y;
		if (((mx > 600 && mx < 635) && (my > 310 && my < 345)) && Display.Mpress == 1) {
			
			if(m) {
				pic.play();
				if (saveMode) {
					saveMode = false;
				}else {
					saveMode = true;
				}
				
			}
			
			m = false;
		}else {
			m = true;
		}
		if (input.getKey(KeyEvent.VK_ENTER)) {
			tmp++;
			start.play();
			
		}
		if(tmp > 0) {
			tmp ++;
		}
		
		if(tmp > 200) {
			music.stop();
			Game g = new Game(saveMode);
			g.start();
			stop();
		}
		
	}
	
	private void render() {
		Display.clear();
		if(titles < 555) {
			if(titles < 255) {
				graphics.setColor(new Color(0,0,0,255-titles));
			}
			if(titles > 300) {
				graphics.setColor(new Color(255,255,255,titles-300));
			}
			graphics.drawImage(Titles, 0, 0,null);
			graphics.fillRect(0,0,Width,height);
			Display.swapBuffers();
			return;
		}
		graphics.drawImage(menuBG,time%640,0,null);
		graphics.drawImage(menuBG,time%640-640,0,null);
		graphics.drawImage(menuCopyr,(int) ((Math.cos(time*0.05)*5)),(int) ((Math.sin(time*0.05)*5)),null);
		if (tmp%20 < 10) {
			graphics.drawImage(menuPressENTER,0,(int) (Math.sin((time+100)*0.05)*(10+(BiI(tmp>0)*10))),null);
		}else {
			graphics.drawImage(menuPressENTER2,0,(int) (Math.sin((time+100)*0.05)*(10+(BiI(tmp>0)*10))),null);
		}
		if(saveMode) {
			graphics.drawImage(menuSMOn,(int) ((Math.sin(time*0.05)*4)),(int) ((Math.cos(time*0.05)*4)),null);
		}else {
			graphics.drawImage(menuSMOff,(int) ((Math.sin(time*0.05)*4)),(int) ((Math.cos(time*0.05)*4)),null);
		}
		graphics.drawImage(menuLOGO,224,(int) (70+(Math.sin(time*0.05)*10)),null);
		graphics.setColor(Color.black);
		if(tmp > 100) {
			int tmp1 = (int) (640*((tmp-100)/100f))-800;
			
			graphics.drawImage(perehod, 0, tmp1, null);
		}
		time ++;
		
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
				Display.setTitle(Title + " || " + fps + " " + upd + " " + updl + " || ");
				upd = 0;
				fps = 0;
				updl = 0;
				count = 0;
			}
				
			
		}
		
	}
	
	private float Dist(float x, float y) {
		float tmp = 0;
		tmp = (float)(Math.sqrt((x*x)+(y*y)));
		return (tmp);
	}
	
	
	private void cleanUp() {
		Display.destroy();
	}
	
	public int BiI(boolean Boolean) {
	    return (Boolean) ? 1 : 0;
	}
	
	private int range(int l,int n,int m) {
		if (n < l) {
			return(l);
		}
		if (n > m) {
			return(m);
		}
		return(n);
	}
}

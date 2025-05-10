package Display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import javax.swing.JFrame;
import utils.Input;

import Game.Game;

public abstract class Display {
	
	private static Canvas content;
	public static JFrame window;
	private static BufferedImage buffer;
	private static int[] bufferData;
	private static Graphics bufferGraphics;
	private static int clearColor;
	private static BufferStrategy bufferStrategy;
	private static boolean created;

	public static void create(int Width, int Height, String Title, int _clearColor, int numBuffers, boolean fullsc) {
		
		if(created)
			window.dispose();
		
		window = new JFrame(Title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = new Canvas();
		
		Dimension size = new Dimension(Width, Height);
		window.getContentPane().add(content);
		if (fullsc) {
				window.setUndecorated(true);
				window.pack();
				window.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}else {
				content.setPreferredSize(size);
				
				window.pack();
				window.setLocationRelativeTo(null);
			}
		window.setResizable(false);
		
		window.setVisible(true);
		
		
		
		buffer = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
		bufferData = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
		bufferGraphics = buffer.getGraphics();
		((Graphics2D)bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		clearColor = _clearColor;
		
		content.createBufferStrategy(numBuffers);
		bufferStrategy = content.getBufferStrategy();
		
		created = true;
		
		
	}
	
	public static void clear() {
		Arrays.fill(bufferData, clearColor);
	}
	

	
	public static void swapBuffers() {
		Graphics g = bufferStrategy.getDrawGraphics();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		double sx = width/640;
		double sy = height/352;
		if(!Game.t) ((Graphics2D) g).scale(sx, sy);
		g.drawImage(buffer ,0 ,0 , null);	
		if(!Game.t) ((Graphics2D) g).scale(1/sx, 1/sy);
		bufferStrategy.show();
	}
	
	public static Graphics2D getGraphics() {
		return (Graphics2D) bufferGraphics;
	}
	
	public static void destroy() {
		if (!created)
			return;
		
		window.dispose();
	}
	
	public static void setTitle(String title) {
		window.setTitle(title);
	}
	
	public static void addInputListener(Input inputListener) {
		window.add(inputListener);
	}
	
}

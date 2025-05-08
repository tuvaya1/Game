package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceLoader {

	public static final String PATH = "resource/Images/";
			
	public static BufferedImage loadimage(String fileName) {
		
		BufferedImage image = null;
		
		try {
			
			image = ImageIO.read(new File(PATH + fileName));
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
}

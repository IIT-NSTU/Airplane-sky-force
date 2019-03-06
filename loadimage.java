package gameproject;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class loadimage {
	public static BufferedImage image;
	public static BufferedImage entities;
	public static BufferedImage player,enemy;
	public static void init () {
		
		image=imageLoader("/SkyForce.JPG");
		entities=imageLoader("/Warplane.PNG");
		
		crop();
	}
	
	
	public static BufferedImage imageLoader(String path) {
		 try {
			return ImageIO.read(loadimage.class.getResource(path));
		} catch (IOException e) {
			
			e.printStackTrace();
			System.exit(1);
			
		}
		 return null;
	}
	
	public static void crop() {
		enemy=entities.getSubimage(0, 0, 90,95);
		player=entities.getSubimage(80, 0, 115,95);
	}

}

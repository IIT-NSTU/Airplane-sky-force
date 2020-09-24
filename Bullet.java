package SkyForce_MainFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Bullet {
	private int x;
	private int y;
	private static int motion;
	public Bullet(int x,int y){
		this.x=x;
		this.y=y;
		motion=4 ;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setMotion(int Bylabel) {
		motion=Bylabel;
	}
	
	public void init() {
		
	}
	public void tick() {
		y-=motion;
		
	}
	public void render(Graphics g) {		
		g.setColor(randomColor());
		g.fillRect(x, y, 6, 10);
	}
	
	private Color randomColor() {
		Random random=new Random();
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		return new Color(r, g, b);
	}

}

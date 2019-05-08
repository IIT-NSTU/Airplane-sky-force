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
		Random random=new Random();
		int R=random.nextInt(255);
		int G=random.nextInt(255);
		int B=random.nextInt(255);
		g.setColor(new Color(R,G,B));
		g.fillRect(x, y, 6, 10);
	}

}

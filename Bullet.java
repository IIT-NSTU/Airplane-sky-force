package SkyForce_MainFrame;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private int x;
	private int y;
	private  int motion;
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
	
	public void init() {
		
	}
	public void tick() {
		y-=motion;
		
	}
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, 6, 10);
	}

}

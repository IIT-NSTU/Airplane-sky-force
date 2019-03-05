package SkyForce_MainFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
	private int x;
	private int y;
	 private boolean left ,right;
	 private boolean attack;
	 private SkyForce_Frame display;
	 private gameManager manager;
	
	public Player(int x_point,int y_point) {
		this.x=x_point;
		this.y=y_point;
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void init() {
		display.frame.addKeyListener(this);
		
	}
	public void tick() {
		
	if(left) {
		if(x>50) {
		x=x-3;
	}
    }
		
	if(right) {
		if(x<Game_Maintaining.gameWidth+50-30)
		{
	
		x=x+3;
	}
	}
		if(attack) {
			
			manager.bullet.add(new Bullet(x+15,y));
		}
		
	}
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 30, 30);
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_LEFT) {
			left=true;
		}
		if(key==KeyEvent.VK_RIGHT) {
			right=true;
		}
		if(key==KeyEvent.VK_SPACE   ) {
			attack=true;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_LEFT) {
			left=false;
		}
		if(key==KeyEvent.VK_RIGHT) {
			right=false;
		}
		if(key==KeyEvent.VK_SPACE) {
			attack=false;
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
         
}

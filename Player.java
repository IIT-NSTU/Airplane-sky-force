package SkyForce_MainFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
	public int x;
	public int y;
	 private boolean left ,right;
	 private SkyForce_Frame display;
	 
	public Player(int x_point,int y_point) {
		this.x=x_point;
		this.y=y_point;
		
	}
	public void init() {
		display.frame.addKeyListener(this);
		
	}
	public void tick() {
		if(x>50) {
	if(left) {
		x=x-4;
	}
    }
		if(x<Game_Maintaining.gameWidth+50-30)
			if(right) {
				x=x+4;
			}
		
		}
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 30, 30);
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==e.VK_LEFT) {
			left=true;
		}
		if(key==e.VK_RIGHT) {
			right=true;
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
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
         
}

package SkyForce_MainFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Enemy {
	
	    private int x ;
	    private int y;
	   
	    public Enemy(int x, int y){
	       this.x = x;
	       this.y = y;
	    }
	    public int getX() {
	    	return x;
	    }
	    public int getY() {
	    	return y;
	    }
	    public void tick(){
	    y += 1;
	    }
	    public void render(Graphics g){
	    	Random random=new Random();
	    	int a=random.nextInt(255)+1;
	    	int b=random.nextInt(255)+1;
	    	int c=random.nextInt(255)+1;
	    	
	    	g.setColor(new Color(a,b,c));
	    g.fillOval(x, y, 20, 20);
	    }
	    
	    
	   
	   
	   

	}

	



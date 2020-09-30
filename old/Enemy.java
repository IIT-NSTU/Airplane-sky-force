package SkyForce_MainFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Enemy {
	   public static BufferedImage enemy=null;
	   private static gameManager manager;
	   private Game_Maintaining maintain;;
	    private int x ;
	    private int y;
	    public Enemy(int x, int y){
	       this.x = x;
	       this.y = y;
	    }
	    public void setY(int val) {
	    	this.y=val;
	    }
	    public int getX() {
	    	return x;
	    }
	    public int getY() {
	    	return y;
	    }
	    public void init() {
	    	
	    }
	    public void tick(){
	    y += 1;
	    }
	    public void render(Graphics g){
	    	
		if(y>=50 && y<=93) {
	   		enemy = ImageClass.enemy1;
	   		
	   	 }else if(y>=94 && y<=137) {
	   		enemy = ImageClass.enemy6;
	   		
	   	 }else if(y>=138 && y<=181) {
	   		enemy = ImageClass.enemy3;
	   		
	   	 }else if(y>=182 && y<=225) {
	   		enemy = ImageClass.enemy4;
	   		
	   	 }else if(y>=226 && y<=313) {
	   		enemy = ImageClass.enemy5;
	   		
	   	 }else {
	   		enemy = ImageClass.enemy2;
	   		
	   	 }
		g.drawImage(enemy,x,y,40,44,null);
	 
	    }
}

	



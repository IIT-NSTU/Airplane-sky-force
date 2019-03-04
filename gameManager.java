package SkyForce_MainFrame;

import java.awt.Graphics;

public class gameManager {
	 private Player player;
	
	public void init() {
                  player=new Player((Game_Maintaining.gameWidth/2)+40,(Game_Maintaining.gameHeight-30)+50);
		  player.init();
	}
	
       public void tick() {
                      player.tick();
	}
	
	public void render(Graphics g) {
                     player.render(g);
	}
}

package SkyForce_MainFrame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class gameManager {
   private Player player;
	public static ArrayList<Bullet>bullet;
	public static ArrayList<Enemy>enemy;
	private long current_time;
	private long late;
	
			public void init() {
				player=new Player((Game_Maintaining.gameWidth/2)+40,(Game_Maintaining.gameHeight-30)+50);
				player.init();
				bullet=new ArrayList<Bullet>();
				enemy=new ArrayList<Enemy>();
				current_time=System.nanoTime();
				late=2000;
			}
			public void tick() {
							player.tick();
							for(int i=0;i<bullet.size();i++) {
								bullet.get(i).tick();
							}
							long wait=(System.nanoTime()-current_time)/1000000;
							if(wait>late) {
                              for(int i=0;i<2;i++) {
                            	  Random random=new Random();
                            	  int x_ran=random.nextInt(450);
                            	  int y_ran=random.nextInt(450);
                            	  enemy.add(new Enemy(x_ran,-y_ran));
								
						     	}
                              current_time=System.nanoTime();
							}
							for(int i=0;i<enemy.size();i++) {
								enemy.get(i).tick();
							}
								
							}
			public void render(Graphics g) {
				player.render(g);
				for(int i=0;i<bullet.size();i++) {
					if(bullet.get(i).getY()>50) {
					bullet.get(i).render(g);
					}
					else {
						bullet.remove(bullet);
					}
				}
				for(int i=0;i<enemy.size();i++) {
					if(enemy.get(i).getX()>=50 && enemy.get(i).getX()<=450-20
						&& enemy.get(i).getY()>=50 && enemy.get(i).getY()<=450-20) {
					enemy.get(i).render(g);
				}
					
					
				}
				//bullet and enemy collision
				for(int e=0;e<enemy.size();e++) {
					int ex=enemy.get(e).getX();
					int ey=enemy.get(e).getY();
					for(int b=0;b<bullet.size();b++) {
						int bx=bullet.get(b).getX();
						int by=bullet.get(b).getY();
						
						if(ex<bx+6 && ex+20>bx && ey<by+10 && ey+20>by)
						{
							enemy.remove(e);
							e--;
							bullet.remove(b);
							b--;
						}
						
						
					}
				
				}
				//player and enemy collision
				
				for(int e=0;e<enemy.size();e++) {
					int ex=enemy.get(e).getX();
					int ey=enemy.get(e).getY();
					
						int px=player.getX();
						int py=player.getY();

						if(ex<px+30 && ex+20>px && ey<py+30 && ey+20>py)
						{
							enemy.remove(e);
							
							e--;
						}
				
			}
		}
}

package SkyForce_MainFrame;
import java.awt.Graphics;
public class Game_Maintaining implements Runnable {
  
   private String title;
   private int width;
   private int height;
   private Thread  thread;
   private boolean running;
   private Graphics g;
   private  SkyForce_Frame display;
   public Game_Maintaining(String title,int width,int height){
  
      this.title = title;
      this.width = width;
      this.height = height;
  
   }
     public void init(){
         
       display = new SkyForce_Frame(title,width,height);
        }
  
    public synchronized void start(){
       if(running)
        return ;
       running = true;
       if(thread == null){
       thread = new Thread(this);
       thread.start();
       }
       
    }
    public synchronized void stop(){
       if(!(running))
           return;
           running = false;
       try {
          thread.join();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
    }
    
   
    
	   public void run() {
		   
	              init();
	       
	           }
  
   }


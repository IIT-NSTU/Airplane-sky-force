package SkyForce_MainFrame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SkyForce_Frame {

    private String title;
    private int width;
    private int height;
   private JButton cross_btn;
    public static JFrame frame;
    private  Canvas  canvas;
   
   
     public  SkyForce_Frame(String title,int width,int height){
       this.title = title;
        this.width = width;
        this.height= height;
        createDisplay();
       }

     public void createDisplay(){
      frame = new JFrame(title);
     
      frame.setSize(width,height);
      
      
      frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(28, 102, 221)));
      canvas = new Canvas();
      canvas.setPreferredSize(new Dimension(width,height));
      canvas.setBackground(new Color(14, 5, 3));
      
      canvas.setFocusable(false);
      frame.add(canvas);
      frame.pack();
     
     }
     
     public Canvas getCanvas(){
        return canvas;
     }
    

}

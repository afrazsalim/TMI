import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Visualize extends JPanel {
	 private ArrayList<Circle> list;


	public Visualize(ArrayList<Circle> list){
		 this.list = list;
		 JFrame f = new JFrame();
	     f.getContentPane().add(new TestPanel(), BorderLayout.CENTER);
	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     f.setSize(1400, 1200);
	     f.setVisible(true);
	     
	   
	 }
   
    
	
	
	
 class TestPanel extends JPanel{
	
	 public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < list.size(); i++) {
            draw(g,list,i);
        }
    }
    
    public void draw(Graphics g, ArrayList<Circle> list,int i) {
    	Random rand = new Random();
    	float r = rand.nextFloat();
    	float g3 = rand.nextFloat();
    	float b = rand.nextFloat();
    	Color c = new Color(r, g3, b);
    	g.setColor(c);
    	g.drawOval(300 +  (int) ( list.get(i).getX() ),300+ (int) (list.get(i).getY() ), (int) list.get(i).getRadius()*20 , (int) list.get(i).getRadius()*20);
       g.fillOval(300 +  (int) ( list.get(i).getX() ),300+ (int) (list.get(i).getY() ), (int) list.get(i).getRadius()*20 , (int) list.get(i).getRadius()*20);
    }
     
     
    
 }



	   

}

package HelperClasses;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Algorithms.IntersectionAlgo;


public class FrameClass extends JPanel implements ActionListener{
	
	private IntersectionAlgo inter;
	 boolean hasSelected = false;
	 private boolean hasRead = false;
	private JFrame frame;

	
	public FrameClass(IntersectionAlgo inter){
		this.inter = inter;
		
	}
	

	public boolean execute() {
		JFrame frame = new JFrame();
		frame.setName("Window");
		frame.setTitle("Window");
		frame.setSize(600, 200);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLACK);
		frame.setName("User Interface");
		JTextField field = new JTextField();
		JTextField fiel = new JTextField();
		JTextField fie = new JTextField();
		Font font = new Font("Courier", Font.ITALIC,18);
		field.setFont(font);
		field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		field.setBackground(Color.BLUE);
		field.setEditable(false);
		fiel.setFont(font);
		fie.setFont(font);
		fie.setBackground(Color.CYAN);
		fiel.setEditable(false);
		fie.setEditable(false);
		fiel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		fie.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		field.setText("1 in file stands for Qudratic time algorithm.");
		fiel.setText("2 in file stands for NlogN time algorithm.");
		fie.setText("3 in file stands for N+RlgN time algorithm.");
		JButton bt = new JButton();
		bt.setName("File chooser");
		bt.addActionListener(this);
		bt.setText("Click to select/choose the file");
		JPanel panel = new JPanel(new GridLayout());
		frame.setBackground(Color.BLACK);
		panel.add(field);
		panel.add(fiel);
		panel.add(fie);
		panel.add(bt);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setBackground(Color.BLACK);
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.pack();
		this.setFrame(frame);
		return this.hasRead();
		
	}


	private void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private Frame getFrame(){
		return this.frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
     if(e.getActionCommand().contains("Click to select/choose the file")){
    	 InputFrame frame = new InputFrame();
    	 File file = frame.getFile();
    	 hasRead = true;
    	 int res = 0;
    	 if(file != null)
    		 hasRead = true;
    	 if(file == null){
    		res = JOptionPane.showConfirmDialog(null, "You have not chosen a file, if you want to choose the file press yes and if you want to quit please press NO");
    		if(res == JOptionPane.YES_OPTION){
    		   this.actionPerformed(e);
    		}
    	 }
    	 else if(res == JOptionPane.NO_OPTION){
    		 JOptionPane.showMessageDialog(null, "You have not chosen a file , I am going to Exit");
    		 System.exit(ABORT);
    	 }
    	 else if(file != null){
    		 hasRead = true;
    		 this.inter.setFile(file);
    		 this.getFrame().dispose();
    	 }
      }
   }
	
	protected boolean hasSelected(){
		return this.hasSelected;
	}
	
	
	protected boolean hasRead(){
		return this.hasRead;
	}


	public void writeOutPoints(ArrayList<Double> points, double time) {
		JOptionPane.showMessageDialog(null, "Select a file to save intersection points\n" + "or select an alreay created file");
		BufferedWriter writer = null;
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		  File file = fileChooser.getSelectedFile();
		  try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		  try {
			  writer.append("Time take by this algorithm  is " + time + "\n");
			writer.append("Number of intersections " + points.get(points.size()-1)+"\n");
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		  for(int i = 0; i < points.size()-1;i= i+2){
			  try {
				  System.out.println("writing");
				writer.append("XCo =  :"+points.get(i));
				writer.append("    YCo =  :"+points.get(i+1)+"\n");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			  finally {
		            try {
		                writer.flush();
		            } catch (Exception e) {
		            	
		            }
		         }
		  }
 
		}
        JOptionPane.showMessageDialog(null, "Co-ordinates are written to the selected file");
	}
	
}

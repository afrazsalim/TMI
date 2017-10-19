package HelperClasses;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameComp {
	JFrame frame;
	public FrameComp(){
		frame = new JFrame();
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLACK);
	}
	
	public Frame getFrame(){
		return this.frame;
	}

	public void addFieldToFrame(JTextArea field, Frame f) {
		    JPanel panel = new JPanel();
		    panel.add(field);
		    JScrollPane scrollPane = new JScrollPane(panel);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
	        scrollPane.setBounds(0, 0, 50, 40);
	        JPanel contentPane = new JPanel(null);
	        contentPane.setPreferredSize(new Dimension(500, 400));
	        contentPane.add(scrollPane);
	        frame.setContentPane(contentPane);
	        frame.pack();
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setVisible(true);
	}

}

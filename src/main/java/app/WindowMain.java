package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowMain {

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(new Dimension(1000,1000));
		mainFrame.setTitle("Login Window");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new EventsDemoPanel2();
		BoxLayout vertical = new BoxLayout(panel1,BoxLayout.Y_AXIS);
		panel1.setLayout(vertical);
		panel1.setBackground(Color.LIGHT_GRAY);
		mainFrame.add(panel1);
		mainFrame.setVisible(true);
		EventsDemoPanel2 window = new EventsDemoPanel2();
	}

}
	class EventsDemoPanel2 extends JPanel {
		
		private JButton proverka = new JButton();
		
		public EventsDemoPanel2() {
			proverka.setText("DDSERROR");
			proverka.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) { 
					
				}
					
			});
			
			add(proverka,BorderLayout.CENTER);
			setVisible(true);
			setSize(600,600);
		}
	}

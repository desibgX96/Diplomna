package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class EventsDemoPanel2 extends JFrame {
	
	JPanel panel1 = new JPanel();
	BoxLayout vertical = new BoxLayout(panel1,BoxLayout.Y_AXIS);
	
	private JRadioButton proverka1 = new JRadioButton();
	private JRadioButton proverka2 = new JRadioButton();
	private JRadioButton proverka3 = new JRadioButton();
	private JRadioButton proverka4 = new JRadioButton();
	private JRadioButton proverka5 = new JRadioButton();
	private JButton proverka = new JButton();
	
	
	public EventsDemoPanel2() {
		proverka1.setText("DDSERROR");
		proverka2.setText("DDSERROR2");
		proverka3.setText("DDSERROR3");
		proverka4.setText("DDSERROR4");
		proverka5.setText("DDSERROR5");
		proverka.setText("Start data extraction");
		
		JPanel radioButtons = new JPanel();
		BoxLayout rbHorizontal = new BoxLayout(radioButtons,BoxLayout.X_AXIS);
		radioButtons.setLayout(rbHorizontal);
		radioButtons.add(proverka1);
		radioButtons.add(proverka2);
		radioButtons.add(proverka3);
		radioButtons.add(proverka4);
		radioButtons.add(proverka5);
		panel1.setLayout(vertical);
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.add(radioButtons);
		
		JPanel buttonFunc = new JPanel();
		BoxLayout bHorizontal = new BoxLayout(buttonFunc,BoxLayout.X_AXIS);
		buttonFunc.setLayout(bHorizontal);
		buttonFunc.add(proverka);
		panel1.add(buttonFunc);
		
		proverka.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				
			}
				
		});
		
		add(panel1);
		setTitle("Login Window");
		setSize(new Dimension(1000,1000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

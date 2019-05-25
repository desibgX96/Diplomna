package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	
	static JFrame mainFrame = new JFrame();
	
    public static void main( String[] args )
    {
    	//JFrame mainFrame = new JFrame();
		mainFrame.setSize(new Dimension(500,500));
		mainFrame.setTitle("Login Window");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new EventsDemoPanel();
		BoxLayout vertical = new BoxLayout(panel1,BoxLayout.Y_AXIS);
		panel1.setLayout(vertical);
		panel1.setBackground(Color.LIGHT_GRAY);
		mainFrame.add(panel1);
		mainFrame.setVisible(true);
		
    	//SpringApplication.run(App.class, args);
    }
    
    private static class EventsDemoPanel extends JPanel {
		private JTextField userName = createInputField();
		private JTextField userPass = createInputField();
		private JLabel userNameL = new JLabel("User Name:");
		private JLabel passwordL = new JLabel("Password:");
		private JButton login = new JButton();

		public EventsDemoPanel() {

			login.setText("Login");
			login.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) { 
					 String name = userName.getText(); 
					 String pass = userPass.getText(); 
					 File file = new File("E:\\diplomna\\Pass.txt"); 
					  
					  BufferedReader br;
					  String st; 
					try {
						br = new BufferedReader(new FileReader(file));
					  
						while ((st = br.readLine()) != null) {
							String[] userData = st.split(",");
							if(userData[0].equals(name) && userData[1].equals(pass)) {
								SpringApplication.run(App.class);
								mainFrame.setVisible(false);
								//new EventsDemoPanel2();
								//dispose();
							}
							else {
								JOptionPane.showMessageDialog(null,"Wrong username or password. Access denied!","ERROR",JOptionPane.ERROR_MESSAGE);
							}
						  }
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 

				}
			});
			JPanel helpFields = new JPanel();
			GridLayout contain = new GridLayout(0,2);
			helpFields.setLayout(contain);
			
			//add(Box.createRigidArea(new Dimension(50,20)));
			JPanel helpPanel = new JPanel();
			helpPanel.add(Box.createRigidArea(new Dimension(0,190)));
			helpPanel.add(userName);
			userNameL.setHorizontalAlignment(SwingConstants.RIGHT);
			helpFields.add(userNameL);
			helpFields.add(helpPanel);
			
			//add(Box.createRigidArea(new Dimension(20,10)));
			JPanel helpPanel1 = new JPanel();
			helpPanel1.add(Box.createRigidArea(new Dimension(0,190)));
			helpPanel1.add(userPass);
			passwordL.setHorizontalAlignment(SwingConstants.RIGHT);
			helpFields.add(passwordL);
			helpFields.add(helpPanel1);
			add(helpFields);
			//add(Box.createRigidArea(new Dimension(100,50)));
			JPanel helpPanel2 = new JPanel();
			helpPanel2.add(login);
			add(helpPanel2);
			
		}
		
		private JTextField createInputField() {
			JTextField inputText = new JTextField(15);
			inputText.setVisible(true); 
			return inputText;
		}
	}
}

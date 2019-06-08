package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	
	static JFrame mainFrame = new JFrame("Login");
	
    public static void main( String[] args )
    {
    	 mainFrame = new JFrame("Login");
    	 App log = new App();
         mainFrame.getContentPane().add(log.new LoginPanel());
         mainFrame.setResizable(false);
         mainFrame.getContentPane().setBackground(Color.BLACK);
         mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mainFrame.setLocationRelativeTo(null);
         mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

         mainFrame.pack();
         mainFrame.setLocationRelativeTo(null);
         mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

         mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
         });
         mainFrame.setVisible(true);
		
    	//SpringApplication.run(App.class, args);
    }
    
    final class LoginPanel extends JPanel {

    	   private final JLabel jlblUsername = new JLabel("Username:");
    	   private final JLabel jlblPassword = new JLabel("Password:");

    	   private final JTextField jtfUsername = new JTextField(15);
    	   private final JPasswordField jpfPassword = new JPasswordField(15);

    	   private final JButton jbtOk = new JButton("Login");
    	   private final JButton jbtCancel = new JButton("Cancel");

    	   private final JLabel jlblStatus = new JLabel(" ");

    	   public LoginPanel() {
    	      JPanel inputsPanel = new JPanel();

    	      BoxLayout boxLayout = new BoxLayout(inputsPanel, BoxLayout.X_AXIS);
    	      inputsPanel.setLayout(boxLayout);

    	      JPanel labelsPanel = new JPanel();
    	      BoxLayout labelsLayout = new BoxLayout(labelsPanel, BoxLayout.Y_AXIS);
    	      labelsPanel.setLayout(labelsLayout);
    	      jlblUsername.setAlignmentX(1);
    	      labelsPanel.add(jlblUsername);
    	      labelsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    	      jlblPassword.setAlignmentX(1);
    	      labelsPanel.add(jlblPassword);
    	      inputsPanel.add(Box.createRigidArea(new Dimension(40, 0)));
    	      inputsPanel.add(labelsPanel);
    	      inputsPanel.add(Box.createRigidArea(new Dimension(10, 0)));

    	      JPanel textFiledsPanel = new JPanel();
    	      BoxLayout textFieldLaout = new BoxLayout(textFiledsPanel, BoxLayout.Y_AXIS);
    	      textFiledsPanel.setLayout(textFieldLaout);
    	      textFiledsPanel.add(jtfUsername);
    	      textFiledsPanel.add(jpfPassword);

    	      inputsPanel.add(textFiledsPanel);
    	      inputsPanel.add(Box.createRigidArea(new Dimension(40, 0)));

    	      JPanel buttonsPanel = new JPanel();
    	      buttonsPanel.add(jbtOk);
    	      buttonsPanel.add(jbtCancel);

    	      JPanel southPanel = new JPanel(new BorderLayout());
    	      southPanel.add(buttonsPanel, BorderLayout.CENTER);
    	      southPanel.add(jlblStatus, BorderLayout.NORTH);
    	      jlblStatus.setForeground(Color.RED);
    	      jlblStatus.setHorizontalAlignment(SwingConstants.CENTER);

    	      setMinimumSize(new Dimension(400, 120));
    	      JPanel mainPanel = new JPanel(new GridLayout(2, 1, 5, 5));
    	      mainPanel.setBorder(BorderFactory.createEtchedBorder());
    	      mainPanel.add(inputsPanel);
    	      mainPanel.add(southPanel);
    	      add(mainPanel);

    	      jbtOk.addActionListener(new ActionListener() {
    	         @Override
    	         public void actionPerformed(ActionEvent e) {
    	        	 String name = jtfUsername.getText(); 
					 String pass = jpfPassword.getText(); 
					 File file = new File("E:\\diplomna\\Pass.txt"); 
					  //https://stackoverflow.com/questions/27962116/simplest-way-to-encrypt-a-text-file-in-java
					 //https://stackoverflow.com/questions/38931656/hide-password-in-text-file
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
								//JOptionPane.showMessageDialog(null,"Wrong username or password. Access denied!","ERROR",JOptionPane.ERROR_MESSAGE);
								jlblStatus.setText("Invalid username or password");
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
    	      jbtCancel.addActionListener(new ActionListener() {
    	         @Override
    	         public void actionPerformed(ActionEvent e) {
    	        	 mainFrame.setVisible(false);
    	         }
    	      });
    	   }
    	}
}

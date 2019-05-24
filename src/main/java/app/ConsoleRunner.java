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
import java.util.List;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import app.dto.ddsPurchases;
import app.model.Details;
import app.serialize.api.Seriaizer;
import app.service.api.DetailsServiseInterface;
import app.utils.DTOConvertUtil;


@Controller
public class ConsoleRunner implements CommandLineRunner {
	
	@Autowired
	private DetailsServiseInterface detailsService;

	@Autowired
	@Qualifier(value = "jsonserializer")
	private Seriaizer jsonSerializer;

	@Autowired
	@Qualifier(value = "xmlserializer")
	private Seriaizer xmlSerializer;

	@Override
	public void run(String... strings) throws Exception {
		 
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(new Dimension(500,500));
		mainFrame.setTitle("Login Window");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new EventsDemoPanel();
		BoxLayout vertical = new BoxLayout(panel1,BoxLayout.Y_AXIS);
		panel1.setLayout(vertical);
		panel1.setBackground(Color.LIGHT_GRAY);
		mainFrame.add(panel1);
		mainFrame.setVisible(true);

		// exportDDSMistakenEntrys();
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
								new WindowMain();
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
	
	 private void exportDDSMistakenEntrys() {
		 List<Details> details = detailsService.findDDSMistakenEntry();
		 Set<ddsPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,ddsPurchases.class);
		 
		 //Photographer3ExportDTOXMLWrapper listPhotographers = new Photographer3ExportDTOXMLWrapper();
		 //listPhotographers.setPhotographers(photogtaphetsDTOs);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/dds-mistake.json ");
	 }
	
}

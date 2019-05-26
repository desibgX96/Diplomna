package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class EventsDemoPanel2 extends JFrame {
	
	JPanel panel1 = new JPanel();
	BoxLayout vertical = new BoxLayout(panel1,BoxLayout.Y_AXIS);
	
	private JRadioButton proverka1 = new JRadioButton();
	private JRadioButton proverka2 = new JRadioButton();
	private JRadioButton proverka3 = new JRadioButton();
	private JRadioButton proverka4 = new JRadioButton();
	private JRadioButton proverka5 = new JRadioButton();
	//https://www.youtube.com/watch?v=iOV_oaJhABQ
	private JComboBox period1Date = new JComboBox();
	private JButton proverka = new JButton();
    JTable table = new JTable();
	
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
		
		String[] datesDay = {"--","01","02","03","04","05","06","07","08","09","10",
							"11","12","13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"};
		String[] datesMounth = {"--","01","02","03","04","05","06","07","08","09","10","11","12"};
		
		String[] datesYear = {"----","2015","2016","2017","2018"};
		
		JPanel buttonFunc = new JPanel();
		BoxLayout bHorizontal = new BoxLayout(buttonFunc,BoxLayout.X_AXIS);
		buttonFunc.setLayout(bHorizontal);
		buttonFunc.add(proverka);
		panel1.add(buttonFunc);
		
//https://www.youtube.com/watch?v=22MBsRYuM4Q
	        JPanel tablePanel = new JPanel();
	        tablePanel.setLayout(new BorderLayout());
	        Object[] colums = {"id","cr","db","sm"};
	     JTable table = new JTable();
	     DefaultTableModel model = new DefaultTableModel();
	     model.setColumnIdentifiers(colums);
	     table.setModel(model);
	     Object[] o = new Object[4];
	     o[0] = "aaaa";
	     o[1] = "bbbb";
	     o[2] = "cccc";
	     o[3] = "dddd";
	     model.addRow(o);

	        JScrollPane tableContainer = new JScrollPane(table);
	        tablePanel.add(tableContainer, BorderLayout.CENTER);
	        panel1.add(tablePanel);
		
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

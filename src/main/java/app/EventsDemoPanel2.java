package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

class EventsDemoPanel2 extends JFrame {
	
	JPanel panel1 = new JPanel();
	BoxLayout vertical = new BoxLayout(panel1,BoxLayout.Y_AXIS);
	
	private JRadioButton proverka1 = new JRadioButton();
	private JRadioButton proverka2 = new JRadioButton();
	private JRadioButton proverka3 = new JRadioButton();
	private JRadioButton proverka4 = new JRadioButton();
	private JRadioButton proverka5 = new JRadioButton();
	private JRadioButton proverka6 = new JRadioButton();
	//https://www.youtube.com/watch?v=iOV_oaJhABQ
	private JLabel beginPeriod = new JLabel("From: ");
	private JLabel endPeriod = new JLabel("To: ");
	private JComboBox<String> period1Year = new JComboBox<String>();
	private JComboBox<String> period1Month = new JComboBox<String>();
	private JComboBox<String> period1Day = new JComboBox<String>();
	private JComboBox<String> period2Year = new JComboBox<String>();
	private JComboBox<String> period2Month = new JComboBox<String>();
	private JComboBox<String> period2Day = new JComboBox<String>();
	private JButton proverka = new JButton();
    JTable table = new JTable();
	
	public EventsDemoPanel2() {
		proverka1.setText("DDSMistakenEntrys");
		proverka2.setText("DDSMistakenSales");
		proverka3.setText("MistakeInCostAccounts");
		proverka4.setText("MistakeInUnitCosts");
		proverka5.setText("MistakeInExpensesMaterialAccounts");
		proverka6.setText("MistakeInSaleAccount");
		proverka.setText("Start data extraction");
		
		JPanel radioButtons = new JPanel();
		BoxLayout rbHorizontal = new BoxLayout(radioButtons,BoxLayout.X_AXIS);
		radioButtons.setLayout(rbHorizontal);
		radioButtons.add(proverka1);
		radioButtons.add(proverka2);
		radioButtons.add(proverka3);
		radioButtons.add(proverka4);
		radioButtons.add(proverka5);
		radioButtons.add(proverka6);
		panel1.setLayout(vertical);
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.add(radioButtons);
		
		JPanel search1Dates = new JPanel();
		BoxLayout sd1Horizontal = new BoxLayout(search1Dates,BoxLayout.X_AXIS);
		String[] datesDay = {"--","01","02","03","04","05","06","07","08","09","10",
							"11","12","13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31"};
		for(int i = 0; i<datesDay.length;i++ ) {
			period1Day.addItem(datesDay[i]);
			period2Day.addItem(datesDay[i]);
		}
		String[] datesMounth = {"--","01","02","03","04","05","06","07","08","09","10","11","12"};
		for(int i = 0; i<datesMounth.length;i++ ) {
			period1Month.addItem(datesMounth[i]);
			period2Month.addItem(datesMounth[i]);
		}
		String[] datesYear = {"----","2015","2016","2017","2018"};
		for(int i = 0; i<datesYear.length;i++ ) {
			period1Year.addItem(datesYear[i]);
			period2Year.addItem(datesYear[i]);
		}
		search1Dates.add(beginPeriod);
		search1Dates.add(period1Year);
		search1Dates.add(period1Month);
		search1Dates.add(period1Day);
		panel1.add(search1Dates);
		
		JPanel search2Dates = new JPanel();
		BoxLayout sd2Horizontal = new BoxLayout(search2Dates,BoxLayout.X_AXIS);
		search2Dates.add(endPeriod);
		search2Dates.add(period2Year);
		search2Dates.add(period2Month);
		search2Dates.add(period2Day);
		panel1.add(search2Dates);
		
		
		JPanel buttonFunc = new JPanel();
		BoxLayout bHorizontal = new BoxLayout(buttonFunc,BoxLayout.X_AXIS);
		buttonFunc.setLayout(bHorizontal);
		buttonFunc.add(proverka);
		panel1.add(buttonFunc);
		
//https://www.youtube.com/watch?v=22MBsRYuM4Q
	        JPanel tablePanel = new JPanel();
	        tablePanel.setLayout(new BorderLayout());
	        final Object[] colums = {"line","debit","credit","amount","textOfEntry"};
	        DefaultTableModel modelN = new DefaultTableModel();
		    
		     modelN.setColumnIdentifiers(colums);
		     table.setModel(modelN);
		     Object[] o = new Object[5];
		     o[0] = "aaaa";
		     o[1] = "aaaa";
		     o[2] = "aaaa";
		     o[3] = "aaaa";
		     o[4] = "aaaa";
		     modelN.addRow(o);


	        JScrollPane tableContainer = new JScrollPane(table);
	        tablePanel.add(tableContainer, BorderLayout.CENTER);
	        panel1.add(tablePanel);
		
		proverka.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				 JTable table = new JTable();
			     DefaultTableModel model = new DefaultTableModel();
			    
			     model.setColumnIdentifiers(colums);
			     table.setModel(model);
				
				if(proverka1.isSelected()) {
					//ConsoleRunner cr = new ConsoleRunner();
					//Set<ddsPurchases> tableSet = cr.exportDDSMistakenEntrys();
					//for (ddsPurchases s : tableSet) {
				     Object[] o = new Object[5];
				     o[0] = "bbbb";//s.getLine();
				     o[1] = "bbbb";//s.getDebit();
				     o[2] = "bbbb";//s.getCredit();
				     o[3] = "bbbb";//s.getAmount();
				     o[4] = "bbbb";//s.getTextOfEntry();
				     model.addRow(o);

					//}
				}
				
				if(proverka2.isSelected()) {
					
				}
				if(proverka3.isSelected()) {
	
				}
				if(proverka4.isSelected()) {
	
				}
				if(proverka5.isSelected()) {
	
				}
				if(proverka6.isSelected()) {
					
				}
				table.tableChanged(new TableModelEvent(model));
			}
				
		});
		
		add(panel1);
		setTitle("Login Window");
		setSize(new Dimension(1000,1000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

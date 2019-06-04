package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.dto.DDSPurchases;

class EventsDemoPanel2 extends JFrame {
	
	JPanel panel1 = new JPanel();
	BoxLayout vertical = new BoxLayout(panel1,BoxLayout.Y_AXIS);
	
	private JCheckBox proverka1 = new JCheckBox();
	private JCheckBox proverka2 = new JCheckBox();
	private JCheckBox proverka3 = new JCheckBox();
	private JCheckBox proverka4 = new JCheckBox();
	private JCheckBox proverka5 = new JCheckBox();
	private JCheckBox proverka6 = new JCheckBox();
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
	private JButton save = new JButton();
	private JButton clear = new JButton();
    JTable table = new JTable();
	private final ConsoleRunner controler;
    
	public EventsDemoPanel2(final ConsoleRunner controler) {
		this.controler = controler;
		proverka1.setText("DDSMistakenEntrys");
		proverka2.setText("DDSMistakenSales");
		proverka3.setText("MistakeInCostAccounts");
		proverka4.setText("MistakeInUnitCosts");
		proverka5.setText("MistakeInExpensesMaterialAccounts");
		proverka6.setText("MistakeInSaleAccount");
		proverka.setText("Start data extraction");
		save.setText("Save table");
		clear.setText("Clear table");
		
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
		buttonFunc.add(save);
		buttonFunc.add(clear);
		panel1.add(buttonFunc);
		
//https://www.youtube.com/watch?v=22MBsRYuM4Q
	        JPanel tablePanel = new JPanel();
	        tablePanel.setLayout(new BorderLayout());
	        final Object[] colums = {"line","debit","credit","amount","textOfEntry","header id","journalNumber","period","docNr","docDate","refName"};
	        DefaultTableModel modelN = new DefaultTableModel();
		    
		     modelN.setColumnIdentifiers(colums);
		     table.setModel(modelN);


	        JScrollPane tableContainer = new JScrollPane(table);
	        tablePanel.add(tableContainer, BorderLayout.CENTER);
	        panel1.add(tablePanel);
		
		proverka.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
	
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(proverka1.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportDDSMistakenEntrys();
					for (DDSPurchases s : tableSet) {
				     Object[] o = new Object[11];
				     o[0] = s.getLine();
				     o[1] = s.getDebit();
				     o[2] = s.getCredit();
				     o[3] = s.getAmount();
				     o[4] = s.getTextOfEntry();
				     o[5] = s.getAccHeaderId().getId();
				     o[6] = s.getAccHeaderId().getJournalNumber();
				     o[7] = s.getAccHeaderId().getPeriod();
				     o[8] = s.getAccHeaderId().getDocNr();
				     o[9] = s.getAccHeaderId().getDocDate();
				     o[10] = s.getAccHeaderId().getRefName();
				     model.addRow(o);

					}
				}
				
				if(proverka2.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportDDSMistakenSales();
					for (DDSPurchases s : tableSet) {
						 Object[] o = new Object[11];
					     o[0] = s.getLine();
					     o[1] = s.getDebit();
					     o[2] = s.getCredit();
					     o[3] = s.getAmount();
					     o[4] = s.getTextOfEntry();
					     o[5] = s.getAccHeaderId().getId();
					     o[6] = s.getAccHeaderId().getJournalNumber();
					     o[7] = s.getAccHeaderId().getPeriod();
					     o[8] = s.getAccHeaderId().getDocNr();
					     o[9] = s.getAccHeaderId().getDocDate();
					     o[10] = s.getAccHeaderId().getRefName();
					     model.addRow(o);

					}
				}
				if(proverka3.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportMistakeInCostAccounts();
					for (DDSPurchases s : tableSet) {
						 Object[] o = new Object[11];
					     o[0] = s.getLine();
					     o[1] = s.getDebit();
					     o[2] = s.getCredit();
					     o[3] = s.getAmount();
					     o[4] = s.getTextOfEntry();
					     o[5] = s.getAccHeaderId().getId();
					     o[6] = s.getAccHeaderId().getJournalNumber();
					     o[7] = s.getAccHeaderId().getPeriod();
					     o[8] = s.getAccHeaderId().getDocNr();
					     o[9] = s.getAccHeaderId().getDocDate();
					     o[10] = s.getAccHeaderId().getRefName();
					     model.addRow(o);

					}
				}
				if(proverka4.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportMistakeInUnitCosts();
					for (DDSPurchases s : tableSet) {
						 Object[] o = new Object[11];
					     o[0] = s.getLine();
					     o[1] = s.getDebit();
					     o[2] = s.getCredit();
					     o[3] = s.getAmount();
					     o[4] = s.getTextOfEntry();
					     o[5] = s.getAccHeaderId().getId();
					     o[6] = s.getAccHeaderId().getJournalNumber();
					     o[7] = s.getAccHeaderId().getPeriod();
					     o[8] = s.getAccHeaderId().getDocNr();
					     o[9] = s.getAccHeaderId().getDocDate();
					     o[10] = s.getAccHeaderId().getRefName();
					     model.addRow(o);
					}
				}
				if(proverka5.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportMistakeInExpensesMaterialAccounts();
					for (DDSPurchases s : tableSet) {
						 Object[] o = new Object[11];
					     o[0] = s.getLine();
					     o[1] = s.getDebit();
					     o[2] = s.getCredit();
					     o[3] = s.getAmount();
					     o[4] = s.getTextOfEntry();
					     o[5] = s.getAccHeaderId().getId();
					     o[6] = s.getAccHeaderId().getJournalNumber();
					     o[7] = s.getAccHeaderId().getPeriod();
					     o[8] = s.getAccHeaderId().getDocNr();
					     o[9] = s.getAccHeaderId().getDocDate();
					     o[10] = s.getAccHeaderId().getRefName();
					     model.addRow(o);
					}
				}
				if(proverka6.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportMistakeInSaleAccount();
					for (DDSPurchases s : tableSet) {
						 Object[] o = new Object[11];
					     o[0] = s.getLine();
					     o[1] = s.getDebit();
					     o[2] = s.getCredit();
					     o[3] = s.getAmount();
					     o[4] = s.getTextOfEntry();
					     o[5] = s.getAccHeaderId().getId();
					     o[6] = s.getAccHeaderId().getJournalNumber();
					     o[7] = s.getAccHeaderId().getPeriod();
					     o[8] = s.getAccHeaderId().getDocNr();
					     o[9] = s.getAccHeaderId().getDocDate();
					     o[10] = s.getAccHeaderId().getRefName();
					     model.addRow(o);

					}
				}
				//table.tableChanged(new TableModelEvent(model));
			}
				
		});
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
	});
		
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
			
	});
		
		add(panel1);
		setTitle("Login Window");
		setSize(new Dimension(1200,600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.dto.DDSPurchases;
import app.dto.DDSPurchases2;

class MainPanel extends JFrame {

	JPanel panel1 = new JPanel();
	BoxLayout vertical = new BoxLayout(panel1, BoxLayout.Y_AXIS);

	private JCheckBox proverka1 = new JCheckBox();
	private JCheckBox proverka2 = new JCheckBox();
	private JCheckBox proverka3 = new JCheckBox();
	private JCheckBox proverka4 = new JCheckBox();
	private JCheckBox proverka5 = new JCheckBox();
	private JCheckBox proverka6 = new JCheckBox();
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
	
	private JLabel customCredit = new JLabel("Credit: ");
	private JLabel customDebit = new JLabel("Debit: ");
	private JTextField takeCredit = new JTextField();
	private JTextField takeDebit = new JTextField();
	
	JTable table = new JTable();
	private final ConsoleRunner controler;

	public MainPanel(final ConsoleRunner controler) {
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
		BoxLayout rbHorizontal = new BoxLayout(radioButtons, BoxLayout.X_AXIS);
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
		
		JPanel customCheck = new JPanel();
		BoxLayout cHorizontal = new BoxLayout(customCheck, BoxLayout.X_AXIS);
		customCheck.setLayout(cHorizontal);
		customCheck.add(Box.createRigidArea(new Dimension(400, 0)));
		customCheck.add(customDebit);
		customCheck.add(takeDebit);
		customCheck.add(Box.createRigidArea(new Dimension(20, 0)));
		customCheck.add(customCredit);
		customCheck.add(takeCredit);
		customCheck.add(Box.createRigidArea(new Dimension(400, 0)));
		panel1.add(customCheck);

		JPanel search1Dates = new JPanel();
		BoxLayout sd1Horizontal = new BoxLayout(search1Dates, BoxLayout.X_AXIS);
		String[] datesDay = { "--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		for (int i = 0; i < datesDay.length; i++) {
			period1Day.addItem(datesDay[i]);
			period2Day.addItem(datesDay[i]);
		}
		String[] datesMounth = { "--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		for (int i = 0; i < datesMounth.length; i++) {
			period1Month.addItem(datesMounth[i]);
			period2Month.addItem(datesMounth[i]);
		}
		String[] datesYear = { "----", "2015", "2016", "2017", "2018" };
		for (int i = 0; i < datesYear.length; i++) {
			period1Year.addItem(datesYear[i]);
			period2Year.addItem(datesYear[i]);
		}
		search1Dates.add(beginPeriod);
		search1Dates.add(period1Year);
		search1Dates.add(period1Month);
		search1Dates.add(period1Day);
		search1Dates.add(Box.createRigidArea(new Dimension(20, 0)));
		search1Dates.add(endPeriod);
		search1Dates.add(period2Year);
		search1Dates.add(period2Month);
		search1Dates.add(period2Day);
		panel1.add(search1Dates);

		JPanel buttonFunc = new JPanel();
		BoxLayout bHorizontal = new BoxLayout(buttonFunc, BoxLayout.X_AXIS);
		buttonFunc.setLayout(bHorizontal);
		buttonFunc.add(proverka);
		buttonFunc.add(Box.createRigidArea(new Dimension(20, 0)));
		buttonFunc.add(save);
		buttonFunc.add(Box.createRigidArea(new Dimension(20, 0)));
		buttonFunc.add(clear);
		panel1.add(buttonFunc);

		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		final Object[] colums = { "line", "debit", "credit", "amount", "textOfEntry", "header id", "journalNumber", "period", "docNr", "docDate", "refName" };
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
				if (proverka1.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportDDSMistakenEntrys();
					RestrictByDate(tableSet);
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

				if (proverka2.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportDDSMistakenSales();
					RestrictByDate(tableSet);
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
				if (proverka3.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportMistakeInCostAccounts();
					RestrictByDate(tableSet);
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
				if (proverka4.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportMistakeInUnitCosts();
					RestrictByDate(tableSet);
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
				if (proverka5.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportMistakeInExpensesMaterialAccounts();
					RestrictByDate(tableSet);
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
				if (proverka6.isSelected()) {
					Set<DDSPurchases> tableSet = controler.exportMistakeInSaleAccount();
					RestrictByDate(tableSet);
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
				
				if (!takeCredit.getText().isEmpty() && !takeDebit.getText().isEmpty()) {
					Set<DDSPurchases> tableSet = controler.exportCustomCheck(takeCredit.getText(),takeDebit.getText());
					RestrictByDate(tableSet);
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
				
			}

		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "JSON", "XML" };
				int x = JOptionPane.showOptionDialog(null, "Would you like to save the file as:  ",
						"Save as", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Set<DDSPurchases> tableSet = new HashSet<DDSPurchases>();
				for (int count = 0; count < model.getRowCount(); count++) {
					DDSPurchases row = new DDSPurchases();
					row.setLine((int) model.getValueAt(count, 0));
					row.setDebit(model.getValueAt(count, 1).toString());
					row.setCredit(model.getValueAt(count, 2).toString());
					row.setAmount((BigDecimal) model.getValueAt(count, 3));
					row.setTextOfEntry(model.getValueAt(count, 4).toString());
					DDSPurchases2 headerRow = new DDSPurchases2();
					headerRow.setId((double) model.getValueAt(count, 5));
					headerRow.setJournalNumber((double) model.getValueAt(count, 6));
					headerRow.setPeriod((Date) model.getValueAt(count, 7));
					headerRow.setDocNr(model.getValueAt(count, 8).toString());
					headerRow.setDocDate((Date) model.getValueAt(count, 9));
					headerRow.setRefName(model.getValueAt(count, 10).toString());
					row.setAccHeaderId(headerRow);
					tableSet.add(row);
				}
				if (x == 0) {
					controler.toFileJSON(tableSet);
				} else {
					controler.toFileXML(tableSet);
				}
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
		setSize(new Dimension(1200, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void RestrictByDate(final Set<DDSPurchases> detailsDTOs) {
		Set<DDSPurchases> remove = new HashSet<DDSPurchases>();
		if (!period1Year.getSelectedItem().equals("----") && !period2Year.getSelectedItem().equals("----") &&
				!period1Month.getSelectedItem().equals("--") && !period2Month.getSelectedItem().equals("--") &&
				!period1Day.getSelectedItem().equals("--") && !period2Day.getSelectedItem().equals("--")) {
			for (DDSPurchases s : detailsDTOs) {
				java.util.Date begins = null;
				java.util.Date ends = null;
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String date1 = period1Year.getSelectedItem() + "-" + period1Month.getSelectedItem() + "-" +
				period1Day.getSelectedItem();
				try {
					begins = df.parse(date1);
					String date2 = period2Year.getSelectedItem() + "-" + period2Month.getSelectedItem() + "-" +
					period2Day.getSelectedItem();
					ends = df.parse(date2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date toCheck = (Date) s.getAccHeaderId().getPeriod();
				if (!(toCheck.after(begins) && toCheck.before(ends))) {
					remove.add(s);
				}
			}
		}
		remove.stream().forEach(o -> detailsDTOs.remove(o));
		
	}
}

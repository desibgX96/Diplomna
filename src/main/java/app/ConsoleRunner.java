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
import javax.swing.JRadioButton;
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
/*
	@Autowired
	@Qualifier(value = "xmlserializer")
	private Seriaizer xmlSerializer;
*/
	@Override
	public void run(String... strings) throws Exception {

		EventsDemoPanel2 window = new EventsDemoPanel2();
		 exportDDSMistakenEntrys();
		 exportDDSMistakenSales();
	}
	
	
	 private void exportDDSMistakenEntrys() {
		 List<Details> details = detailsService.findDDSMistakenEntry();
		 Set<ddsPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,ddsPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/dds-mistake.json");
	 }
		
	 private void exportDDSMistakenSales() {
		 List<Details> details = detailsService. findDDSMistakenSale();
		 Set<ddsPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,ddsPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/dds-mistake2.json");
	 }
	
}


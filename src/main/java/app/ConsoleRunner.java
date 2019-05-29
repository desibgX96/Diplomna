package app;

import java.util.List;
import java.util.Set;

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
		// exportDDSMistakenEntrys();
		 exportDDSMistakenSales();
		 exportMistakeInCostAccounts();
		 exportMistakeInUnitCosts() ;
		 exportMistakeInExpensesMaterialAccounts();
		 exportMistakeInSaleAccount();
	}
	
	
	 public Set<ddsPurchases> exportDDSMistakenEntrys() {
		 List<Details> details = detailsService.findDDSMistakenEntry();
		 Set<ddsPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,ddsPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/dds-mistake.json");
		 return photogtaphetsDTOs;
	 }
		
	 private void exportDDSMistakenSales() {
		 List<Details> details = detailsService. findDDSMistakenSale();
		 Set<ddsPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,ddsPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/dds-mistake2.json");
	 }
	
	 private void exportMistakeInCostAccounts() {
		 List<Details> details = detailsService.findMistakeInCostAccounts();
		 Set<ddsPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,ddsPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/cost-accounts-mistake.json");
	 }
		
	 private void exportMistakeInUnitCosts() {
		 List<Details> details = detailsService. findMistakeInUnitCosts();
		 Set<ddsPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,ddsPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/unit-costs-mistake.json");
	 }	
	 private void exportMistakeInExpensesMaterialAccounts() {
		 List<Details> details = detailsService.findMistakeInExpensesMaterialAccounts();
		 Set<ddsPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,ddsPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/expenses-material-accounts-mistake.json");
	 }
		
	 private void exportMistakeInSaleAccount() {
		 List<Details> details = detailsService. findMistakeInSaleAccount();
		 Set<ddsPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,ddsPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/sale-account-mistake2.json");
	 }
		
}


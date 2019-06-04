package app;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import app.dto.DDSPurchases;
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

		EventsDemoPanel2 window = new EventsDemoPanel2(this);
		 //exportDDSMistakenEntrys();
		//exportDDSMistakenSales();
		 //exportMistakeInCostAccounts();
		// exportMistakeInUnitCosts() ;
		// exportMistakeInExpensesMaterialAccounts();
		// exportMistakeInSaleAccount();
	}
	
	
	 public Set<DDSPurchases> exportDDSMistakenEntrys() {
		 List<Details> details = detailsService.findDDSMistakenEntry();
		 Set<DDSPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,DDSPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/dds-mistake.json");
		 return photogtaphetsDTOs;
	 }
		
	 public Set<DDSPurchases> exportDDSMistakenSales() {
		 List<Details> details = detailsService. findDDSMistakenSale();
		 Set<DDSPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,DDSPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/dds-mistake2.json");
		 return photogtaphetsDTOs;
	 }
	
	 public Set<DDSPurchases> exportMistakeInCostAccounts() {
		 List<Details> details = detailsService.findMistakeInCostAccounts();
		 Set<DDSPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,DDSPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/cost-accounts-mistake.json");
		 return photogtaphetsDTOs;
	 }
		
	 public Set<DDSPurchases> exportMistakeInUnitCosts() {
		 List<Details> details = detailsService. findMistakeInUnitCosts();
		 Set<DDSPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,DDSPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/unit-costs-mistake.json");
		 return photogtaphetsDTOs;
	 }	
	 public Set<DDSPurchases> exportMistakeInExpensesMaterialAccounts() {
		 List<Details> details = detailsService.findMistakeInExpensesMaterialAccounts();
		 Set<DDSPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,DDSPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/expenses-material-accounts-mistake.json");
		 return photogtaphetsDTOs;
	 }
		
	 public Set<DDSPurchases> exportMistakeInSaleAccount() {
		 List<Details> details = detailsService. findMistakeInSaleAccount();
		 Set<DDSPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,DDSPurchases.class);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/sale-account-mistake2.json");
		 return photogtaphetsDTOs;
	 }
		
}


package app;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import app.dto.DDSPurchases;
import app.dto.DDSPurchasesToXML;
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

		MainPanel window = new MainPanel(this);
	}
	
	public void toFileJSON(Set<DDSPurchases> detailsDTOs) {
		jsonSerializer.serialize(detailsDTOs, "src/main/resources/output/Accounting Mistakes.json");
	}

	public void toFileXML(Set<DDSPurchases> detailsDTOs) {
		DDSPurchasesToXML wrapper = new DDSPurchasesToXML();
		wrapper.setlistMistakes(detailsDTOs);
		xmlSerializer.serialize(wrapper, "src/main/resources/output/Accounting Mistakes.xml");
	}

	public Set<DDSPurchases> exportDDSMistakenEntrys() {
		List<Details> details = detailsService.findDDSMistakenEntry();
		Set<DDSPurchases> detailsDTOs = DTOConvertUtil.convertToSet(details, DDSPurchases.class);
		return detailsDTOs;
	}

	public Set<DDSPurchases> exportDDSMistakenSales() {
		List<Details> details = detailsService.findDDSMistakenSale();
		Set<DDSPurchases> detailsDTOs = DTOConvertUtil.convertToSet(details, DDSPurchases.class);
		return detailsDTOs;
	}

	public Set<DDSPurchases> exportMistakeInCostAccounts() {
		List<Details> details = detailsService.findMistakeInCostAccounts();
		Set<DDSPurchases> detailsDTOs = DTOConvertUtil.convertToSet(details, DDSPurchases.class);
		return detailsDTOs;
	}

	public Set<DDSPurchases> exportMistakeInUnitCosts() {
		List<Details> details = detailsService.findMistakeInUnitCosts();
		Set<DDSPurchases> detailsDTOs = DTOConvertUtil.convertToSet(details, DDSPurchases.class);
		return detailsDTOs;
	}

	public Set<DDSPurchases> exportMistakeInExpensesMaterialAccounts() {
		List<Details> details = detailsService.findMistakeInExpensesMaterialAccounts();
		Set<DDSPurchases> detailsDTOs = DTOConvertUtil.convertToSet(details, DDSPurchases.class);
		return detailsDTOs;
	}

	public Set<DDSPurchases> exportMistakeInSaleAccount() {
		List<Details> details = detailsService.findMistakeInSaleAccount();
		Set<DDSPurchases> detailsDTOs = DTOConvertUtil.convertToSet(details, DDSPurchases.class);
		return detailsDTOs;
	}
	
	public Set<DDSPurchases> exportCustomCheck(String credit, String debit) {
		List<Details> details = detailsService.findCustomDetail(credit, debit);
		Set<DDSPurchases> detailsDTOs = DTOConvertUtil.convertToSet(details, DDSPurchases.class);
		return detailsDTOs;
	}

}

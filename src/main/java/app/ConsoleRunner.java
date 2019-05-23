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

	@Autowired
	@Qualifier(value = "xmlserializer")
	private Seriaizer xmlSerializer;

	@Override
	public void run(String... strings) throws Exception {
		 
		 exportDDSMistakenEntrys();
	}
	
	 private void exportDDSMistakenEntrys() {
		 List<Details> details = detailsService.findDDSMistakenEntry();
		 Set<ddsPurchases> photogtaphetsDTOs = DTOConvertUtil.convertToSet(details,ddsPurchases.class);
		 
		 //Photographer3ExportDTOXMLWrapper listPhotographers = new Photographer3ExportDTOXMLWrapper();
		 //listPhotographers.setPhotographers(photogtaphetsDTOs);
		 jsonSerializer.serialize(photogtaphetsDTOs, "src/main/resources/output/dds-mistake.json ");
	 }
	
}

package app.dto;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Details")
@XmlAccessorType(XmlAccessType.FIELD)
public class DDSPurchasesToXML {

	@XmlElement(name = "mistakes")
	private Set<DDSPurchases> listMistakes;

	public Set<DDSPurchases> getlistMistakes() {
		return listMistakes;
	}

	public void setlistMistakes(Set<DDSPurchases> listMistakes) {
		this.listMistakes = listMistakes;
	}
	
}

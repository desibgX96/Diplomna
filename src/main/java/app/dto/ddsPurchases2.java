package app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.google.gson.annotations.Expose;

@XmlAccessorType(XmlAccessType.FIELD)
public class DDSPurchases2 implements Serializable{
	
	@XmlElement
	@Expose
	private double id;
	
	@XmlElement
	@Expose
	private double journalNumber;
	
	@XmlElement
	@Expose
    private Date period;

	@XmlElement
	@Expose
	private String docNr;
	
	@XmlElement
	@Expose
	private Date docDate;

	@XmlElement
	@Expose
	private String refName;

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public double getJournalNumber() {
		return journalNumber;
	}

	public void setJournalNumber(double journalNumber) {
		this.journalNumber = journalNumber;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public String getDocNr() {
		return docNr;
	}

	public void setDocNr(String docNr) {
		this.docNr = docNr;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

}

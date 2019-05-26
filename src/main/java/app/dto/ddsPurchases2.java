package app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.google.gson.annotations.Expose;

@XmlAccessorType(XmlAccessType.FIELD)
public class ddsPurchases2 implements Serializable{
	
	@Expose
	private double id;
	
	@Expose
	private double journalNumber;
	
	@Expose
    private Date period;

	@Expose
	private String docNr;
	
	@Expose
	private Date docDate;

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

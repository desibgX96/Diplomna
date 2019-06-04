package app.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "AccHeader")
public class Header {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private double id;

	@Basic
	@NotNull
	@Column(name = "FIRM")
	private short firm;

	@Basic
	@NotNull
	@Column(name = "JOURNAL_NUMBER")
	private double journalNumber;

	@Basic
	@Column(name = "PERIOD")
	private Date period;
	
	@Basic
	@NotNull
	@Column(name = "DOC_TYPE")
	private short docType;
	
	@Basic
	@Column(name = "DOC_NR")
	private String docNr;
	
	@Basic
	@Column(name = "DOC_DATE")
	private Date docDate;
	
	@Basic
	@Column(name = "OPERATION_KIND")
	private short operationKind;
	
	@Basic
	@Column(name = "STATUS")
	private short status;
	
	@Basic
	@Column(name = "TEXT_OF_ENTRY")
	private String textOFEntry;
	
	@Basic
	@Column(name = "REF_NR")
	private String refNr;
	
	@Basic
	@Column(name = "REF_NAME")
	private String refName;
	
	@Basic
	@Column(name = "CREATED_ON")
	private Date createdOn;
	
	@Basic
	@Column(name = "CHANGED_ON",nullable = true)
	private Date changededOn;

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public Date getChangededOn() {
		return changededOn;
	}

	public void setChangededOn(Date changededOn) {
		this.changededOn = changededOn;
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

	public short getFirm() {
		return firm;
	}

	public void setFirm(short firm) {
		this.firm = firm;
	}

	public short getDocType() {
		return docType;
	}

	public void setDocType(short docType) {
		this.docType = docType;
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

	public short getOperationKind() {
		return operationKind;
	}

	public void setOperationKind(short operationKind) {
		this.operationKind = operationKind;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getTextOFEntry() {
		return textOFEntry;
	}

	public void setTextOFEntry(String textOFEntry) {
		this.textOFEntry = textOFEntry;
	}

	public String getRefNr() {
		return refNr;
	}

	public void setRefNr(String refNr) {
		this.refNr = refNr;
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	
}
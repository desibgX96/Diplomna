package app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Null;


@Entity
//@IdClass(CompositeKey.class)
@Table(name = "acc_detail")
public class Details implements Serializable{

	@EmbeddedId 
	CompositeKey detailsKey;
	
	@Basic
	@Column(name = "DEBIT")
	String debit;
	
	@Basic
	@Column(name = "CREDIT")
	String credit;
	
	@Basic
	@Column(name = "AMOUNT")
	BigDecimal amount;
	
	@Basic
	@Column(name = "TEXT_OF_ENTRY")
	String textOfEntry;

	@Basic
	@Column(name = "CREATED_ON",nullable = true)
	private Date createdOn;
	
	@Basic
	@Column(name = "CHANGED_ON",nullable = true)
	private Date changedOn;

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}

	public CompositeKey getDetailsKey() {
		return detailsKey;
	}

	public void setDetailsKey(CompositeKey detailsKey) {
		this.detailsKey = detailsKey;
	}

	public String getDebit() {
		return debit;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTextOfEntry() {
		return textOfEntry;
	}

	public void setTextOfEntry(String textOfEntry) {
		this.textOfEntry = textOfEntry;
	}
	
}

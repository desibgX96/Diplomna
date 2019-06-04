package app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "acc_detail")
public class Details implements Serializable{

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACC_HEADER_ID")
    private Header accHeaderId;
	
	@NotNull
	@Column(name = "LINE")
    private int line;
    
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Header getAccHeaderId() {
		return accHeaderId;
	}

	public void setAccHeaderId(Header accHeaderId) {
		this.accHeaderId = accHeaderId;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
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

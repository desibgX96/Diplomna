package app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
//@IdClass(CompositeKey.class)
@Table(name = "acc_detail")
public class Details implements Serializable{
	/*          https://stackoverflow.com/questions/40058001/error-creating-bean-with-name-entitymanagerfactory-defined-in-class-path-resou
	@Id
	@NotNull
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACC_HEADER_ID")
	Header accHeaderId;
	
	@Id
	@NotNull
	int line;
	*/
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
	@Column(name = "ITEM_CLASS")
	short itemClass;
	
	@Basic
	@Column(name = "CREATED_ON")
	private Date createdOn;
	
	@Basic
	@Column(name = "CHANGED_ON")
	private Date changedOn;
	
	@Basic
	@Column(name = "LINE_TYPE")
	String lineType;

	public short getItemClass() {
		return itemClass;
	}

	public void setItemClass(short itemClass) {
		this.itemClass = itemClass;
	}

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

	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
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

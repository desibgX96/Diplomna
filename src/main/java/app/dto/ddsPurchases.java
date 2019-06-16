package app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.google.gson.annotations.Expose;

@XmlAccessorType(XmlAccessType.FIELD)
public class DDSPurchases implements Serializable {
	@XmlElement
	@Expose
	DDSPurchases2 accHeaderId;

	@XmlElement
	@Expose
	int line;

	@XmlElement
	@Expose
	String debit;

	@XmlElement
	@Expose
	String credit;

	@XmlElement
	@Expose
	BigDecimal amount;

	@XmlElement
	@Expose
	String textOfEntry;

	public DDSPurchases2 getAccHeaderId() {
		return accHeaderId;
	}

	public void setAccHeaderId(DDSPurchases2 accHeaderId) {
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

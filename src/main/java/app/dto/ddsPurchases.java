package app.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import app.model.Header;

@XmlAccessorType(XmlAccessType.FIELD)
public class ddsPurchases implements Serializable {
	@XmlTransient
	@Expose
	Header accHeaderId;

	@XmlTransient
	@Expose
	int line;

	@XmlTransient
	@Expose
	String debit;

	@XmlTransient
	@Expose
	String credit;

	@XmlTransient
	@Expose
	BigDecimal amount;

	@XmlTransient
	@Expose
	String textOfEntry;

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

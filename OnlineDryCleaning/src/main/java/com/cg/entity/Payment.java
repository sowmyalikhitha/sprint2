package com.cg.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment_table")
public class Payment {
	@Id
	@Column(name="payment_id")
	private long paymentId;
	@Column(name="type")
	private String type;
	@Column(name="status")
	private String status;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Card card;
	
	
	public Payment(long paymentId, String type, String status, Card card) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card=card;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card +"]";
	}
}
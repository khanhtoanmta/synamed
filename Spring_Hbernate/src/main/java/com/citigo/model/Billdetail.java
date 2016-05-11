package com.citigo.model;
// Generated Apr 22, 2016 11:54:43 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Billdetail generated by hbm2java
 */
@Entity
@Table(name = "BILLDETAIL", schema = "QLBH_DB")
public class Billdetail implements java.io.Serializable {

	private BigDecimal id;
	private Bill bill;
	private Product product;
	private BigDecimal quantity;
	private Double intomoney;

	public Billdetail() {
	}

	public Billdetail(BigDecimal id) {
		this.id = id;
	}

	public Billdetail(BigDecimal id, Bill bill, Product product, BigDecimal quantity, Double intomoney) {
		this.id = id;
		this.bill = bill;
		this.product = product;
		this.quantity = quantity;
		this.intomoney = intomoney;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BILL_ID")
	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "QUANTITY", precision = 22, scale = 0)
	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Column(name = "INTOMONEY", precision = 126, scale = 0)
	public Double getIntomoney() {
		return this.intomoney;
	}

	public void setIntomoney(Double intomoney) {
		this.intomoney = intomoney;
	}

}

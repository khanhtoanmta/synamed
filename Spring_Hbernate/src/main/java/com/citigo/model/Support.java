package com.citigo.model;
// Generated Apr 22, 2016 11:54:43 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Support generated by hbm2java
 */
@Entity
@Table(name = "SUPPORT", schema = "QLBH_DB")
public class Support implements java.io.Serializable {

	private BigDecimal id;
	private String name;
	private String tel;
	private String nick;
	private BigDecimal status;
	private BigDecimal orderSp;

	public Support() {
	}

	public Support(BigDecimal id) {
		this.id = id;
	}

	public Support(BigDecimal id, String name, String tel, String nick, BigDecimal status, BigDecimal orderSp) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.nick = nick;
		this.status = status;
		this.orderSp = orderSp;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 500)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TEL", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "NICK", length = 100)
	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Column(name = "STATUS", precision = 22, scale = 0)
	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	@Column(name = "ORDER_SP", precision = 22, scale = 0)
	public BigDecimal getOrderSp() {
		return this.orderSp;
	}

	public void setOrderSp(BigDecimal orderSp) {
		this.orderSp = orderSp;
	}

}

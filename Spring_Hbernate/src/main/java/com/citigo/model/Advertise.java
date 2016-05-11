package com.citigo.model;
// Generated Apr 22, 2016 11:54:43 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Advertise generated by hbm2java
 */
@Entity
@Table(name = "ADVERTISE", schema = "QLBH_DB")
public class Advertise implements java.io.Serializable {

	private BigDecimal id;
	private String name;
	private String url;
	private BigDecimal width;
	private BigDecimal height;
	private String link;
	private BigDecimal target;
	private BigDecimal position;
	private BigDecimal status;

	public Advertise() {
	}

	public Advertise(BigDecimal id) {
		this.id = id;
	}

	public Advertise(BigDecimal id, String name, String url, BigDecimal width, BigDecimal height, String link,
			BigDecimal target, BigDecimal position, BigDecimal status) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.width = width;
		this.height = height;
		this.link = link;
		this.target = target;
		this.position = position;
		this.status = status;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "URL", length = 100)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "WIDTH", precision = 22, scale = 0)
	public BigDecimal getWidth() {
		return this.width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	@Column(name = "HEIGHT", precision = 22, scale = 0)
	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	@Column(name = "LINK", length = 500)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "TARGET", precision = 22, scale = 0)
	public BigDecimal getTarget() {
		return this.target;
	}

	public void setTarget(BigDecimal target) {
		this.target = target;
	}

	@Column(name = "POSITION", precision = 22, scale = 0)
	public BigDecimal getPosition() {
		return this.position;
	}

	public void setPosition(BigDecimal position) {
		this.position = position;
	}

	@Column(name = "STATUS", precision = 22, scale = 0)
	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

}

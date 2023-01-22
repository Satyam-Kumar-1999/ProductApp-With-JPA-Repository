/**
 * 
 */
package com.springboot.app.products.Model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author SATYAM
 *
 */
@Entity
@Table(name="products")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"manufactureDate","updatedDate"}, allowGetters = true)
public class Products implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="productName" )
	private String productName;
	
	@Column(name="productQuality" )
	private String productQuality;
	
	@Column(name="productVersion" ) 
	private String productVersion;
	
	@Column(name="productModel" )
	private String productModel;
	
	@Column(name="manufactureDate", nullable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date manufactureDate;
	
	@Column(name="updatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate; 

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(long id, String productName, String productQuality, String productVersion, String productModel,
			Date manufactureDate, Date updatedDate) {
		super();
		this.id = id;
		this.productName = productName;
		this.productQuality = productQuality;
		this.productVersion = productVersion;
		this.productModel = productModel;
		this.manufactureDate = manufactureDate;
		this.updatedDate = updatedDate;
	}

	public Products(String productName, String productQuality, String productVersion, String productModel,
			Date manufactureDate, Date updatedDate) {
		super();
		this.productName = productName;
		this.productQuality = productQuality;
		this.productVersion = productVersion;
		this.productModel = productModel;
		this.manufactureDate = manufactureDate;
		this.updatedDate = updatedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductQuality() {
		return productQuality;
	}

	public void setProductQuality(String productQuality) {
		this.productQuality = productQuality;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
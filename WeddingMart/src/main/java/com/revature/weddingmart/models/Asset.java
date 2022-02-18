package com.revature.weddingmart.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="asset",
	uniqueConstraints={
			@UniqueConstraint(columnNames ={"email","type_id"})
			}
)
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private int id;
	@Column()
	private String email;
	@Column()
	private String name;
	@Column()
	private String phone;
	@Column()
	private double price;
	@Column()
	private String address;
	@ManyToOne(optional=false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="type_id", unique=false, nullable=false, updatable=true)
	private AssetType type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AssetType getType() {
		return type;
	}

	public void setType(AssetType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, id, name, phone, price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asset other = (Asset) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", email=" + email + ", name=" + name + ", phone=" + phone + ", price=" + price
				+ ", address=" + address + ", type=" + type + "]";
	}
	
	
}
